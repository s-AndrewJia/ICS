import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int bearingInput;
    String dir1 = "invalid";
    String ang = "";
    String dir2 = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a bearing:");
    bearingInput = user_input.nextInt();
    
    //calculate
    if (bearingInput >= 360)  {
    }
    else if (bearingInput >= 315) {
      dir1 = "N";
      ang += (360 - bearingInput);
      dir2 = "W";
    }
    else if (bearingInput > 225) {
      dir1 = "W";
      //this may be less efficient, but it keeps dir1="W" within one if statement. Makes it more organized, in my opinion.
      if (bearingInput >= 270)  {
        ang += (bearingInput - 270);
        dir2 = "N";
      }
      else  {
        ang += (270 - bearingInput);
        dir2 = "S";
      }
    }
    else if (bearingInput >= 135) {
      dir1 = "S";
      if (bearingInput >= 180)  {
        ang += (bearingInput - 180);
        dir2 = "W";
      }
      else  {
        ang += (180 - bearingInput);
        dir2 = "E";
      }
    }
    else if (bearingInput > 45) {
      dir1 = "E";
      if (bearingInput >= 90)  {
        ang += (bearingInput - 90);
        dir2 = "S";
      }
      else  {
        ang += (90 - bearingInput);
        dir2 = "N";
      }
    }
    else if (bearingInput >= 0) {
      dir1 = "N";
      ang += bearingInput;
      dir2 = "E";
    }
    
    //erase if multiple of 90 or 45
    if (bearingInput % 90 == 0) {
      ang = "";
      dir2 = "";
    }
    else if (bearingInput % 45 == 0)  {
      ang = "";
    }
    
    System.out.println("Bearing " + bearingInput + " is " + dir1 + ang + dir2);
  }
}