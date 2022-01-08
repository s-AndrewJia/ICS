import java.util.Scanner;

class Main {
  public static int[] join (int[] list, int newNum) {
    int[] newList = new int[list.length + 1];
    int i;
    for (i=0;i<list.length;i++) {
      newList[i] = list[i];
    }
    newList[list.length] = newNum;
    return newList;
  }

  public static void main(String[] args) {
    int[] scores = new int[0];
    int[] scoresDistribution = new int[11];
    boolean continueAsking = true;
    int givenScore;
    double total = 0;

    //asking for numbers
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter a score (out of 10), or a negative number to exit: ");

    while (continueAsking == true)  {
      givenScore = user_input.nextInt();

      if (givenScore < 0) {
        continueAsking = false;
      }
      else if (givenScore <= 10)  {
        scores = join(scores, givenScore);
        System.out.println("Enter a score (out of 10), or a negative number to exit: ");
      }
      else  {
        System.out.println("Invalid entry. Please enter a score from 0 to 10, or a negative number to exit");
      }
    }

    //counting the numbers & total
    for (int i=0;i<scores.length;i++) {
      scoresDistribution[scores[i]] += 1;
      total += scores[i];
    }

    //output
    System.out.println("Score       # of Occurrences");
    for (int i=0;i<11;i++)  {
      System.out.print("  ");
      System.out.print(10-i);
      if  (i==0) {
        System.out.print("                ");
      }
      else  {
        System.out.print("                 ");
      }
      System.out.println(scoresDistribution[10-i]);
    }
    System.out.println("\nAverage Score:" + Math.round(10.0 * total/scores.length)/10.0);
  }
}