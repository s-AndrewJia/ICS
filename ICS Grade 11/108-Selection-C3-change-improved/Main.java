import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int moneyCents;
    String quarterWord = "";
    String dimeWord = "";
    String nickelWord = "";
    String pennyWord = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter amount less than $1");
    moneyCents = user_input.nextInt();
    
    //the return of the variables
    int quarters = (int)Math.floor(moneyCents / 25);
    int dimes = (moneyCents % 25) / 10;
    int nickels = (moneyCents % 25 % 10) / 5;
    int pennies = moneyCents % 25 % 10 % 5;
    String quarterNumber = "";
    String dimeNumber = "";
    String nickelNumber = "";
    String pennyNumber = "";
    
    //out
    //I was able to make it with a deafult without the "if (quarters != =)"... stuff, but adding the commas
    //for only if they have words behind them made the nested loop more efficient I think
    if (quarters != 0)  {
      if (quarters == 1) {
        quarterWord = " quarter";
        quarterNumber = quarterNumber + quarters;
      }
      else if (quarters > 1)  {
        quarterWord = " quarters";
        quarterNumber = quarterNumber + quarters;
      }
      if (moneyCents % 25 != 0) {
        quarterWord += ", ";
      }
      else  {
        quarterWord += " ";
      }
    }
    if (dimes != 0) {
      if (dimes == 1) {
        dimeWord = " dime";
        dimeNumber = dimeNumber + dimes;
      }
      else if (dimes > 1) {
        dimeWord = " dimes";
        dimeNumber = dimeNumber + dimes;
      }
      if (moneyCents % 25 % 10 != 0)  {
        dimeWord += ", ";
      }
      else  {
        dimeWord += " ";
      }
    }
    
    if (nickels != 0) {
      if (nickels == 1) {
        nickelWord = " nickel";
        nickelNumber = nickelNumber + nickels;
      }
      else if (nickels > 1)  {
        nickelWord = " nickels";
        nickelNumber = nickelNumber + nickels;
      }
      if (moneyCents % 25 % 10 % 5 != 0)  {
        nickelWord += ", ";
      }
      else  {
        nickelWord += " ";
      }
    }
    
    if (pennies == 1) {
      pennyWord = " penny";
      pennyNumber = pennyNumber + pennies;
    }
    else if (pennies > 1) {
      pennyWord = " pennies";
      pennyNumber = pennyNumber + pennies;
    }
    
  System.out.println("Your change is: " + quarterNumber+ quarterWord + dimeNumber + dimeWord  + nickelNumber + nickelWord  + pennyNumber + pennyWord);
  }
}