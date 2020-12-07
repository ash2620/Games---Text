import java.io.*;
import java.util.*;
public class HandCricketAndHandFootball {
    static Scanner sc=new Scanner(System.in);
    static Random r=new Random();
    static int[]runs={0,0};//runs for player and comp
    static int udCount=0;//player dribble count
    static int cdCount=0;//computer dribble count
    static int uScore=0;//your football score
    static int compScore=0;//computers football score
    static boolean pos=true;//football possession
   public static void main(String[]args)throws Exception{
        while(true){
        int choice=choose();
        switch(choice){
            case 1:
                HandCricket();
                break;
            case 2:
                HandFootball();
                break;
            case 0:
                System.out.println("Goodbye");
                System.exit(-1);
            default:
                System.out.println("That is not a valid choice");
                break;
        }
     }
   }
   public static int choose(){//Choice for which game
        System.out.println("Enter the game you want to play(1 for cricket/ 2 for football / 0 for exit)");
        int input=sc.nextInt();
        return input;
   }
   
   //cricket
   public static void HandCricket()throws Exception{
        InputStreamReader c=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(c);
        System.out.println("Enter the name of your team: ");
        String team=b.readLine();
        while(true){
        String play="";//exit the game
        boolean bb=false;//batting or bowling
        System.out.println("Enter 1 to start playing / 2 to see rules");
        int choice=sc.nextInt();//choice
        runs[0]=0;
        runs[1]=0;
        switch(choice){
            case 1:
                int t=r.nextInt(3)+1;
                System.out.println("Time for the coin toss( enter 1 if you pick heads and 2 for tails): ");
                    int toss=sc.nextInt();
                    
                    if(toss==t){//won toss
                        System.out.println("Congragulations you have won the toss");
                        System.out.println("What do you choose to do(bat or bowl)");
                        String or=b.readLine();//stores choice
                        if(or.equals("bat")){
                            bb=true;//batting
                        }
                        else{
                            bb=false;//bowling
                        }
                        if(bb){//batting or bowling order
                            batting();
                            System.out.println("Now its "+team+"s turn to bowl");
                            bowling();
                        }
                        else{
                            bowling();
                            System.out.println("Now its "+team+"s turn to bat");
                            batting();
                        }
                        if(runs[0]>runs[1]){
                            System.out.println("Congragulations you have won");
                        }
                        else{
                            System.out.println("Sorry but you lost");
                        }
                        System.out.println("Enter 1 if you wish to play again: ");
                        play=b.readLine();
                    }
                    else{//lost toss
                        System.out.println("Sorry you have lost the toss");
                        int ctoss=r.nextInt(3)+1;
                        if(ctoss==1){
                            System.out.println("Its "+team+"s turn to bat");
                            batting();
                            System.out.println("Its "+team+"s turn to bowl");
                            bowling();
                        }
                        else{
                            System.out.println("Its "+team+"s turn to bowl");
                            bowling();
                            System.out.println("Its "+team+"s turn to bat");
                            batting();
                        }
                    }
                break;
            case 2:
                System.out.println("Rules of the game:\nBatting:\nEnter a number from 1 to 6, if the computer enters the same number as you you are out.\nYour score is increased by the number you enter"); 
                System.out.println("Bowling:\n Enter a number from 1 to 6, if the computer enters the same number the computer is out.\nThe computers score is incremented by the number it inouts");
                
                break;
            default:
                System.out.println("That is not a vaild option\n");
                
        }
        if(!(play.equals("1"))){
            break;
        }
      }
    }
    public static void batting(){
        int rand=0;
        int run=-1;
        boolean err=true;
        while(rand!=run){
            while(err){//error testing
                try{
                System.out.println("Enter a number from 1 to 6: ");
                run=sc.nextInt();
                if(run>0&&run<7){
                    err=false;
                }
                else{
                    System.out.println("That is not a valid command\n");
                }
               }catch(Exception e){
                   System.out.println("That is not a valid command\n");
               }
            }
            rand=r.nextInt(6)+1;
            System.out.println("\nThe computer has chosen the number: "+rand);
            if(rand!=run){
                runs[0]+=run;
            }
            System.out.println("\nYour score is: "+runs[0]);
            err=true;
        }
        System.out.println("You are out");
        System.out.println("Your score is: "+runs[0]);      
    }
    public static void bowling(){
        int rand=0;
        int run=-1;
        boolean err=true;
        while(rand!=run){
            while(err){//error testing
            try{
                System.out.println("Enter a number from 1 to 6: ");
                run=sc.nextInt();
                if(run>0&&run<7){
                    err=false;
                }
                else{
                    System.out.println("This is not a valid command\n");
                }
            }catch(Exception e){
                System.out.println("This is not a valid command\n");
            }
           }
            rand=r.nextInt(6)+1;
            System.out.println("\nThe computer has tried to score: "+rand+" runs");
            if(rand!=run){
                runs[1]+=run;
            }
            err=true;
        }
        System.out.println("\nThe computer is out");
        System.out.println("\nThe computer's score is: "+runs[1]);
    }
    
