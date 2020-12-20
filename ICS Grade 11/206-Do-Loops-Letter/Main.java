import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //varibles
    char yourCharacter;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a letter:");
    yourCharacter = user_input.next().charAt(0);
    
    while (!Character.isLetter(yourCharacter)) {
      System.out.println("Not a letter. Enter a letter:");
      yourCharacter = user_input.next().charAt(0);
    }
    System.out.println("Done.");
  }
}