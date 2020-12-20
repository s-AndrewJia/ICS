import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    
    //I didn't use || in this task.
    
    //numbers
    int num1, num2, num3;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter 3 integer values.");
    num1 = user_input.nextInt();
    num2 = user_input.nextInt();
    num3 = user_input.nextInt();
    
    //the return of the numbers
    int smallestNum = num1;
    int middleNum = num2;
    int largestNum = num3;
    
    //order
    if (num1 < num2 && num1 < num3)  {
      if (num3 < num2)  {
        middleNum = num3;
        largestNum = num2;
      }
    }
    else if (num2 < num1 && num2 < num3) {
      if (num1 < num3)  {
        smallestNum = num2;
        middleNum = num1;
      }
      else  {
        smallestNum = num2;
        middleNum = num3;
        largestNum = num1;
      }
    }
    else if (num3 < num1 && num3 < num2)  {
      if (num1 < num2)  {
        smallestNum = num3;
        middleNum = num1;
        largestNum = num2;
      }
      else  {
        smallestNum = num3;
        largestNum = num1;
      }
    }
    System.out.println(smallestNum + ", " + middleNum + ", " + largestNum);
  }
}