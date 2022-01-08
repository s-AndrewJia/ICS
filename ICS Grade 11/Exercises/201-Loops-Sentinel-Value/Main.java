import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int sentinelValue, integerValue;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a sentinel value:");
    sentinelValue = user_input.nextInt();
    
    do  {
      System.out.println("Enter an integer:");
      integerValue = user_input.nextInt();
    } while (integerValue != sentinelValue);
    System.out.println("Stop");
  }
}