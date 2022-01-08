import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int length, width, area;
    
    //input
    System.out.println("This program will give you the area of a rectangle.\n");
    
    //input
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter the length.");
    length = user_input.nextInt();
    System.out.println("Enter the width.");
    width = user_input.nextInt();
    
    //calculate
    area = (length * width);
    System.out.println("\nThe area of the rectangle is " + area + ".");
  }
}