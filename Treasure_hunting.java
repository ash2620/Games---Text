import java.util.Scanner;
import java.util.Random;
public class Treasure_hunting
{
  public static void main()
   {
        Scanner sc= new Scanner(System.in);
        Random ra= new Random();
        int[][]board= new int[5][5];
        int[][]treasure= new int[3][2];
        int[]dig=new int[2];
        int c=ra.nextInt(25);
        int attempts=0;
        int shotHit=0;
        String[]letters={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String cheat_actual=letters[c];
        System.err.println(cheat_actual);
        initBoard(board);
        inittreasure(treasure);
        System.out.println("This is a treasure hunting game in where you have to find the three hidden treasures");
        System.out.println("Enter the row then the column to check if you found a treasure");
        System.out.println("Enter cheat(if you do not know it just enter something to start playing): ");
        String cheat=sc.nextLine();
        System.out.println();
        do{  
            if(cheat.equals(cheat_actual)){
             break;
            }
            else{
            showBoard(board);
            dig(dig);
            attempts++;
            if(found(dig,treasure))
            {
              hint(dig,treasure,attempts);
                shotHit++;
            }
            else
              hint(dig,treasure,attempts);
              change(dig,treasure,board);
        }
       }
        while(shotHit!=3);
        System.out.println("Treasure hunting game is over you found 3 treasures in "+attempts+" attempts");
        showBoard(board);
        if(attempts<=3)
        System.out.println("Congratulations you have the world record!!!!!!!!!!!!!");
    }
    public static void initBoard(int[][]board)
    {
        for(int row=0;row<5;row++)
        for(int column=0;column<5;column++)
        board[row][column]=-1;
    }
    public static void showBoard(int[][]board)
    {
        System.out.println("\t1\t2\t3\t4\t5");
        System.out.println();
        for(int row=0;row<5;row++)
        {
            System.out.print((row+1)+"");
            for(int column=0;column<5;column++)
            {
                if(board[row][column]==-1)
                {
                System.out.print("\t"+"*");
                }
              else if(board[row][column]==0)
              {
                  System.out.print("\t"+"#");
                }
                else if(board[row][column]==1)
                {
                System.out.print("\t"+"x");
            }
        }
        System.out.println();
    }
  }
  public static void inittreasure(int[][]treasure)
  {
      Random ra= new Random();
      for(int loc=0;loc<3;loc++)
      {
          treasure[loc][0]=ra.nextInt(5);
          treasure[loc][1]=ra.nextInt(5);
          for(int last=0;last<loc;last++)
          {
              if((treasure[loc][0]==treasure[last][0])&&(treasure[loc][1]==treasure[last][1]))
              do{
                  treasure[loc][0]=ra.nextInt(5);
                  treasure[loc][1]=ra.nextInt(5);
                }
                while((treasure[loc][0]==treasure[last][0])&&(treasure[loc][1]==treasure[last][1]));
            }
        }
    }
    public static void dig(int[]dig)
    {
        Scanner sc= new Scanner(System.in);
        Random ra=new Random();
        System.out.println("Row(enter 0 to quit): ");
         dig[0]=sc.nextInt();
        dig[0]--;
        int a=10;
        int b=1;
        int random=ra.nextInt((a-b)+1)+b;
        if(dig[0]==-1){
           System.exit(-1);
          }
         System.out.println("Column: ");
        dig[1]=sc.nextInt();
        dig[1]--;
    }
  
    public static boolean found(int[]dig,int[][]treasure)
    {
        for(int loc=0;loc<treasure.length;loc++)
        {
            if(dig[0]==treasure[loc][0]&&dig[1]==treasure[loc][1])
            {
                System.out.printf("You found a treasure located in(%d,%d)\n",dig[0]+1,dig[1]+1);
                return true;
            }
        }
        return false;
    }
    public static void change(int[]dig,int[][]treasure,int[][]board)
    {
        if(found(dig,treasure))
        board[dig[0]][dig[1]]=1;
        else
        board[dig[0]][dig[1]]=0;
    }
        public static void hint(int[] dig, int[][] treasure, int attempt){
       Scanner sc=new Scanner(System.in);
       int a=1;
       int hint;
      
         int row=0,
           column=0;
        
        for(int line=0 ; line < treasure.length ; line++){
            if(treasure[line][0]==dig[0])
                row++;
            if(treasure[line][1]==dig[1])
                column++;
        }
        
        System.out.printf("\nHint %d: \nRow %d -> %d treasure\n" +
                                 "Column %d -> %d treasure\n",attempt,dig[0]+1,row,dig[1]+1,column);
    
  }
}
    
    
        
                
                  
          

                  
            
        
        