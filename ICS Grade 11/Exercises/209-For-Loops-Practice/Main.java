import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int int1, int2;
    String asterisks = "";
    char letter1, letter2;
    
    //ask integers
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter integer 1:");
    int1 = user_input.nextInt();
    System.out.println("Enter integer 2:");
    int2 = user_input.nextInt();
    
    //output asterisks
    if (int1 > int2)  {
      for (int i=int1;i>int2;i--) {
        asterisks += "*";
      }
    }
    else  {
      for (int i=int2;i>int1;i--) {
        asterisks += "*";
      }
    }
    System.out.println("Print asterisks:\n" + asterisks);
    
    //output Countdown
    System.out.println("Countdown seconds:");
    if (int1 > int2)  {
      for (int i=int1;i>=int2;i--) {
        System.out.println(i + " seconds");
      }
    }
    else  {
      for (int i=int2;i>=int1;i--) {
        System.out.println(i + " seconds");
      }
    }
    
    //ask letter
    System.out.println("Enter a letter:");
    letter1 = Character.toLowerCase(user_input.next().charAt(0));
    System.out.println("Enter a letter:");
    letter2 = Character.toLowerCase(user_input.next().charAt(0));
    
    if (letter1 < letter2)  {
      for (int i=letter1;i<=letter2;i++)  {
        System.out.println("Give me a " + (char)i);
      }      
    }
    else  {
      for (int i=letter2;i<=letter1;i++)  {
        System.out.println("Give me a " + (char)i);
      }      
    }

    
    System.out.println("Output multiples - start at integer 1 and multiply by integer 2 stop when greater than 1000");
    
    for (int i=int1;i<1000;i*=int2) {
      System.out.println(i);
    }
  }
}