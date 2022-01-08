/*

  Question 1:
  a) p
  b) 16
  c) C
  d)  Science
  e) -1
  f) omp
  g) omputer Science
  h) -1
  i) u
  j) u

  Question 2:
  a) 8
  b) 6
  c) E
  d) true

  Question 3:
  a) 4
  b) R
  c) 11
  d) CKAROO BANZAI
  e) 4
  f) 6

*/

class Main {
  //Question 4
  public static int count (char c, String s)  {
    int countNumber = 0;
    int temp;

    for (int i=0;i<s.length();i++)  {
      char testingChar = s.charAt(i);
      if (testingChar == c)  {
        countNumber += 1;
      }
    }
    return countNumber;
  }

  //Question 5
  public static String replace (String s, char oldChar, char newChar) {
    char[] tempString = new char[s.length()];

    for (int i=0;i<s.length();i++)  {
      char checkChar = s.charAt(i);
      if (checkChar == oldChar)  {
        tempString[i] = newChar;
      }
      else  {
        tempString[i] = s.charAt(i);
      }
    }
    return String.valueOf(tempString);
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}