    //football
   public static void HandFootball(){
       InputStreamReader b=new InputStreamReader(System.in);
       BufferedReader c= new BufferedReader(b);
       boolean p=true;
       System.out.println("Enter 1 to start playing / 2 to see rules");
       int choice=sc.nextInt();
       while(p){
       switch(choice){
           case 1:
              while(uScore<3&&compScore<3){
              dribble();
            }
            if(uScore==3){//check win
                System.out.println("Nice you won");
            }
            else{
                System.out.println("Sorry you lost");
            }
            p=false;
            break;
           case 2://rules
            System.out.println("At the beginning of the game you must enter a number from 1 to 3\n You start with the ball every time and if you manage to\n ");
            System.out.println("get a different number from the computer thrice you are given a scoring chance\nIn a scoring chance you must enter a number between 4 and 6\n");
            System.out.println("If you enter a different number from the computer then you score a goal if not\nthen the ball is in possesion of the computer\n");
            System.out.println("If the computer is in possession of the ball the same rules apply but to et the ball\n");
            System.out.println("The game stops when the computer or you reach 3 goals\n");
            p=false;
            break;
           default:
            System.out.println("That is not a vaild command");
            p=true;
       }
      }
   }
   public static void dribble(){
      while(udCount<3&&cdCount<3){//as long as 3 dribbles haven't taken place
          boolean err=true;
          boolean f=true;
          int dchoice=0;
          while(err){
              System.out.println("Enter a number between 1 and 3");
              while(f){
              try{
                  dchoice=sc.nextInt();
                  f=false;
              }catch(Exception e){
                  System.out.println("That is not a valid command");
               }
             }
              if(dchoice<4&&dchoice>0){
                  err=false;
                }
                else{
                    System.out.println("Sorry that is not a valid command\n");
                }
         }
          int cdchoice=r.nextInt(3)+1;//computer dribble
          System.out.println("The computer tried "+cdchoice);
          if(dchoice==cdchoice){
              pos=pos?false:true;
          }
          else{
              if(pos){
                  udCount++;
                  System.out.println("Your dribble number "+udCount);
              }
              else{
                  
                  cdCount++;
                  System.out.println("Computer dribble number "+cdCount);
              }
          }
      }
      shoot();
    }
   public static void shoot(){//shooting chance
       boolean err=true;
       if(pos){
           System.out.println("Its your shooting chance");
           int sUser=0;
           while(err){
            System.out.println("Enter 4,5 or 6");
            sUser=sc.nextInt();
            if(sUser>3&&sUser<7){
               err=false;
            }
            else{
               System.out.println("That is not a valid command\n");
            }
          }
           int uShoot=r.nextInt(3)+4;//comp block attempt
           if(uShoot!=sUser){
               uScore++;//increment your score
               System.out.println("Nice you scored");
           }
           else{
               System.out.println("Sorry your shot got blocked");
           }
       }
       else{
           System.out.println("Its time to stop a goal");
           err=true;
           System.out.println("Enter 4,5 or 6");
           int bUser=sc.nextInt();
           while(err){
               if(bUser>3&&bUser<7){
                   err=false;
               }
               else{
                   System.out.println("This is not a valid command\n");
               }
           }
           int cShoot=r.nextInt(3)+4;//comp shoot attempt
           if(bUser!=bUser){
               compScore++;//increment comp score
               System.out.println("The computer scored");
           }
           else{
               System.out.println("Nice you blocked it");
           }
       }
       udCount=0;//reset user dribble
       cdCount=0;//reset computer dribble
    }
}