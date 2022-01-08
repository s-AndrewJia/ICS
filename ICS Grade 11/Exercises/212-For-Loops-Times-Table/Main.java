import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int integerN;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    integerN = user_input.nextInt();
    for (int i=1;i<=integerN;i++) {
      System.out.println(integerN + " x " + i + " = " + (integerN * i));
    }
  }
}