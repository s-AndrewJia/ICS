//Question 1
class Fraction  {
  int num;
  int den;

  public double size () {
    return Math.abs((double)num/den);
  }
  public boolean isLargerThan (Fraction other)  {
    if (this.size() >= other.size())  {
      return true;
    }
    else  {
      return false;
    }
  }
  public Fraction larger (Fraction other) {
    if (this.size() >= other.size())  {
      return this;
    }
    else  {
      return other;
    }
  }
  public void timesEquals (Fraction p)  {
    this.num *= p.num;
    this.den *= p.den;
  }
  public Fraction times (Fraction other)  {
    Fraction result = new Fraction();
    result.num = this.num * other.num;
    result.den = this.den * other.den;
    return result;
  }
  public void plusEquals (Fraction other) {
    this.num = this.num * other.den + other.num * this.den;
    this.den = this.den * other.den;
  }
  public Fraction plus (Fraction other) {
    Fraction result = new Fraction();
    result.num = this.num * other.den + other.num * this.den;
    result.den = this.den * other.den;
    return result;
  }
  public void reduce ()  {
    int greatestCommonFactor = 1;
    for (int i=2;i<=this.num && i<this.den;i++) {
      if (this.num % i == 0 && this.den % i == 0) {
        greatestCommonFactor = i;
      }
    }

    this.num = this.num / greatestCommonFactor;
    this.den = this.den / greatestCommonFactor;
  }
  public Fraction (int n, int d)  {
    this.num = n;
    this.den = d;
  }
  public Fraction (Fraction f)  {
    this.num = f.num;
    this.den = f.den;
  }
  public Fraction ()  {
    this.num = 0;
    this.den = 1;
  }
}

//Question 3
class Student {
  String name;
  int age;
  int grade;
  String gender;
  String password;
  String address;
  String homePhone;
  String parentEmail;

  public void print ()  {
    System.out.println("Name: " + this.name);
    System.out.println("Age: " + this.age);
    System.out.println("Grade: " + this.grade);
    System.out.println("Gender: " + this.gender);
  }
  public String createStudentPassword ()  {
    String password = "";
    String[] charBank = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};

    for (int i=0;i<8;i++) {
      String randChar = charBank[(int)Math.floor(Math.random() * 62)];
      password = password.concat(randChar);
    }
    return password;
  }
  public void copyAddress (Student other)  {
    this.address = other.address;
    this.homePhone = other.homePhone;
    this.parentEmail = other.parentEmail;
  }
  public Student () {
    this.name = "student";
    this.grade = 9;
    this.age = 14;
    this.gender = "other";
    this.password = createStudentPassword();
  }
  public Student (String name, int age, int grade, String gender, String address) {
    this.name = name;
    this.age = age;
    this.grade = grade;
    this.gender = gender;
    this.address = address;
  }
  
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    //Question 2
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(f1);
    Fraction f3 = new Fraction();

    System.out.println(f1.num + " / " + f1.den);
    System.out.println(f2.num + " / " + f2.den);
    System.out.println(f3.num + " / " + f3.den);
  }
}