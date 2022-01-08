import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    double givenNumber;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a positive number (or negative number to quit):");
    givenNumber = user_input.nextDouble();
    
    do {
      System.out.println("Square root is: " + Math.round(Math.sqrt(givenNumber) * 1000) / 1000.0);
      System.out.println("Enter a positive number (or negative number to quit):");
      givenNumber = user_input.nextDouble();
    } while (givenNumber > 0);
  }
}