import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int numerator, denominator;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.print("numerator=");
    numerator = user_input.nextInt();
    System.out.print("denominator=");
    denominator = user_input.nextInt();
    
    //calculate
    System.out.println("\n" + numerator + " / " + denominator + " is equivalent to " + (int)Math.floor(numerator / denominator) + " and " + (int)Math.floor(numerator % denominator) + " / " + denominator);
  }
}