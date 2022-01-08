import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variable
    float tempInFarenheit;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Temp in F:");
    tempInFarenheit = user_input.nextFloat();
    
    //calculate
    System.out.println("Temp in C:\n" + ((float)Math.round((tempInFarenheit - 32) * 5.0 / 9 * 10) / 10));
  }
}