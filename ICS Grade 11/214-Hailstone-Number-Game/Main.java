/*

Andrew Jia
11/12/2020
Level 4++

*/

import java.util.Scanner;

/*for the LargestAndLength method, I couldn't find a way to make methods spit out two
values, so instead I used this site: https://www.techiedelight.com/return-multiple-values-method-java/.
this creates a class that has two values(largest and length) and in the method, returns
this class and you are able to split it into two values in the main sequence.*/
final class LargestAndLength  {
  public int largest;
  public int length;
  
  public LargestAndLength(int largest, int length) {
    this.largest = largest;
    this.length = length;
  }
}

class Main {
  //formatting from http://pueblo.sourceforge.net/doc/manual/ansi_color_codes.html
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_NOBOLD = "\u001B[22m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_CYAN = "\u001B[36m";
  
  public static void main(String[] args) {
    String playGameAgain = "yes";
    //this loop is the loop of the entire game, resets if user wants to play again.
    do  {
      //variables
      String continueToPlay;
      int howManyPlayers = 0;
      
      //intro
      Scanner user_input = new Scanner(System.in);
      System.out.println("------------------------------------------------------------");
      System.out.println(ANSI_BOLD + "           Welcome to the " + ANSI_CYAN + "HAILSTONE" + ANSI_RESET + ANSI_BOLD + " numbers game!           " + ANSI_RESET);
      System.out.println("------------------------------------------------------------");
      System.out.println("\nIn this game, the sequnce begins with a positive number(inputted by the user), which multiplies by 3 if odd and divides by 2 if even.");

      //ask for number of players(MAX 2, BECAUSE THE WAY THE GAME WORKS - SUBTRACTING TO GET POINTS)
      while (howManyPlayers != 1 && howManyPlayers != 2)  {
        System.out.println("\nHow many users are playing? (1 or 2)");
        howManyPlayers = user_input.nextInt();
      }
      
      //variables that depend on howManyPlayers
      String user [] = new String[howManyPlayers];
      int [] userPoints = new int[howManyPlayers];
      
      //output rules, depending on how many players are playing
      if (howManyPlayers == 1)  {
        System.out.println("\nIn single player, this is more of a sandbox for you to test out which numbers make the largest numbers and longest sequences. Enjoy!");
      }
      else  {
        System.out.println("\nFor two players, whoever obtains the largest number gets 5 points, and the user with a longer sequence will obtain 1 point for every number they have more than the opponent.");
        System.out.println("Your goal: Obtain more points than your opponent.");
      }
      
      //ask for username, calling upon method askForUserName
      for (int i=0;i<howManyPlayers;i++)  {
        user[i] = askForUserName(i);
      }
      
      //this loops the rounds of the same players. Variables within reset per round.
      do  {
        //arrays, to make code more efficient in for loops, length of how many players
        int [] sequenceNumber = new int[howManyPlayers];
        int [] largestNumber = new int[howManyPlayers];
        int [] sequenceLength = new int[howManyPlayers];

        //ask for numbers
        //for loops loop through each open space and fill it with values
        for (int i=0;i<howManyPlayers;i++)  {
          sequenceNumber[i] = askForNumber(i);
        }
        
        //list of values & largest number
        for (int i=0;i<howManyPlayers;i++) {
          //new largestAndLengthValues each iteration
          LargestAndLength largestAndLengthValues = giveOutSequence(sequenceNumber[i], i);
          largestNumber[i] = largestAndLengthValues.largest;
          sequenceLength[i] = largestAndLengthValues.length;
        }
        
        //output scoreboards
        for (int i=0;i<howManyPlayers;i++) {
          printScoreboard(i, largestNumber[i], sequenceLength[i]);
        }
        
        //if multiplayer, calculate points
        if (howManyPlayers == 2)  {
          //largest number winner, give 5 to largest
          if (largestNumber[0] > largestNumber[1])  {
            userPoints[0] += 5;
          }
          else if (largestNumber[1] > largestNumber[0]) {
            userPoints[1] += 5;
          }
          //default add 0 points
          
          //longer sequence winner, give dif in length to longest
          if (sequenceLength[0] > sequenceLength[1])  {
            userPoints[0] += (sequenceLength[0] - sequenceLength[1]);
          }
          else if (sequenceLength[1] > sequenceLength[0]) {
            userPoints[1] += (sequenceLength[1] - sequenceLength[0]);
          }
          //default add 0 points
          
          //output
          for (int i=0;i<howManyPlayers;i++) {
            System.out.println(user[i] + " has " + userPoints[i] + " points.");
          }
        }
        
        //ask to play another round & error catcher
        do  {
          System.out.println("\n[>===============| Continue? (yes or no) |================<]");
          continueToPlay = user_input.next().toLowerCase();
        } while (continueToPlay.equals("yes") == false && continueToPlay.equals("no") == false);
      } while (continueToPlay.equals("yes") == true);
      
      //end game, 2 players(shows winners)
      if (howManyPlayers == 2)  {
        if (userPoints[0] > userPoints[1])  {
          System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\" + ANSI_RESET);
          System.out.println(ANSI_BOLD + "\n     Congratulations! User [" + user[0] + "] won with " + userPoints[0] + " points!\n");
          System.out.println(ANSI_YELLOW + "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" + ANSI_RESET);
          System.out.println("\n      You never really did stand a chance, [" + user[1] + "]...");
        }
        else if (userPoints[1] > userPoints[0])  {
          System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\" + ANSI_RESET);
          System.out.println(ANSI_BOLD + "\n     Congratulations! User [" + user[1] + "] won with " + userPoints[1] + " points!\n");
          System.out.println(ANSI_YELLOW + "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" + ANSI_RESET);
          System.out.println("\n    You got dominated, [" + user[0] + "]. I'd quit if I were you.    ");
        }
        else  {
          System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\" + ANSI_RESET);
          System.out.println(ANSI_BOLD + "\n                           A tie!                           \n");
          System.out.println(ANSI_YELLOW + "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" + ANSI_RESET);
          System.out.println("\n         You're all winners! Or maybe none of you are...    ");
        }
      }
      System.out.println(ANSI_CYAN + "\n------------------------------------------------------------" + ANSI_RESET);
      System.out.println(ANSI_BOLD + "               THANKS FOR PLAYING HAILSTONES! :)            " + ANSI_RESET);
      System.out.println(ANSI_CYAN + "------------------------------------------------------------" + ANSI_RESET);
      
      //ask to play again & error catcher
      do  {
        System.out.println("\nWant to play again? (yes or no)");
        playGameAgain = user_input.next().toLowerCase();
      } while (playGameAgain.equals("yes") == false && playGameAgain.equals("no") == false);
    } while (playGameAgain.equals("yes") == true);
    System.out.println(ANSI_YELLOW + "\n------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_BOLD + "                 Come Back Anytime! (∗ ･‿･)ﾉ*              " + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "------------------------------------------------------------" + ANSI_RESET);
  }
  
  //These methods have been used as to not repeat code & to allow easy changing of the number of users allowed.
  
  //ask for username method; takes in user number and returns username
  public static String askForUserName(int userIdentifier)  {
    String userNameValue;
    
    //ask for username
    Scanner user_input = new Scanner(System.in);
    System.out.println(ANSI_CYAN + "\n------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_BOLD + "               Player " + (userIdentifier + 1) + ", Please enter a username." + ANSI_RESET);
    System.out.println(ANSI_CYAN + "------------------------------------------------------------\n" + ANSI_RESET);
    userNameValue = user_input.nextLine();
    
    return userNameValue;
  }
  
  //ask for number method, takes in user number and returns their sequence number
  public static int askForNumber(int userIdentifier) {
    int sequenceNumberValue;
    
    //ask for numbers
    Scanner user_input = new Scanner(System.in);
    System.out.println(ANSI_CYAN + "\n------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_BOLD + "           Player " + (userIdentifier + 1) + ", Please enter a starting number." + ANSI_RESET);
    System.out.println(ANSI_CYAN + "------------------------------------------------------------\n" + ANSI_RESET);
    sequenceNumberValue = user_input.nextInt();
    
    //error catcher, between 1 and 100(inclusive)
    while (sequenceNumberValue <= 0 || sequenceNumberValue > 100)  {
      System.out.println(ANSI_CYAN + "\n------------------------------------------------------------" + ANSI_RESET);
      System.out.println(ANSI_BOLD + "       Starting number must be positive & less than 100.    ");
      System.out.println("            Please enter a valid starting number.           " + ANSI_RESET);
      System.out.println(ANSI_CYAN + "------------------------------------------------------------\n" + ANSI_RESET);
      sequenceNumberValue = user_input.nextInt();
    }
    
    return sequenceNumberValue;
  }
  
  //give out sequence & find largest number & find length method, takes in user number & sequence number and returns largest number & sequence length
  public static LargestAndLength giveOutSequence(int sequenceNumberValue, int userIdentifier)  {
    //starts at 1 because this while loop doesn't include 1(last number)
    int largestNumberValue = 1;
    int sequenceLengthValue = 1;
    
    System.out.println("\nPlayer " + (userIdentifier + 1) + "'s Sequence: ");
    while (sequenceNumberValue != 1) {
      //largest number
      if (sequenceNumberValue > largestNumberValue) {
        largestNumberValue = sequenceNumberValue;
      }
      //so it doesn't include 1, placed before the if statements
      System.out.print(sequenceNumberValue + " -> ");
      if (sequenceNumberValue % 2 == 0)  {
        sequenceNumberValue /= 2;
      }
      else  {
        sequenceNumberValue = sequenceNumberValue * 3 + 1;
      }
      sequenceLengthValue += 1;
    }
    //always ends with 1(placed here to end the line)
    System.out.println("1");
    
    return new LargestAndLength(largestNumberValue, sequenceLengthValue);
  }
  
  //output scoreboard
  public static void printScoreboard(int userIdentifier, int largestNumberValue, int sequenceLengthValue)  {
    System.out.println(ANSI_YELLOW + "\n------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_BOLD + "                   PLAYER " + (userIdentifier + 1) + "'S SCOREBOARD" + ANSI_RESET);
    System.out.println("                     Largest Value: " + largestNumberValue);
    System.out.println("                    Sequence length: " + sequenceLengthValue);
    System.out.println(ANSI_YELLOW + "------------------------------------------------------------\n" + ANSI_RESET);
  }
}