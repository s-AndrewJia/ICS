import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    double mark1, mark2, mark3, mark4, average;
    
    //ask mark1
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter mark 1.");
    mark1 = user_input.nextInt();
    System.out.println("Marks: " + mark1);
    System.out.println("Mark total: " + mark1 + "\n");
    
    //ask mark2
    System.out.println("Enter mark 2.");
    mark2 = user_input.nextInt();
    System.out.println("Marks: " + mark1 + ", " + mark2);
    System.out.println("Mark total: " + (mark1 + mark2) + "\n");
    
    //ask mark3
    System.out.println("Enter mark 3.");
    mark3 = user_input.nextInt();
    System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
    System.out.println("Mark total: " + (mark1 + mark2 + mark3) + "\n");
    
    //ask mark4
    System.out.println("Enter mark 4.");
    mark4 = user_input.nextInt();
    System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3 + ", " + mark4);
    System.out.println("Mark total: " + (mark1 + mark2 + mark3 + mark4) + "\n");
    
    //calculate
    average = (mark1 + mark2 + mark3 + mark4) / 4.0;
    System.out.println("The average is " + average + ".");
  }
}