import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int yourInt;
    int total = 0;
    String yourIntStr = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a positive integer:");
    yourInt = user_input.nextInt();
    
    while (yourInt <= 0) {
      System.out.println("Enter a positive integer:");
      yourInt = user_input.nextInt();
    }
    
    yourIntStr += yourInt;
    
    //took a while, but did it without using strings :)
    for (int i=0;i<yourIntStr.length();i++) {
      total += ((yourInt - yourInt % Math.pow(10, i)) % Math.pow(10, i + 1)) / Math.pow(10, i);
    }
    System.out.println("Sum of " + yourInt + "'s digits is " + total);
  }
}