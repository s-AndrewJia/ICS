class Main {
  public static void main(String[] args)  {
    givenTotal();
  }
  
  //method
  public static void givenTotal() {
    int num1 = (int)Math.floor(Math.random() * 6 + 1);
    int num2 = (int)Math.floor(Math.random() * 6 + 1);
    
    System.out.println(num1 + " and " + num2 + ": a total of " + (num1 + num2));
  }
}