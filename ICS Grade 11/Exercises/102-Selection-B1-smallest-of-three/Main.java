import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //numbers
    int num1, num2, num3;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter first number:");
    num1 = user_input.nextInt();
    System.out.println("Enter second number:");
    num2 = user_input.nextInt();
    System.out.println("Enter third number:");
    num3 = user_input.nextInt();
    int smallestNum = num3;
    
    //determine smallest
    if (num3 > num1 || num3 > num2) {
      if (num1 <= num2) {
        smallestNum = num1;
      }
      else if (num2 <= num1) {
        smallestNum = num2;
      }
    }
    System.out.println("The smallest number is: " + smallestNum);
  }
}