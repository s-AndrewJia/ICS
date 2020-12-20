import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //varibles
    int num1, num2, ans;
    String isCorrect = "Congrats - correct.";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter first num:");
    num1 = user_input.nextInt();
    System.out.println("Enter second num:");
    num2 = user_input.nextInt();
    System.out.println("What is " + num1 + " mod " + num2 + "?");
    ans = user_input.nextInt();
    
    //check
    if (ans != (num1 % num2)) {
      isCorrect = "Incorrect.\nModulus returns the remainder.\n" + num2 + " divides into " + num1 + ", " + (int)Math.floor(num1 / num2) + " times and there is " + (num1 % num2) + " leftover. \n" + num1 + " mod " + num2 + " is " + (num1 % num2) + ".";
    }
    System.out.println(isCorrect);
  }
}