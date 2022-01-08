import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //variables
    int variableN;
    int total = 0;
    
    //ask
    Scanner userinput = new Scanner(System.in);
    System.out.println("Enter N:");
    variableN = userinput.nextInt();
    
    while (variableN < 0) {
      System.out.println("Invalid input.");
      System.out.println("Enter N:");
      variableN = userinput.nextInt();
    }
    
    for (int i=0;i<=variableN;i++)  {
      total += i;
    }
    System.out.println("The sum of the first " + variableN + " integers is " + total);
  }
}