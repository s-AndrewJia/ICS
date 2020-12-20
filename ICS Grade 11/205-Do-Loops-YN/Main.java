import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    String continueAnswer;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Continue (y or n):");
    continueAnswer = user_input.next();
    
    while (continueAnswer.equals("y") == false && continueAnswer.equals("n") == false)  {
      System.out.println("Continue (y or n):");
      continueAnswer = user_input.next();
    }
    System.out.println("done");
  }
}