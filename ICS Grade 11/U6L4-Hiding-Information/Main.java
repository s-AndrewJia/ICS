/*

  Question 1:
  Accessor methods are methods that allow us to get the values in private fields. Mutator methods are methods that allow us to change values in private fields.

  Question 2:
  It should, because you're working within the same class

*/

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
}


class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}