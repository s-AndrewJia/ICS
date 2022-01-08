class Main {
  public static void main(String[] args) {
    /* Question 1
    
    Output: i = 7 and j = 3
    
    Why? the value is changed within the method, but it remains the same outside.
    
    */
    
    
    printRollDice(5);
  }
  
  //Question 2 code here
  public static void printRollDice(int numberOfRolls)  {
    for (int i=1;i<=numberOfRolls;i++) {
      System.out.println("Roll " + i + " is a " + (int)Math.floor(Math.random() * 6 + 1));
    }
  }
}