import java.util.Scanner;

    public class Tic_tac_toe {

  public static void main()
  {
        char player='o';
        int row,column;
        Scanner sc =  new Scanner (System.in);
        Game g = new Game ();

        g.initialize();
        System.out.println("Game ready !\n");
        g.display();
    while(true)
    {   
   player=g.changePlayer(player);

   System.out.print("\n"+player +" ,choose your location (column, row):");
   column=sc.nextInt();
   row=sc.nextInt();

    while (g.Legal(row,column))
    {
    System.out.println("That slot is already taken or out of bounds, please try again (row, column).");
    g.display();
    row=sc.nextInt();
    column=sc.nextInt();
   }
    g.changeBoard(player,row,column );
    g.display();

   if(g.Winner())
    {
    System.out.println("\nThe winner is "+ player+" !");
    break;

    }
   if(g.Tie())
    {
        System.out.println("\nThe game is a tie !");
        System.out.println("To directly exit type 1: ");
        int exit=sc.nextInt();
        int exitactual=1;
        if(exitactual==exit)
        System.exit(-1);
        else if(exitactual!=exit){
         g.initialize();  
         continue;
       }
    }
  }
 }

}
 class Game {

 char [][] table = new char[3][3];



  public void initialize() 
 {
    for (int i = 0; i < 3; i++)
        for (int p=0; p < 3; p++)
            table [i][p]= ' ';
 }


 public boolean Legal(int row, int column) 
  {
     if( (row>2 || column>2) || (row<0 || column <0) )
         return true;

   else if(table[row][column]=='x' || table[row][column]=='o')
        return true;

        return false;
  }


   public void changeBoard(char player, int row, int column)
   {
    table[row][column]=player;

   }


     public void display() 
    {

    System.out.println("  0  " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
    System.out.println("    --+-+--");
    System.out.println("  1  " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
    System.out.println("    --+-+--");
    System.out.println("  2  " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
    System.out.println("     0 1 2 ");
   }


   public char changePlayer(char player) {
    char newTurn='e';
    if (player == 'o')
        newTurn='x';
    if (player == 'x')
        newTurn='o';
    return newTurn;
  }


    public boolean Winner() {
         if( table [0][0]==table[1][0] && table[1][0] == table[2][0] && (table [0][0]=='x' || table [0][0]=='o'))
                return true;
        else if( table [0][1]==table[1][1] && table[1][1] == table[2][1] && (table [0][1]=='x' || table [0][1]=='o'))
                return true;
       else if( table [0][2]==table[1][2] && table[1][2] == table[2][2] && (table [0][2]=='x' || table [0][2]=='o'))
                return true;
       else if( table [0][0]==table[0][1] && table[0][1] == table[0][2] && (table [0][0]=='x' || table [0][0]=='o'))
                return true;
       else if( table [1][0]==table[1][1] && table[1][1] == table[1][2] && (table [1][0]=='x' || table [1][0]=='o'))
                return true;
      else if( table [2][0]==table[2][1] && table[2][1] == table[2][2] && (table [2][0]=='x' || table [2][0]=='o'))
                return true;
      else if( table [0][0]==table[1][1] && table[1][1] == table[2][2] && (table [0][0]=='x' || table [0][0]=='o'))
                return true;
       else if( table [2][0]==table[1][1] && table[1][1] == table[0][2] && (table [2][0]=='x' || table [2][0]=='o'))
                return true;
       else
                return false;
   }


   public boolean Tie() {
    for (int i = 0; i < 3; i++)
        for (int p=0; p < 3; p++)
            if(table [i][p]==' ')
                return false;

    return true;
   }
}