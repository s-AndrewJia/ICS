class Fraction  {
  private int num;
  private int den;

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
    if (d < 0)  {
      this.num = -n;
      this.den = -d;
    }
    else  {
      num = n;
      den = d;
    }
  }
  public Fraction (Fraction f)  {
    this.num = f.num;
    this.den = f.den;
  }
  public Fraction ()  {
    this.num = 0;
    this.den = 1;
  }
  public int getNumerator ()  {
    return this.num;
  }
  public void setDenominator (int newDen)  {
    if (newDen >= 0)  {
      this.den = newDen;
    }
    else  {
      this.den = -newDen;
      this.num *= -1;
    }
  }
  public void invert () {
    int temp = this.num;
    this.num = this.den;
    this.den = temp;

    if (this.den < 0) {
      this.den = -this.den;
      this.num = -this.num;
    }
  }
  public void setNum (int newNum) {
    this.num = newNum;
  }
  public void setDen (int newDen) {
    this.den = newDen;
  }
  public int getNum ()  {
    return this.num;
  }
  public int getDen ()  {
    return this.den;
  }
  public boolean equals (Fraction other)  {
    if (this.num == other.num && this.den == other.den) {
      return true;
    }
    else  {
      return false;
    }
  }
  //Question 1
  //a)
  public static Fraction product (Fraction f1, Fraction f2) {
    Fraction result = new Fraction();
    result.num = f1.num * f2.num;
    result.den = f1.den * f2.den;
    return result;
  }
  //b)
  public static Fraction abs (Fraction f)  {
    Fraction result = new Fraction();
    result.num = Math.abs(f.num);
    result.den = Math.abs(f.den);
    return result;
  }
  //c)
  public static boolean isPositive (Fraction f)  {
    if ((double)f.num/f.den >= 0)  {
      return true;
    }
    return false;
  }
}

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
  public Student (String name)  {
    this.name = name;
    this.grade = 9;
    this.age = 14;
    this.gender = "other";
    this.password = createStudentPassword();
  }
  //Question 2
  //part 1
  public static void display (Student s)  {
    System.out.println("Name: " + s.name);
    System.out.println("Age: " + s.age);
    System.out.println("Grade: " + s.grade);
    System.out.println("Gender: " + s.gender);
  }
}


class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Student s1 = new Student();
    s1.name = "Andrew";
    s1.age = 17;
    s1.grade = 11;
    s1.gender = "M";

    //part 2
    Student.display(s1);

    //part 3
    s1.print();

    //different formatting in both the calling and the writing, instance uses this but class cannot, class uses identifier.method(parameters) whereas instance uses parameter.method
  }
}