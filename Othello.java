import java.util.*;
public class Othello{
    static Scanner sc = new Scanner(System.in);
    static String[][]board=new String[8][8];
    static int wp=2;
    static int bp=2;
    static int x1=0;
    static int y1=0;
    static int x2=0;
    static int y2=0;
    public static void main(String[]args){
        initBoard(); 
        printBoard();
    }
    
    public static void initBoard(){
        for(int i=0;i<8;i++){
            for(int x=0;x<8;x++){
                if(i==3 && x==3){
                    board[i][x]="W";
                }
                else if(i==3 && x==4){
                    board[i][x]="B";
                }
                else if(i==4 && x==3){
                    board[i][x]="B";
                }
                else if(i==4 && x==4){
                    board[i][x]="W";
                }
                else{
                    board[i][x]=" ";
                }
            }
        }
    }
    
    public static void printBoard(){
        System.out.print("  ");
        for(int x=0;x<8;x++){
                System.out.print(" "+x);
            }
        for(int i=0;i<8;i++){
            System.out.println();
            System.out.print(i+" |");
            for(int x=0;x<8;x++){
                System.out.print(board[i][x]+"|");
            }
            System.out.println();
            System.out.println("   -+-+-+-+-+-+-+-");  
        }
        System.out.println("\n White score is: "+wp+"\n Black score is: "+bp);
        input();
    }
    
    public static void input(){
        boolean check=true;
        x1=0;
        y1=0;
        while(check){
            System.out.println("Black coin's turn");
            System.out.println("Enter x coordinate: ");
            x1=sc.nextInt();
            System.out.println("Enter y coordinate: ");
            y1=sc.nextInt();
            if(board[x1][y1]!=" " || x1>7 || x1<0 || y1<0 || y1>7){
                x1=0;
                y1=0;
                System.out.println("That is not valid");
                continue;
            }
            else{
                break;
            }
        }
        board[x1][y1]="B";
        bp++;
        flip1();
        x2=0;
        y2=0;
        while(check){
            System.out.println("White coin's turn");
            System.out.println("Enter x coordinate: ");
            x2=sc.nextInt();
            System.out.println("Enter y coordinate: ");
            y2=sc.nextInt();
            if(board[x2][y2]!=" " || x2>7 || x2<0 || y2<0 || y2>7){
                x2=0;
                y2=0;
                System.out.println("That is not valid");
                continue;
            }
            else{
                break;
            }
        }
        board[x2][y2]="W";
        wp++;
        flip2();
    }
    
    public static void flip1(){
        int x3=x1;
        int y3=y1;
        
        for(int i=x3;i<8;i++){
            if(board[i][y3]==" "){
                break;
            }
            else if(board[i][y3]=="B" && i-x3>1){
                for(int x=x3; x<i;x++){
                    board[x][y3]="B";
                    bp++;
                    wp--;
                }
            }
            else if(board[i][y3]=="B" && (i-x3==1 || i-x3==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=x3;i>0;i--){
            if(board[i][y3]==" "){
                break;
            }
            else if(board[i][y3]=="B" && x3-i>1){
                for(int x=x3; x>i;x--){
                    board[x][y3]="B";
                    bp++;
                    wp--;
                }
            }
            else if(board[i][y3]=="B" && (x3-i==1 || x3-i==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=y3;i<8;i++){
            if(board[x3][i]==" "){
                break;
            }
            else if(board[x3][i]=="B" && i-y3>1){
                for(int y=y3; y<i;y++){
                    board[x3][y]="B";
                    bp++;
                    wp--;
                }
            }
            else if(board[x3][i]=="B" && (i-y3==1 || i-y3==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=y3;i>0;i--){
            if(board[x3][i]==" "){
                break;
            }
            else if(board[x3][i]=="B" && y3-i>1){
                for(int y=y3; y>i;y--){
                    board[x3][y]="B";
                    bp++;
                    wp--;
                }
            }
            else if(board[x3][i]=="B" && (y3-i==1 || y3-i==0)){
                break;
            }
        }
        printBoard();
    }
    
    public static void flip2(){
        int x3=x1;
        int y3=y1;
        
        for(int i=x3;i<8;i++){
            if(board[i][y3]==" "){
                break;
            }
            else if(board[i][y3]=="W" && i-x3>1){
                for(int x=x3; x<i;x++){
                    board[x][y3]="W";
                    bp++;
                    wp--;
                }
            }
            else if(board[i][y3]=="W" && (i-x3==1 || i-x3==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=x3;i>0;i--){
            if(board[i][y3]==" "){
                break;
            }
            else if(board[i][y3]=="B" && x3-i>1){
                for(int x=x3; x>i;x--){
                    board[x][y3]="B";
                    bp++;
                    wp--;
                }
            }
            else if(board[i][y3]=="B" && (x3-i==1 || x3-i==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=y3;i<8;i++){
            if(board[x3][i]==" "){
                break;
            }
            else if(board[x3][i]=="B" && i-y3>1){
                for(int y=y3; y<i;y++){
                    board[x3][y]="W";
                    bp++;
                    wp--;
                }
            }
            else if(board[x3][i]=="W" && (i-y3==1 || i-y3==0)){
                break;
            }
        }
        x3=x1;
        y3=y1;
        for(int i=y3;i>0;i--){
            if(board[x3][i]==" "){
                break;
            }
            else if(board[x3][i]=="W" && y3-i>1){
                for(int y=y3; y>i;y--){
                    board[x3][y]="W";
                    bp++;
                    wp--;
                }
            }
            else if(board[x3][i]=="W" && (y3-i==1 || y3-i==0)){
                break;
            }
        }
        
    }
}