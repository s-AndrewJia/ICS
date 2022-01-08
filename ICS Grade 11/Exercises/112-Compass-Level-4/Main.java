import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int whichConversion, bearingInput, compassAngle;
    String compassDirection1 = "Invalid - please enter valid choice";
    String compassDirection2 = "";
    String outputIs = "";
    String compassAngleOutput = "";
    //add invalid for whichConversion!!!
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("(1) convert bearing to compass \n(2) convert compass to bearing \nChoose: ");
    whichConversion = user_input.nextInt();
    
    //bearing to compass
    if (whichConversion == 1) {
      System.out.println("Enter bearing: ");
      bearingInput = user_input.nextInt();
      
      outputIs += "Bearing " + bearingInput + " is ";
      
      //if over 360 or less than 0, convert to 0-359
      if (bearingInput >= 360) {
        while (bearingInput >= 360) {
          bearingInput -= 360;
        }
      }
      else if (bearingInput < 0)  {
        while (bearingInput < 0)  {
          bearingInput = 360 + bearingInput;
        }
      }
      if (bearingInput >= 360)  {
      }
      else if (bearingInput >= 315) {
        compassDirection1 = "N";
        compassAngleOutput += (360 - bearingInput);
        compassDirection2 = "W";
      }
      else if (bearingInput > 225) {
        compassDirection1 = "W";
        //this may be less efficient, but it keeps compassDirection1="W" within one if statement. Makes it more organized, in my opinion.
        if (bearingInput >= 270)  {
          compassAngleOutput += (bearingInput - 270);
          compassDirection2 = "N";
        }
        else  {
          compassAngleOutput += (270 - bearingInput);
          compassDirection2 = "S";
        }
      }
      else if (bearingInput >= 135) {
        compassDirection1 = "S";
        if (bearingInput >= 180)  {
          compassAngleOutput += (bearingInput - 180);
          compassDirection2 = "W";
        }
        else  {
          compassAngleOutput += (180 - bearingInput);
          compassDirection2 = "E";
        }
      }
      else if (bearingInput > 45) {
        compassDirection1 = "E";
        if (bearingInput >= 90)  {
          compassAngleOutput += (bearingInput - 90);
          compassDirection2 = "S";
        }
        else  {
          compassAngleOutput += (90 - bearingInput);
          compassDirection2 = "N";
        }
      }
      else if (bearingInput >= 0) {
        compassDirection1 = "N";
        compassAngleOutput += bearingInput;
        compassDirection2 = "E";
      }
      
      //erase if multiple of 90 or 45
      if (bearingInput % 90 == 0) {
        compassAngleOutput = "";
        compassDirection2 = "";
      }
      else if (bearingInput % 45 == 0)  {
        compassAngleOutput = "";
      }
    }
    
    //compass to bearing
    else if (whichConversion == 2)  {
      System.out.println("Compass direction: ");
      compassDirection1 = user_input.next().toUpperCase();
      System.out.println("Compass angle: ");
      compassAngle = user_input.nextInt();
      System.out.println("Compass direction: ");
      compassDirection2 = user_input.next().toUpperCase();
      
      outputIs += "Compass " + compassDirection1 + compassAngle + compassDirection2 + " is ";
      compassAngleOutput = "a bearing of ";
      
      if (compassDirection2.equals("N") == false && compassDirection2.equals("E") == false && compassDirection2.equals("S") == false && compassDirection2.equals("W") == false) {
        System.out.println("Invalid entry.");
        System.exit(0);
      }
      
      //check over 45
      if (compassAngle > 45 || compassAngle < 0)  {
        System.out.println("Invalid entry - negative numbers are invalid, and numbers over 45 should be instead preceeded with the opposing direction.");
        System.exit(0);
      }
      
      switch (compassDirection1)  {
        case "N":
          if (compassDirection2.equals("W") == true) {
            compassAngle *= -1;
            compassAngle += 360;
          }
          else if (compassDirection2.equals("S") == true) {
            System.out.println("Invalid Entry - opposing directions.");
            System.exit(0);
          }
          break;
        case "E":
          if (compassDirection2.equals("N") == true)  {
            compassAngle *= -1;
          }
          else if (compassDirection2.equals("W") == true) {
            System.out.println("Invalid Entry - opposing directions.");
            System.exit(0);
          }
          compassAngle += 90;
          break;
        case "S":
          if (compassDirection2.equals("E") == true)  {
            compassAngle *= -1;
          }
          else if (compassDirection2.equals("N") == true) {
            System.out.println("Invalid Entry - opposing directions.");
            System.exit(0);
          }
          compassAngle += 180;
          break;
        case "W":
          if (compassDirection2.equals("S") == true)  {
            compassAngle *= -1;
          }
          else if (compassDirection2.equals("E") == true) {
            System.out.println("Invalid Entry - opposing directions.");
            System.exit(0);
          }
          compassAngle += 270;
          break;
        default:
          //only checks direction 1, so 2 checked earlier
          System.out.println("Invalid entry.");
          System.exit(0);
      }
      compassAngleOutput += compassAngle;
      compassDirection1 = "";
      compassDirection2 = "";
    }
    
    System.out.println(outputIs + compassDirection1 + compassAngleOutput + compassDirection2);
  }
}