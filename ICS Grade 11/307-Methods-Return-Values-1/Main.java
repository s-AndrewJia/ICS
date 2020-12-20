class Main {
  public static void main(String[] args) {
    //Call to 1a
    //System.out.println(randomNumber());
    
    //Call to 1b
    //System.out.println(randomNumber(10));
    
    //Call to 1c
    //System.out.println(randomNumber(1,10));
    
    //Call to 1d
    System.out.println(randomNumber(10,100,5));
  }
  //write methods here
  
  //1a
  /*public static int randomNumber()  {
    return (int)Math.floor(Math.random() * 6 + 1);
  }*/
  
  //1b
  /*public static int randomNumber(int high)  {
    return (int)Math.floor(Math.random() * high + 1);
  }*/
  
  //1c
  /*public static int randomNumber(int min, int max)  {
    return (int)Math.floor(Math.random() * (max - min + 1) + min);
  }*/
  
  //1d
  public static int randomNumber(int min, int max, int step)  {
    return (int)Math.floor(Math.random() * ((max - min) / step + 1)) * step + min;
  }
}