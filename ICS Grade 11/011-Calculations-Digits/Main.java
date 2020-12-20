import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int yourDigits;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Please enter a positive, 4-digit number(1111 to 9999):");
    //shouldn't it be 1000 to 9999?
    yourDigits = user_input.nextInt();
    System.out.println("The digits of " + yourDigits + " are " + (int)Math.floor(yourDigits / 1000)
    + ", " + (int)Math.floor(yourDigits % 1000 / 100)
    + ", " + (int)Math.floor(yourDigits % 100 / 10)
    + ", and " + (int)Math.floor(yourDigits % 10)
    );
  }
}