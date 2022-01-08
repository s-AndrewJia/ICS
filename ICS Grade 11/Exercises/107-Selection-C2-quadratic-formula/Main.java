import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    float quadA, quadB, quadC;
    String howManySolu = "no solution";
    String soluOne = "";
    String ifTwo = "";
    String soluTwo = "";
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter quadratic equation a, b and c");
    quadA = user_input.nextFloat();
    quadB = user_input.nextFloat();
    quadC = user_input.nextFloat();
    
    if (Math.pow(quadB, 2) - 4 * quadA * quadC == 0) {
      howManySolu = "one solution";
      soluOne = " x=" + Math.round(10 * -1 * quadB / (2 * quadA)) / 10.0;
    }
    else if (Math.pow(quadB, 2) - 4 * quadA * quadC > 0)  {
      howManySolu = "two solutions";
      ifTwo = " and";
      soluOne = " x=" + Math.round(10 * (-1 * quadB + Math.sqrt(Math.pow(quadB, 2) - 4 * quadA * quadC)) / (2 * quadA)) / 10.0;
      soluTwo = " x=" + Math.round(10 * (-1 * quadB - Math.sqrt(Math.pow(quadB, 2) - 4 * quadA * quadC)) / (2 * quadA)) / 10.0;
    }
    System.out.println("This has " + howManySolu + soluTwo + ifTwo + soluOne);
  }
}