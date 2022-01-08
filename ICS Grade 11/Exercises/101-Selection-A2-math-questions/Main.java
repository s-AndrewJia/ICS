import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //number generator between 0 and 10, not including 10(1-3 inclusive for powers)
    float num1 = (float)Math.floor(Math.random() * 10);
    float num2 = (float)Math.floor(Math.random() * 10);
    float num3 = (float)Math.floor(Math.random() * 10);
    float num4 = (float)Math.floor(Math.random() * 10);
    float num5 = (float)Math.floor(Math.random() * 10);
    float num6 = (float)Math.floor(Math.random() * 3 + 1);
    float ans1, ans2, ans3;
    
    //default responses
    String response1 = "You got question 1 correct!";
    String response2 = "You got question 2 correct!";
    String response3 = "You got question 3 correct!";

    //questions
    Scanner user_input = new Scanner(System.in);
    System.out.println("What is " + num1 + " + " + num2 + " ?");
    ans1 = user_input.nextFloat();
    System.out.println("What is " + num3 + " * " + num4 + " ?");
    ans2 = user_input.nextFloat();
    System.out.println("What is " + num5 + " ^ " + num6 + " ?");
    ans3 = user_input.nextFloat();
    
    //check
    //if ans not equal to math operation, not using default responses, default responses changes into correct answers
    if (ans1 != (num1 + num2))  {
      response1 = "For question 1, " + num1 + " + " + num2 + ", you answered " + ans1 + ". The correct answer was " + (num1 + num2) + ".";
    }
    if (ans2 != (num3 * num4))  {
      response2 = "For question 2, " + num3 + " * " + num4 + ", you answered " + ans2 + ". The correct answer was " + (num3 * num4) + ".";
    }
    if (ans3 != (Math.pow(num5, num6))) {
      response3 = "For question 3, " + num5 + " ^ " + num6 + ", you answered " + ans3 + ". The correct answer was " + (Math.pow(num5, num6)) + ".";
    }
    //print out responses
    System.out.println(response1);
    System.out.println(response2);
    System.out.println(response3);
  }
}