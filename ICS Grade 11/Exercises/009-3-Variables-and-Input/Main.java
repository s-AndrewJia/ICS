import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //variables
    float grade1, grade2, grade3, grade4, gradeAverage;
    
    //input
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter your grades. ");
    grade1 = user_input.nextFloat();
    grade2 = user_input.nextFloat();
    grade3 = user_input.nextFloat();
    grade4 = user_input.nextFloat();
    
    //calculate
    gradeAverage = (grade1 + grade2 + grade3 + grade4) / 4;
    System.out.println("\nThe average is: " + gradeAverage);
  }
}