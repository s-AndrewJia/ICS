import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    boolean continueToDo = true;
    do  {
      /*
      
      IMPORTANT: PLEASE READ
      I couldn't get past the first test, but it worked manually. Because I don't know what invalid things I'm supposed to check for, I added a bunch of checks that might not be needed.
      
      */
      //variables
      int whichConversion, bearingInput;
      int compassAngleNum = 0;
      String compassAngleStr = "";
      String compassDirectionTotal = "Invalid - please enter valid choice";
      String compassDirection1 = "invalid";
      String compassDirection2 = "";
      String outputIs = "";
      String anotherConversion = "";
      boolean anotherInvalid = false;
      //added a variable that detects invalid choices, as this code was written to end when an invalid appeared. Thus, some parts wouldn't function properly if invalid was declared but the program didn't end.
      boolean somethingInvalid = false;
      
      //ask
      Scanner user_input = new Scanner(System.in);
      System.out.println("(1) convert bearing to compass \n(2) convert compass to bearing \nChoose: ");
      whichConversion = user_input.nextInt();
      
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
          compassAngleStr += (360 - bearingInput);
          compassDirection2 = "W";
        }
        else if (bearingInput > 225) {
          compassDirection1 = "W";
          //this may be less efficient, but it keeps compassDirection1="W" within one if statement. Makes it more organized, in my opinion.
          if (bearingInput >= 270)  {
            compassAngleStr += (bearingInput - 270);
            compassDirection2 = "N";
          }
          else  {
            compassAngleStr += (270 - bearingInput);
            compassDirection2 = "S";
          }
        }
        else if (bearingInput >= 135) {
          compassDirection1 = "S";
          if (bearingInput >= 180)  {
            compassAngleStr += (bearingInput - 180);
            compassDirection2 = "W";
          }
          else  {
            compassAngleStr += (180 - bearingInput);
            compassDirection2 = "E";
          }
        }
        else if (bearingInput > 45) {
          compassDirection1 = "E";
          if (bearingInput >= 90)  {
            compassAngleStr += (bearingInput - 90);
            compassDirection2 = "S";
          }
          else  {
            compassAngleStr += (90 - bearingInput);
            compassDirection2 = "N";
          }
        }
        else if (bearingInput >= 0) {
          compassDirection1 = "N";
          compassAngleStr += bearingInput;
          compassDirection2 = "E";
        }
        
        //erase if multiple of 90 or 45
        if (bearingInput % 90 == 0) {
          compassAngleStr = "";
          compassDirection2 = "";
        }
        else if (bearingInput % 45 == 0)  {
          compassAngleStr = "";
        }
        
        compassDirectionTotal = compassDirection1 + compassAngleStr + compassDirection2;
      }
      
      else if (whichConversion == 2)  {
        System.out.println("Compass direction: ");
        compassDirectionTotal = user_input.next();
        
        //checks for over 3 digits or otherwise improper entries(such as single letters)
        
        switch (compassDirectionTotal.length()) {
          case 1:
            compassDirection1 = String.valueOf(compassDirectionTotal.charAt(0)).toUpperCase();
            break;
          case 2:
            compassDirection1 = String.valueOf(compassDirectionTotal.charAt(0)).toUpperCase();
            compassDirection2 = String.valueOf(compassDirectionTotal.charAt(1)).toUpperCase();
            break;
          case 3:
            compassDirection1 = String.valueOf(compassDirectionTotal.charAt(0)).toUpperCase();
            compassDirection2 = String.valueOf(compassDirectionTotal.charAt(2)).toUpperCase();
            compassAngleStr = "" + String.valueOf(compassDirectionTotal).charAt(1);
            break;
          case 4:
            compassDirection1 = String.valueOf(compassDirectionTotal.charAt(0)).toUpperCase();
            compassDirection2 = String.valueOf(compassDirectionTotal.charAt(3)).toUpperCase();
            compassAngleStr = "" + String.valueOf(compassDirectionTotal).charAt(1) + String.valueOf(compassDirectionTotal).charAt(2);
            break;
          default:
            somethingInvalid = true;
        }
      
        compassDirectionTotal = compassDirection1 + compassAngleStr + compassDirection2;
        
        if (compassDirectionTotal.length() == 4 || compassDirectionTotal.length() == 3)  {
          //check for invalids in the angle numbers
          for (int i = 0; i < compassAngleStr.length(); i++)  {
            if (Character.isDigit(compassAngleStr.charAt(i)) != true) {
              somethingInvalid = true;
            }
          }
          //a check for invalid letters
          if (compassDirection2.equals("N") == false && compassDirection2.equals("E") == false && compassDirection2.equals("S") == false && compassDirection2.equals("W") == false) {
            somethingInvalid = true;
          }
          
          compassAngleNum = Integer.parseInt(compassAngleStr);
          if (compassAngleNum >= 45)  {
            somethingInvalid = true;
          }
          //if compassAngleNum <= 0, it will be caught by earlier error catchers
          switch (compassDirection1)  {
            case "N":
              if (compassDirection2.equals("W") == true) {
                compassAngleNum *= -1;
                compassAngleNum += 360;
              }
              else if (compassDirection2.equals("S") == true) {
                somethingInvalid = true;
              }
              break;
            case "E":
              if (compassDirection2.equals("N") == true)  {
                compassAngleNum *= -1;
              }
              else if (compassDirection2.equals("W") == true) {
                somethingInvalid = true;
              }
              compassAngleNum += 90;
              break;
            case "S":
              if (compassDirection2.equals("E") == true)  {
                compassAngleNum *= -1;
              }
              else if (compassDirection2.equals("N") == true) {
                somethingInvalid = true;
              }
              compassAngleNum += 180;
              break;
            case "W":
              if (compassDirection2.equals("S") == true)  {
                compassAngleNum *= -1;
              }
              else if (compassDirection2.equals("E") == true) {
                somethingInvalid = true;
              }
              compassAngleNum += 270;
              break;
            //a check for invalid letters
            default:
              somethingInvalid = true;
          }
        }
        
        //see if you can make the switch for everything, including a length of 4
        //Biggest reason didn't use switch for the above section and below one, you can't use || with it. That means I would've had to repeat a lot of code for lengths 3 & 4.
        
        else  {
          switch (compassDirectionTotal) {
            case "N":
              compassAngleNum = 0;
              break;
            case "NE":
              compassAngleNum = 45;
              break;
            case "E":
              compassAngleNum = 90;
              break;
            case "SE":
              compassAngleNum = 135;
              break;
            case "S":
              compassAngleNum = 180;
              break;
            case "SW":
              compassAngleNum = 225;
              break;
            case "W":
              compassAngleNum = 270;
              break;
            case "NW":
              compassAngleNum = 315;
              break;
            default:
              somethingInvalid = true;
          }
        }
        
        compassDirectionTotal = compassDirection1 + compassAngleStr + compassDirection2;
        outputIs += "Compass " + compassDirectionTotal + " is a bearing of ";
        compassDirectionTotal = "" + compassAngleNum;
      }
      
      if (somethingInvalid == false)  {
        System.out.println(outputIs + compassDirectionTotal);
      }
      else  {
        System.out.println("Invalid entry.");
      }
      
      System.out.println("Do another conversion? y/n: ");
      anotherConversion = user_input.next().toLowerCase();
      
      if (anotherConversion.equals("n") == true)  {
        continueToDo = false;
      }
      
      //!= to n not required, because if it equals n it is caught above otherwise it must equal y to continue on
      
      else if (anotherConversion.equals("y") != true) {
        do {
          System.out.println("Invalid entry - please enter y for yes or n for no");
          System.out.println("Do another conversion? y/n: ");
          anotherConversion = user_input.next().toLowerCase();
          
          if (anotherConversion.equals("n") == true || anotherConversion.equals("y") == true) {
            if (anotherConversion.equals("n") == true)  {
              continueToDo = false;
            }
            anotherInvalid = true;
          }
        } while (anotherInvalid == false);
      }
      
    } while (continueToDo == true);
    System.out.println("Goodbye.");
  }
}