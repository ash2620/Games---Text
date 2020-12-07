import java.util.*;
class Mastermind{

	static Random r = new Random();
	static Scanner sc = new Scanner(System.in);
	static char[] colors = {'R','G','B','W','Y','O'};
	static char[] code = new char[4];
	static char[] guess = new char[4];
	static boolean[] fg = new boolean[4];
	static boolean solved = false;


	public static void main(String[] args) {
		int count = 1;
		SetCode();
		while(!solved && count <= 12){
			input();
			compare();
			count++;
		}

		if (!solved) {
			System.out.println("You lost\nCode was : "+String.valueOf(code));
		}
		else{
			System.out.println("You won\nCode was : "+String.valueOf(code));
		}
	}

	public static void SetCode(){
		int c = 0;
		for (int i = 0; i < 4 ;i++ ) {
			c = r.nextInt(5);
			code[i] = colors[c];
			System.err.print(code[i]);
		}
	}

	public static void input(){
		System.out.println("Enter your guess as a 4 letter string using (R,G,B,W,Y,O)");
		String in = sc.nextLine();
		for(int i=0; i<4;i++){
			guess[i] = in.charAt(i);
		}

	}

	public static void compare(){
		int whitePin = 0;
		int redPin = 0;
		for(int i=0;i<4;i++){
			fg[i] = false;
		}

		for (int i =0;i<4 ;i++ ) {
			if (guess[i]!=code[i]) {
				solved = false;
				break;
			}
			solved = true;
		}

		if(!solved){
			for(int i = 0;i<4;i++){
				for (int x=0;x<4 ;x++ ) {
					if(i==x){
						if (guess[i]==code[x] && !fg[x]) {
							redPin++;
							fg[x] = true;
							break;
						}
					}
				}
					
			}
			for(int i=0;i<4;i++){
				for (int x =0;x<4 ;x++ ) {
						if(i!=x){
							if (guess[i]==code[x] && !fg[x]) {
								whitePin++;
								fg[x] = true;
								break;
							}
						}
					}
			}

			System.out.println("No. of red pins - "+redPin);
			System.out.println("No. of white pins - "+whitePin);
		}
	}



}