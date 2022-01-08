import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    double sumOfFractions, sumOfRootsb, sumOfRootse;
    long product1to20 = 1;
    int sumOfCubes = 0;
    
    //initialize
    sumOfFractions = sumOfRootsb = sumOfRootse = 0;
    
    //a
    for (double i=1;i<=1000;i++)  {
      sumOfFractions += 1 / i;
    }
    
    //b
    for (double i=100;i<=5000;i+=100) {
      sumOfRootsb += Math.sqrt(i);
    }
    
    //c
    for (long i=1;i<=20;i++)  {
      product1to20 *= i;
    }
    
    //d
    for (int i=-12;i<=20;i++) {
      sumOfCubes += Math.pow(i, 3);
    }
    
    //e
    for (double i=1;i<=25;i++)  {
      sumOfRootse += Math.pow(i, 1 / i);
    }
    
    System.out.println(sumOfFractions);
    System.out.println(sumOfRootsb);
    System.out.println(product1to20);
    System.out.println(sumOfCubes);
    System.out.println(sumOfRootse);
  }
}