import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    double yourNumber;
    int decimalPlaces;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter first number:");
    yourNumber = user_input.nextDouble();
    System.out.println("Number of decimal places:");
    decimalPlaces = user_input.nextInt();
    
    //calculate
    System.out.println(Math.round(yourNumber * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces));
  }
}