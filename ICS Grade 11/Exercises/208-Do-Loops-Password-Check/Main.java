import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    final String secretPassword = "coded";
    String yourGuess = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    
    do  {
      System.out.println("Enter Password:");
      yourGuess = user_input.nextLine();
    } while (yourGuess.equals(secretPassword) == false);
    System.out.println("Access Granted!");
  }
}