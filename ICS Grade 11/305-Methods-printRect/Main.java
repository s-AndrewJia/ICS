import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    char c;
    int width, height;
    
    width = height = 0;
    
    //get
    Scanner user_input = new Scanner(System.in);
    c = user_input.nextLine().charAt(0);
    width = user_input.nextInt();
    height = user_input.nextInt();
    
    printRect(c, width, height);
  }
  
  //method
  public static void printRect(char c, int width, int height) {
    for (int i=0;i<height;i++)  {
      for (int j=0;j<width;j++) {
        System.out.print(c);
      }
      System.out.println();
    }
  }
}