import java.util.Scanner;

class Main {
  //make pretty
  public static final String ANSI_RESET = "\u001B[0m";

  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_UNDERLINE = "\u001B[4m";

  public static final String ANSI_NOBOLD = "\u001B[22m";
  public static final String ANSI_NOUNDERLINE = "\u001B[24m";

  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String YELLOW_BACKGROUND = "\u001B[43m";

  public static final String star = "\u2605";
  public static final String circle = "\u25CF";

  //only appear once MAKE SURE TO MAKE THIS ONLY HAPPEN IF PERSON WANTS IT TO
  public static String[] reduce (String[] list, int notNum) {
    String[] tempList = new String[list.length-1];
    for (int i=0, j=0;i<list.length;i++) {
      if (i != notNum) {
        tempList[j] = list[i];
        j += 1;
      }
    }
    return tempList;
  }

  //compare
  public static int[] compare (String[] guesses, String[] answers) {
    int[] scores = new int[2];
    String[] tempGuesses = new String[4];
    String[] tempAnswers = new String[4];

    for (int k=0;k<4;k++) {
      tempGuesses[k] = guesses[k];
      tempAnswers[k] = answers[k];
    }

    for (int i=0;i<4;i++) {      
      for (int j=0;j<4;j++) {
        if (tempGuesses[i].equals(tempAnswers[j]))  {
          //hits(x)
          if (i == j) {
            scores[0] += 1;
            tempGuesses[i] = "x";
            tempAnswers[j] = "X";
          }
          //blows(o)
          else  {
            if (tempGuesses[i].equals(tempAnswers[i]) == false && tempGuesses[j].equals(tempAnswers[j]) == false)  {
              scores[1] += 1;
              tempGuesses[i] = "x";
              tempAnswers[j] = "X";
            }
          }
        }
        /*for (int k=0;k<4;k++) {
          System.out.print(tempGuesses[k] + " ");
          System.out.println(tempAnswers[k]);
        }*/
      }
    }
    return scores;
  }

