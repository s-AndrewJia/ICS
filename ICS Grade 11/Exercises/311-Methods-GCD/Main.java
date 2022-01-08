import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int int1 = s.nextInt();
  int int2 = s.nextInt();
  
  //call and output gcd of int1 and int2
  System.out.println(greatestCD(int1, int2));
  }
  
  //method
  public static int greatestCD(int val1, int val2)  {
    int large;
    int gcdVar = 0;
    
    if (val1 > val2)  {
      large = val1;
    }
    else  {
      large = val2;
    }
    
    for (int i=1;i<=large;i++)  {
      if (val1 % i == 0 && val2 % i == 0) {
        gcdVar = i;
      }
    }
    
    return gcdVar;
  }
}