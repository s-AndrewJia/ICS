import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    String palin1;
    String palin1nospace = "";
    String palin2 = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    palin1 = user_input.nextLine().toLowerCase();
    
    for (int i=0;i<=(palin1.length()-1);i++)  {
      if (palin1.charAt(i) != ' ')  {
        palin1nospace += palin1.charAt(i);
      }
    }
    
    for (int i=(palin1.length()-1);i>=0;i--)  {
      if (palin1.charAt(i) != ' ')  {
        palin2 += palin1.charAt(i);
      }
    }
    
    if (palin1nospace.equals(palin2) == true) {
      System.out.println("true");
    }
    else  {
      System.out.println("false");
    }
  }
}