  //generate board
  public static void generateBoard (String[][] guesses, int counter, int completionChecker, int[][] hitsBlowsCounter)  {
    String[] circleGen = new String[10];    //make remaining have circles too

    String answers = YELLOW_BACKGROUND + "         " + ANSI_RESET;

    for (int k=0;k<10;k++)  {
      circleGen[k] = ANSI_YELLOW + " o o o o " + ANSI_RESET;
    }

    for (int i=0;i<=counter;i++) {
      circleGen[i] = "";

      circleGen[i] = circleGen[i].concat(" ");
      for (int j=0;j<4;j++) {
        String tempString = "";
        if (guesses[i][j].equals("R")) {
          tempString = ANSI_RED + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else if (guesses[i][j].equals("G")) {
          tempString = ANSI_GREEN + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else if (guesses[i][j].equals("B")) {
          tempString = ANSI_BLUE + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else if (guesses[i][j].equals("C")) {
          tempString = ANSI_CYAN + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else if (guesses[i][j].equals("P")) {
          tempString = ANSI_PURPLE + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else if (guesses[i][j].equals("W"))  {
          tempString = ANSI_WHITE + circle + " ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
        else  {
          tempString = "o ";
          circleGen[i] = circleGen[i].concat(tempString);
        }
      }
    }

    if (completionChecker == 4) {
      answers = YELLOW_BACKGROUND + circleGen[counter];
    }

    String[] mastermindString = {" M "," A "," S "," T "," E "," R "," M "," I "," N "," D "};
    System.out.println(ANSI_YELLOW + " _________ " + ANSI_GREEN + "___ ");

    for (int m=0;m<10;m++)  {
      System.out.print(ANSI_YELLOW + "|" + circleGen[m] + ANSI_YELLOW + "|" + ANSI_GREEN + ANSI_BOLD + mastermindString[m] + ANSI_NOBOLD + "|" + ANSI_RESET);

      for (int l=0;l<hitsBlowsCounter[m][0];l++)  {
        System.out.print(" x");
      }
      for (int l=0;l<hitsBlowsCounter[m][1];l++)  {
        System.out.print(" o");
      }
      System.out.println();
    }
    
    System.out.println(ANSI_YELLOW + "|_________|" + ANSI_GREEN + ANSI_UNDERLINE + " " + star + " " + ANSI_NOUNDERLINE + "|");
    System.out.println(ANSI_YELLOW + "|" + answers + ANSI_RESET + ANSI_YELLOW + "|" + ANSI_RESET);
    System.out.println();
    
  }

  public static void main(String[] args) {
    String playAgain = "y";

    while (playAgain.equals("y")) {
      Scanner user_input = new Scanner(System.in);

      String[] colourBank = new String[] {"R","G","B","C","P","W"};

      int[][] hitsAndBlows = new int[10][2];

      for (int i=0;i<10;i++)  {
        for (int j=0;j<2;j++)  {
          hitsAndBlows[i][j] = 0;
        }
      }

      String[] mastermindAnswer = new String[4];
      String[][] mastermindGuesses = new String[10][4];

      for (int i=0;i<10;i++)  {
        for (int j=0;j<4;j++) {
          mastermindGuesses[i][j] = "";
        }
      }

      boolean winner = false;

      System.out.println("----------------------------------------------------------------");
      System.out.println("      Welcome to MASTERMIND, the classic code breaking game.    ");
      System.out.println("----------------------------------------------------------------\n");
      System.out.println("Your goal is to obtain the correct code within 10 tries.");
      System.out.println("The code will consist of 4 colours out of a given 6 colours arranged in a specific pattern.\n");
      System.out.println("For each guess with a proper colour and position, you will be awarded a HIT (x).");
      System.out.println("For each guess with a correct colour, you will be awarded a BLOW (o).\n");

      System.out.println("Do you want duplicate colours to be enabled in the code? (y/n)");
      String duplicateAnswers = user_input.nextLine().toLowerCase();
      while (duplicateAnswers.equals("y") != true && duplicateAnswers.equals("n") != true)  {
        System.out.println("Type 'y' to indicate duplicate answers, or type 'n' otherwise.");
        duplicateAnswers = user_input.nextLine().toLowerCase();
      }

      for (int i=0;i<4;i++) {
        int colourDeterminer = (int)Math.floor(Math.random() * colourBank.length);
        mastermindAnswer[i] = colourBank[colourDeterminer];
        if (duplicateAnswers.equals("n"))  {
          colourBank = reduce(colourBank, colourDeterminer);
        }
        //System.out.println(mastermindAnswer[i]);              //answer
      }

      generateBoard(mastermindGuesses, 0, 0, hitsAndBlows);

      if (duplicateAnswers.equals("y")) {
        System.out.println("With duplicates, guesses are treated individually.");
        System.out.println("\nA single guess of a colour while there exists 2 instances of that colour in the code will only award a single HIT or BLOW.");
        System.out.println("For example, a guess of BXXX with an answer of BBXX will result in 1 HIT only.");
      }
      
      System.out.println("\nThere are 6 possible colours that the code can be: Red, Green, Blue, Cyan, Purple, and White.");
      System.out.println("Indicate your guess with the initial letter in their word (R, G, B, C, P, or W).");
      System.out.println("\nGood luck, Codebreaker.");

      //10 rounds
      for (int i=0;i<10;i++)  {
        int counter = 0;
        String inputColour;
        System.out.println("\nRound " + (int)(i+1) + " of 10. Type your guesses.");

        while (counter < 4) {
          inputColour = user_input.nextLine().toUpperCase();
          if (inputColour.equals("R") || inputColour.equals("G") || inputColour.equals("B") || inputColour.equals("C") || inputColour.equals("P") || inputColour.equals("W")) {
            mastermindGuesses[i][counter] = inputColour;
            counter += 1;
          }
          else  {
            System.out.println("\nType R, G, B, C, P, or W to indicate your guess.");
          }


          if (counter == 4)  {
            String[] compareGuesses = new String[4];
            for (int j=0;j<4;j++) {
              compareGuesses[j] = mastermindGuesses[i][j];
            }
            hitsAndBlows[i] = compare(compareGuesses, mastermindAnswer);
            System.out.println("\nHITS  (x): " + hitsAndBlows[i][0]);
            System.out.println("BLOWS (o): " + hitsAndBlows[i][1]);

            generateBoard(mastermindGuesses, i, hitsAndBlows[i][0], hitsAndBlows);

            if (hitsAndBlows[i][0] == 4) {
              counter += 4;
              i += 10;
              winner = true;
            }
          }
        }
      }

      //end sequence
      if (winner == true) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("   Congratulations, Codebreaker! You guessed the correct code!  ");
        System.out.println("----------------------------------------------------------------\n");
      }
      else  {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                           You lost! :(                         ");
        System.out.print("                The correct answer was:");
        for (int i=0;i<4;i++) {
          System.out.print(" " + mastermindAnswer[i]);
        }
        System.out.println("\n----------------------------------------------------------------\n");
      }

      System.out.println("Play again? (y/n)");
      playAgain = user_input.nextLine().toLowerCase();

      while (playAgain.equals("y") != true && playAgain.equals("n") != true)  {
        System.out.println("Type 'y' to play again, or type 'n' to quit.");
        playAgain = user_input.nextLine().toLowerCase();
      }
    }
  }
}