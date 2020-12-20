import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //do not alter the main
    Scanner s = new Scanner(System.in);
    String check = s.nextLine();
    System.out.println(isLetter(check));
  }
  
  //method
  public static boolean isLetter(String yourGiven)  {
    return yourGiven.length() == 1 && Character.isLetter(yourGiven.charAt(0));
  }
}