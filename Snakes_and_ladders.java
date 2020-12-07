import java.math.*;
import java.util.*;
public class Snakes_and_ladders{
  static int p1dice1;
  static int p2dice1;
  static int position1;
  static int position2;
  static int ladders []   = {8,15,42,66};//where the ladders start
  static int laddersEnd[] = {31,97,81,87};//where the ladders take you
  static int snakes []    = {24,55,71,88,99};//where the snakes mouth is
  static int snakesEnd [] = {1,13,29,67,6};//where the snakes take you
  static String name1;
  static String name2;
  static Scanner sc = new Scanner(System.in);                        
  public static void main (String args[])
  {
    askForName();
    loop();
  }
  public static void askForName ()
  {
    System.out.println("***********************WELCOME TO SNAKES AND LADDERS**************************");
    System.out.println("Enter player 1's name");
    name1 = sc.nextLine();
    System.out.println("Enter player 2's name");
    name2 = sc.nextLine();
    System.out.println("Good Luck " + name1 + " and " + name2);
  }
  public static int rollDie()
  {
    Random rand = new Random();
    return 1 + rand.nextInt(6);
  }
  public static int position1(String roll)
  {
    System.out.println(name1+" roll, press anything");
    roll = sc.next();
    System.out.println(name1+" has rolled " + p1dice1);
    if (position1 + p1dice1 <= 100){
        position1 = position1 + p1dice1;}
      else { 
          System.out.println(name1+", you rolled too high");
        }
    System.out.println(name1+" is now at " + position1);
    return position1;
  }
  
  public static int position2 (String roll)
  {
    System.out.println(name2+" rolls, press anything to begin");
    roll = sc.next();
    System.out.println(name2+" has rolled " + p2dice1);
    if(position2+p2dice1<=100){
        position2 = position2 + p2dice1;
    }
    else{
        System.out.println("You rolled too high");
    }
    System.out.println(name2+" is now at " + position2);
    return position2;
  }
  public static void winner ()
  {
    if (position1 == 100){
      System.out.println("\nTHE WINNER IS " + name1); 
    }
    else if (position2 == 100){
      System.out.println("\nTHE WINNER IS " + name2); 
    }
  }
  public static int player1Ladders() {
    for (int i = 0; i < ladders.length; i++) {
      if (position1 == ladders[i]) {
        System.out.println("You hit a ladder! "+name1+"'s new position is " + laddersEnd[i]);
        position1 = laddersEnd[i];
      }
    }
    return position1;
  }
  public static int player1Snakes()
  {
    for(int i = 0; i < snakes.length; i++) {
      if (position1 == snakes[i]) {
        System.out.println("You hit a Snake! "+name1+"'s new position is " + snakesEnd[i]);
        position1 = snakesEnd[i];
      }
    }
    return position1;
  }
  public static int player2Ladders()
  {
    for(int i = 0; i < ladders.length; i++) {
      if (position2 == ladders[i]) {
        System.out.println("You hit a ladder! "+name2+"'s new position is " + laddersEnd[i]);
        position2 = laddersEnd[i];
      }
    }
    return position2;
  }
  public static int player2Snakes()
  {
    for(int i = 0; i < snakes.length; i++) {
      if (position2 == snakes[i]) {
        System.out.println("You hit a Snake! "+name2+"'s new position is " + snakesEnd[i]);
        position2 = snakesEnd[i];
      }
    }
    return position2;
  }
  public static void loop()
  {
    while (position1 < 100 && position2 < 100)
    {
      p1dice1 = rollDie();
      p2dice1 = rollDie();
      String roll = "";
      rollDie();
      position1(roll);
      player1Ladders();
      player1Snakes();
      winner();
      position2(roll);
      player2Ladders();
      player2Snakes();
      winner();
    }
  }
}
