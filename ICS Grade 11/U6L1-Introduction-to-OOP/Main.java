/*

  Question 1:
  Fraction f = new Fraction();
  f.num = 2;
  f.den= 7;

  Question 2:
  Need to instantiate the fraction object in order to create an instance of the Fraction class in the computer's memory

  Question 3:
  p = 1/3
  q = 4/3
  r = 4/3

  Question 4:
  a) f1.num = f1.num * 2;
  b) int tempNum = f2.num;
     f2.num = f2.den;
     f2.den = tempNum;
  c) f1.num = f1.num * f2.num;
     f1.den = f1.den * f2.den;
  d) f2.num = f2.num * f1.den + f1.num * f2.den;
     f2.den = f2.den * f1.den;
  e) f1.num = Math.abs(f1.num);
     f1.den = Math.abs(f1.den);

*/

class Fraction  {
  int num;
  int den;

  public double size () {
    return Math.abs((double)num/den);
  }
}

//Question 5
class student {
  String name;
  int age;
  int grade;
  String gender;
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    student student1 = new student();
    student1.name = "Andrew";
    student1.age = 17;
    student1.grade = 97;
    student1.gender = "M";

    student student2 = new student();
    student2.name = "John";
    student2.age = 18;
    student2.grade = 87;
    student2.gender = "M";

    student student3 = new student();
    student3.name = "Jenny";
    student3.age = 15;
    student3.grade = 99;
    student3.gender = "F";

    student student4 = new student();
    student4.name = "Kayla";
    student4.age = 19;
    student4.grade = 84;
    student4.gender = "F";
  }
}