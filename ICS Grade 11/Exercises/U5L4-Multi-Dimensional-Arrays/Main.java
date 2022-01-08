/*

  Question 1:
  A: a
  B: a[0]
  C: a[2]
  D: a[0][0]
  E: a[1][2]
  F: a[2][3]

  Question 2:
  a) 1000
  b) 900
  c) 2400

  Question 3:
  a) 427
     391
  b) 43
     29
     71
  c) 391
     427
*/
class Main {
  //Question 5
  public static double sum (double[][] givenArray) {
    double sum = 0;
    for (int i=0;i<givenArray.length;i++) {
      for (int j=0;j<givenArray[0].length;j++)  {
        sum += givenArray[i][j];
      }
    }
    return sum;
  }

  //Question 6
  public static int max (int[][] givenArray)  {
    int max = givenArray[0][0];
    for (int i=0;i<givenArray.length;i++) {
      for (int j=0;j<givenArray[i].length;j++)  {
        if (max < givenArray[i][j]) {
          max = givenArray[i][j];
        }
      }
    }
    return max;
  }

  //Question 7
  public static int size (int[][][] givenArray) {
    int size = 0;
    for (int i=0;i<givenArray.length;i++) {
      for (int j=0;j<givenArray[i].length;j++)  {
        for (int k=0;k<givenArray[i][j].length;k++) {
          size += 1;
        }
      }
    }
    return size;
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    //Question 4
    for (int i=(a[0].length-1);i>=0;i--) {
      for(int j=(a.length-1);j>=0;j--) {
        System.out.print(a[j][i]);
      }
      System.out.println();
    }
  }
}