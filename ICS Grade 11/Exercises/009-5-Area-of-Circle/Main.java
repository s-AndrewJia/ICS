import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //variables
    double radius, area, circumference;
    final double PI = 3.14;
    
    //ask radius
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter the radius.");
    radius = user_input.nextDouble();
    
    //calculate
    area = PI * radius * radius;
    circumference = 2 * PI * radius * 10 / 10;
    System.out.println("A = " + area + " units ^ 2");
    System.out.println("C = " + circumference + " units");
  }
}