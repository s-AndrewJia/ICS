import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variable
    String grade = "";
    String gradeRange = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter Letter Grade.");
    grade = user_input.nextLine().toLowerCase();
    
    //check
    switch (grade)  {
      case "a":
        gradeRange = "Range: 80-100";
        break;
      case "b":
        gradeRange = "Range: 70-79";
        break;
      case "c":
        gradeRange = "Range: 60-69";
        break;
      case "d":
        gradeRange = "Range: 50-59";
        break;
      case "f":
        gradeRange = "Range: Failure";
        break;
      default:
        gradeRange = "Invalid";
    }
    System.out.println(gradeRange);
  }
}