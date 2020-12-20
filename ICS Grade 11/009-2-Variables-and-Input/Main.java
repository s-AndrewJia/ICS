import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //define
    double myMass;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter your mass.");
    myMass = user_input.nextDouble();
    
    //output
    System.out.println("Your mass is " + myMass + " kg.");
  }
}