import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    float sqrtNumber, deciNumber;
    int baseNumber, expoNumber, intNumber, randLow, randHigh;
    
    //sqrt
    Scanner user_input = new Scanner(System.in);
    System.out.println("Square Root\nInput a positive number:");
    sqrtNumber = user_input.nextFloat();
    System.out.println("The square root of " + sqrtNumber + " is " + Math.sqrt(sqrtNumber));
    
    //expo
    System.out.println("\nExponents\nInput a base:");
    baseNumber = user_input.nextInt();
    System.out.println("Input a power:");
    expoNumber = user_input.nextInt();
    System.out.println(baseNumber + " to the power of " + expoNumber + " is " + Math.pow(baseNumber, expoNumber));
    
    //round ceil floor
    System.out.println("\nRounding, Ceiling, and Floor\nInput a decimal value.");
    deciNumber = user_input.nextFloat();
    System.out.println(deciNumber + "\n" + deciNumber + " rounds to " + Math.round(deciNumber));
    System.out.println(deciNumber + " ceiling is " + Math.ceil(deciNumber));
    System.out.println(deciNumber + " floor is " + Math.floor(deciNumber));
    
    //random
    System.out.println("\nRandom\nEnter the lower limit.");
    randLow = user_input.nextInt();
    System.out.println("Enter the upper limit.");
    randHigh = user_input.nextInt();
    System.out.println("A random number between " + randLow + " and " + randHigh + " is " + Math.floor(Math.random() * (randHigh - randLow) + randLow));
    }
}