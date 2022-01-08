import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //get user input
    Scanner s = new Scanner(System.in);
    double d1 = s.nextDouble();
    double d2 = s.nextDouble();
    double d3 = s.nextDouble();
    double largest;
    
    //output findLargest 
    largest = findLargest(d1, d2, d3);
    System.out.println(largest);
  }
  
  //method
  public static double findLargest(double val1, double val2, double val3)  {
    double largest = val1;
    
    if (val2 > val1 || val3 > val1)  {
      if (val2 > val3)  {
        largest = val2;
      }
      else  {
        largest = val3;
      }
    }
    
    return largest;
  }
}