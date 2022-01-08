import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int bearingInput;
    String defaultResponse = "invalid";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a bearing: ");
    bearingInput = user_input.nextInt();
    
    //calculate
    if (bearingInput >= 360)  {
    }
    else if (bearingInput >= 315) {
      defaultResponse = "closest to North";
    }
    else if (bearingInput > 225) {
      defaultResponse = "closest to West";
    }
    else if (bearingInput >= 135) {
      defaultResponse = "closest to South";
    }
    else if (bearingInput > 45) {
      defaultResponse = "closest to East";
    }
    else if (bearingInput >= 0) {
      defaultResponse = "closest to North";
    }
    System.out.println("Bearing " + bearingInput + " is " + defaultResponse);
  }
}