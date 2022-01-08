import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int num1, num2;
    int smallNum = 0;
    int largeNum = 0;
    String isItEqual = "The numbers are equal";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter first number:");
    num1 = user_input.nextInt();
    System.out.println("Enter second number:");
    num2 = user_input.nextInt();
    
    //out
    if (num1 != num2) {
      if (num1 > num2) {
        largeNum = num1;
        smallNum = num2;
      }
      else if (num1 < num2)  {
        largeNum = num2;
        smallNum = num1;
      }
      isItEqual = largeNum + " is larger than " + smallNum;
    }
    System.out.println("Result:" + isItEqual);
  }
}