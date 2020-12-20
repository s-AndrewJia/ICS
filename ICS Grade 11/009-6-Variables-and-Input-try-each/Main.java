import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    //varibles
    String newString;
    char newChar;
    int newInt;
    float newFloat;
    final int newConst = 4;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a string.");
    newString = user_input.nextLine();
    System.out.println("Enter a character.");
    newChar = user_input.nextLine().charAt(0);
    System.out.println("Enter an integer.");
    newInt = user_input.nextInt();
    System.out.println("Enter a floating point value.");
    newFloat = user_input.nextFloat();
    
    //out
    System.out.println("\n\""+ newString + "\". What a cool thought!");
    System.out.println("\""+ newChar + "\"? Hey, how did you know that was my favourite letter?");
    System.out.println("The integer " + newInt + "? hmmm...");
    System.out.println("I like "+ newConst + " better though.");
    System.out.println(newFloat + " is more precise too... You chose a bad number :(");
  }
}