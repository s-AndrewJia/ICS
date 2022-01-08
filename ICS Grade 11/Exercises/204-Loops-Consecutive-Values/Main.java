import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int givenNumber;
    int consecValuesCount = 0;
    String allNumbers = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    givenNumber = user_input.nextInt();
    
    while (givenNumber != 0)  {
      allNumbers += givenNumber;
      if (givenNumber >= 0)  {
        allNumbers += " ";
      }
      givenNumber = user_input.nextInt();
    }
    
    for (int i=0;i<allNumbers.length();i++) {
      if (i > 1)  {
        if (allNumbers.charAt(i) == allNumbers.charAt(i-2) && Character.isDigit(allNumbers.charAt(i)) == true)  {
          consecValuesCount += 1;
        }
      }

    }
    System.out.println("There are " + consecValuesCount + " cases of consecutive values");
  }
}