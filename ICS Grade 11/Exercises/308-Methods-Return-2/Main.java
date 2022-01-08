class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
  
  /*
  
  a) mystery
  b) a, b
  c) int
  
  */
  
  //d)
  public static in mysteryIf(double a, double b)  {
    int value = 0;
    if (a != b) {
      if (a < b)  {
        value = -1;
      }
      else  {
        value = 1;
      }
    }
    return value;
  }
  
  //e)
  public static int mysteryR(double a, double b)  {
    if (a < b)  {
      return -1;
    }
    else if (a > b)  {
      return 1;
    }
    else {
      return 0;
    }
  }
}