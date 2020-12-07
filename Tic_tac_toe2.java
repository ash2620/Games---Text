import java.util.*;
public class Tic_tac_toe2{
    static Scanner sc=new Scanner(System.in);
    static String[][]board=new String[3][3];
    static int[][]AiBoard=new int[3][3];
    public static void main(String[]args){
      initializeBoard();
        while(!checkWin()&&tie()){
        printBoard();
        Ai();
        input();
       
      }
      printBoard();
    }
    public static void initializeBoard(){
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                board[i][x]="-";
                AiBoard[i][x]=0;
            }
        }
    }
    public static void printBoard(){
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                System.out.print(board[i][x]);
            }
            System.out.println();
        }
    }
    public static void input(){
        System.out.println("Enter coordinates ");
        int x=sc.nextInt();
        int y=sc.nextInt();
        if(board[x][y]=="-"){
            board[x][y]="x";
        }
      
    }
    //Ai
    public static void Ai(){
        
        boolean v=false;
        int a=-1;
        int b=-1;
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                if(board[i][x]=="-"){
                    board[i][x]="o";
                    AiBoard[i][x]=checkWin2()?-1:0;
                    if(checkWin3()){
                        AiBoard[i][x]=1;
                    }
                    board[i][x]="-";
                }
                System.err.print(AiBoard[i][x]);
            }
        }
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                if(AiBoard[i][x]==1){
                    v=true;
                    a=i;
                    b=x;
                }
            }
        }
        if(v){
            board[a][b]="o";
        }
        else{
            boolean m=true;
            boolean n=false;
            for(int i=0;i<3;i++){
                for(int x=0;x<3;x++){
                    if(AiBoard[i][x]==-1){
                        m=false;
                        n=true;
                        board[i][x]="o";
                    }
                    if(n)
                    break;
                }
                if(n)
                    break;
            }
            if(m){
                boolean z=false;
                for(int i=0;i<3;i++){
                    for(int x=0;x<3;x++){
                        if(board[i][x]=="-"){
                            board[i][x]="o";
                            z=true;
                        }
                        if(z)
                            break;
                    }
                    if(z)
                        break;
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                AiBoard[i][x]=0;
                
            }
        }
    }
    public static boolean checkWin(){
        if( board [0][0]==board[1][0] && board[1][0] == board[2][0] && (board [0][0]=="x" || board [0][0]=="o"))
                return true;
        else if( board [0][1]==board[1][1] && board[1][1] == board[2][1] && (board [0][1]=="x" || board [0][1]=="o"))
                return true;
       else if( board [0][2]==board[1][2] && board[1][2] == board[2][2] && (board [0][2]=="x" || board [0][2]=="o"))
                return true;
       else if( board [0][0]==board[0][1] && board[0][1] == board[0][2] && (board [0][0]=="x" || board [0][0]=="o"))
                return true;
       else if( board [1][0]==board[1][1] && board[1][1] == board[1][2] && (board [1][0]=="x" || board [1][0]=="o"))
                return true;
      else if( board [2][0]==board[2][1] && board[2][1] == board[2][2] && (board [2][0]=="x" || board [2][0]=="o"))
                return true;
      else if( board [0][0]==board[1][1] && board[1][1] == board[2][2] && (board [0][0]=="x" || board [0][0]=="o"))
                return true;
       else if( board [2][0]==board[1][1] && board[1][1] == board[0][2] && (board [2][0]=="x" || board [2][0]=="o"))
                return true;
       else
                return false;
    }
    //check if x wins
    public static boolean checkWin2(){
        if( board [0][0]==board[1][0] && board[1][0] == board[2][0] && board [0][0]=="x")
                return true;
        else if( board [0][1]==board[1][1] && board[1][1] == board[2][1] && board [0][1]=="x")
                return true;
       else if( board [0][2]==board[1][2] && board[1][2] == board[2][2] && board [0][2]=="x")
                return true;
       else if( board [0][0]==board[0][1] && board[0][1] == board[0][2] && board [0][0]=="x")
                return true;
       else if( board [1][0]==board[1][1] && board[1][1] == board[1][2] && board [1][0]=="x")
                return true;
      else if( board [2][0]==board[2][1] && board[2][1] == board[2][2] && board [2][0]=="x")
                return true;
      else if( board [0][0]==board[1][1] && board[1][1] == board[2][2] && board [0][0]=="x")
                return true;
       else if( board [2][0]==board[1][1] && board[1][1] == board[0][2] && board [2][0]=="x")
                return true;
       else
                return false;
    }
    //check if y wins
    public static boolean checkWin3(){
        if( board [0][0]==board[1][0] && board[1][0] == board[2][0] && board [0][0]=="o")
                return true;
        else if( board [0][1]==board[1][1] && board[1][1] == board[2][1] && board [0][1]=="o")
                return true;
       else if( board [0][2]==board[1][2] && board[1][2] == board[2][2] && board [0][2]=="o")
                return true;
       else if( board [0][0]==board[0][1] && board[0][1] == board[0][2] && board [0][0]=="o")
                return true;
       else if( board [1][0]==board[1][1] && board[1][1] == board[1][2] && board [1][0]=="o")
                return true;
      else if( board [2][0]==board[2][1] && board[2][1] == board[2][2] && board [2][0]=="o")
                return true;
      else if( board [0][0]==board[1][1] && board[1][1] == board[2][2] && board [0][0]=="o")
                return true;
       else if( board [2][0]==board[1][1] && board[1][1] == board[0][2] && board [2][0]=="o")
                return true;
       else
                return false;
    }
    public static boolean tie(){
        for(int i=0;i<3;i++){
            for(int x=0;x<3;x++){
                if(board[i][x]=="-")
                    return true;
            }
        }
        return false;
    }
}