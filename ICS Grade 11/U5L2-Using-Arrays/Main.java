/*

  Question 1:
  It would print:
  4
  0
  3

*/

class Main {
  //Question 3
  public static double max (double[] list)  {
    double maxNum = list[0];
    for (int i=0;i<list.length;i++) {
      if (list[i]>maxNum) {
        maxNum = list[i];
      }
    }
    return maxNum;
  }

  //Question 4
  public static boolean equals (double[] list1, double[] list2) {
    if (list1.length != list2.length) {
      return false;
    }
    for (int i=0;i<list1.length;i++)  {
      if (list1[i] != list2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void swap (int[] list, int x, int y)  {
    int temporaryNum = list[x];
    list[x] = list[y];
    list[y] = temporaryNum;
  }

  public static void main(String[] args) {
    //Question 2
    //a)
    int[] sample = new int[10];
    for (int i=0;i<sample.length;i++) {
      sample[i]=1;
    }
    //b)
    swap(sample, 0, 9);
    //c)
    for (int i=0;i<sample.length;i++) {
      if (sample[i]<0)  {
        sample[i] *= -1;
      }
    }
    //d)
    int sampleSum = 0;
    for (int i=0;i<sample.length;i++)  {
      sampleSum += sample[i];
    }
    //e)
    for (int i=0;i<sample.length;i++)  {
      if (i%2 != 0) {
        System.out.println(sample[i]);
      }
    }
  }
}