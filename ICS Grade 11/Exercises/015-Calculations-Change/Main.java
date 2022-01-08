import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int moneyCents;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter cents.");
    moneyCents = user_input.nextInt();
    System.out.println("Quarters " + (int)Math.floor(moneyCents / 25) + ", dimes " + (int)Math.floor((moneyCents % 25) / 10) + ", nickels " + (int)Math.floor((moneyCents % 25 % 10) / 5) + ", pennies " + (moneyCents % 25 % 10 % 5));
  }
}