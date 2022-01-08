import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //variables
    int yourAge;
    String yourClassified = " child.";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("What is your age?");
    yourAge = user_input.nextInt();
    
    //errors
    if (yourAge < 0)  {
      System.out.println("Invalid age - please enter a number equal or over to 0.");
      System.exit(0);
    }
    
    //output
    if (yourAge > 117)  {
      System.out.println("Invalid age - you cannot be older than the currently old human alive.");
      System.exit(0);
    }
    else if (yourAge > 65) {
      yourClassified = " senior citizen.";
    }
    else if (yourAge > 19) {
      yourClassified = "n adult.";
    }
    else if (yourAge >= 12) {
      yourClassified = " teen.";
    }
    System.out.println("You are a" + yourClassified);
  }
}