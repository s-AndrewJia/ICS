import java.util.Scanner;

class Rectangle {
  private int left;
  private int bot;
  private int width;
  private int height;

  public static final String ANSI_RESET = "\u001B[0m";

  public static final String ANSI_UNDERLINE = "\u001B[4m";

  public static final String ANSI_NOUNDERLINE = "\u001B[24m";

  public static final String RED_BACKGROUND = "\u001B[41m";
  public static final String BLUE_BACKGROUND = "\u001B[44m";
  public static final String PURPLE_BACKGROUND = "\u001B[45m";
  public static final String WHITE_BACKGROUND = "\u001B[47m";

  public Rectangle () {
    this.left = 0;
    this.bot = 0;
    this.width = 0;
    this.height = 0;
  }
  public Rectangle (int l, int b, int w, int h) {
    this.left = l;
    this.bot = b;
    this.width = w;
    this.height = h;
    if (w < 0)  {
      this.width = 0;
    }
    if (h < 0)  {
      this.height = 0;
    }
  }
  public Rectangle (Rectangle r)  {
    this.left = r.left;
    this.bot = r.bot;
    this.width = r.width;
    this.height = r.height;
  }
  public void set (int l, int b, int w, int h)  {
    this.left = l;
    this.bot = b;
    this.width = w;
    this.height = h;
    if (w < 0)  {
      this.width = 0;
    }
    if (h < 0)  {
      this.height = 0;
    }
  }

  //to make it able to go negative
  public void setLeft (int l) {
    this.left = l;
  }
  public void setBot (int b) {
    this.bot = b;
  }
  public void setWidth (int w) {
    this.width = w;
    if (this.width < 0)  {
      this.width = -w;
      this.left += w;
    }
  }
  public void setHeight (int h) {
    this.height = h;
    if (this.height < 0)  {
      this.height = -h;
      this.bot += h;
    }
  }

  //to get the private
  public int getLeft () {
    return this.left;
  }
  public int getBot () {
    return this.bot;
  }
  public int getWidth () {
    return this.width;
  }
  public int getHeight () {
    return this.height;
  }

  public String toString () {
    return("base: " + "(" + this.left + "," + this.bot + ") w:" + this.width + " h:" + this.height);
  }
  public int area ()  {
    int a;
    a = this.width * this.height;
    return a;
  }
  public int perimeter ()  {
    int peri;
    if (this.width == 0 || this.height == 0)  {
    peri = this.width + this.height;
    }
    else  {
      peri = 2 * this.width + 2 * this.height;
    }
    return peri;
  }
  private int peri () {
    int peri;
    peri = 2 * this.width + 2 * this.height;
    return peri;
  }
  public boolean contains (Rectangle other)  {
    if (this.width >= other.width && this.height >= other.height) {
      if (other.left >= this.left && other.bot >= this.bot) {
        if (other.left - this.left <= this.width - other.width) {
          if (other.bot - this.bot <= this.height - other.height) {
            return true;
          }
        }
      }
    }
    return false;
  }
  public static Rectangle[] rectanglePositions (Rectangle r1, Rectangle r2)  {
    Rectangle[] positionsArray = new Rectangle[8];

    //lefter at 0, leftrighter at 1, lower at 2, lowhigher at 3, righter at 4, rightlefter at 5, higher at 6, highlower at 7

    if (r1.left <= r2.left) {
      positionsArray[0] = new Rectangle(r1);
      positionsArray[1] = new Rectangle(r2);
      if (r1.left + r1.width > r2.left + r2.width)  {
        positionsArray[4] = new Rectangle(r1);
        positionsArray[5] = new Rectangle(r2);
      }
      else  {
        positionsArray[4] = new Rectangle(r2);
        positionsArray[5] = new Rectangle(r1);
      }
    }
    else  {
      positionsArray[0] = new Rectangle(r2);
      positionsArray[1] = new Rectangle(r1);
      if (r2.left + r2.width > r1.left + r1.width)  {
        positionsArray[4] = new Rectangle(r2);
        positionsArray[5] = new Rectangle(r1);
      }
      else  {
        positionsArray[4] = new Rectangle(r1);
        positionsArray[5] = new Rectangle(r2);
      }
    }

    if (r1.bot <= r2.bot) {
      positionsArray[2] = new Rectangle(r1);
      positionsArray[3] = new Rectangle(r2);
      if (r1.bot + r1.height > r2.bot + r2.height) {
        positionsArray[6] = new Rectangle(r1);
        positionsArray[7] = new Rectangle(r2);
      }
      else  {
        positionsArray[6] = new Rectangle(r2);
        positionsArray[7] = new Rectangle(r1);
      }
    }
    else  {
      positionsArray[2] = new Rectangle(r2);
      positionsArray[3] = new Rectangle(r1);
      if (r2.bot + r2.height > r1.bot + r1.height) {
        positionsArray[6] = new Rectangle(r2);
        positionsArray[7] = new Rectangle(r1);
      }
      else  {
        positionsArray[6] = new Rectangle(r1);
        positionsArray[7] = new Rectangle(r2);
      }
    }


    return positionsArray;
  }
  private static boolean crossover (Rectangle r1, Rectangle r2)  {
    Rectangle[] positionsArray = Rectangle.rectanglePositions(r1, r2);

    Rectangle lefterRectangle = new Rectangle(positionsArray[0]);
    Rectangle leftRighterRectangle = new Rectangle(positionsArray[1]);
    Rectangle lowerRectangle = new Rectangle(positionsArray[2]);
    Rectangle lowHigherRectangle = new Rectangle(positionsArray[3]);

    if (lefterRectangle.left + lefterRectangle.width >= leftRighterRectangle.left) {
      if (lowerRectangle.bot + lowerRectangle.height >= lowHigherRectangle.bot)  {
        return true;
      }
    }

    return false;
  }
  public static Rectangle intersection (Rectangle r1, Rectangle r2) {
    Rectangle intersectedRectangle = new Rectangle();

    Rectangle[] positionsArray = Rectangle.rectanglePositions(r1, r2);

    Rectangle lefterRectangle = new Rectangle(positionsArray[0]);
    Rectangle leftRighterRectangle = new Rectangle(positionsArray[1]);
    Rectangle lowerRectangle = new Rectangle(positionsArray[2]);
    Rectangle lowHigherRectangle = new Rectangle(positionsArray[3]);

    if (Rectangle.crossover(r1, r2)) {
      intersectedRectangle.left = leftRighterRectangle.left;
      intersectedRectangle.bot = lowHigherRectangle.bot;

      if (lefterRectangle.left + lefterRectangle.width < leftRighterRectangle.left + leftRighterRectangle.width)  {
        intersectedRectangle.width = lefterRectangle.left + lefterRectangle.width - leftRighterRectangle.left;
      }
      else  {
        intersectedRectangle.width = leftRighterRectangle.width;
      }

      if (lowerRectangle.bot + lowerRectangle.height < lowHigherRectangle.bot + lowHigherRectangle.height) {
        intersectedRectangle.height = lowerRectangle.bot + lowerRectangle.height - lowHigherRectangle.bot;
      }
      else  {
        intersectedRectangle.height = lowHigherRectangle.height;
      }
    }

    return intersectedRectangle;
  }
  public static int totalPerimeter (Rectangle r1, Rectangle r2) {
    int calcPerimeter = 0;

    if (r1.width == 0 || r1.height == 0 || r2.width == 0 || r2.height == 0) {
      calcPerimeter = r1.perimeter() + r2.perimeter() - intersection(r1, r2).perimeter();
    }
    else  {
      calcPerimeter = r1.perimeter() + r2.perimeter() - intersection(r1, r2).peri();
    }

    return calcPerimeter;
  }

  public static void drawRectangle (Rectangle r)  {
    Rectangle tempR = new Rectangle(r);

    //record left right bot top
    int leftOfGrid = tempR.left - 1;
    int topOfGrid = tempR.bot + tempR.height + 1;

    //slide it to 0, 0
    if (tempR.left < 0 || tempR.left > 0)  {
      tempR.left -= tempR.left;
    }
    if (tempR.bot < 0 || tempR.bot > 0) {
      tempR.bot -= tempR.bot;
    }
    
    int gridWidth = tempR.left + tempR.width + 2;
    int gridHeight = tempR.bot + tempR.height + 2;

    String[][] rectangleGrid = new String[gridWidth][gridHeight];

    for (int i=0;i<gridHeight;i++) {
      for (int j=0;j<gridWidth;j++) {
        rectangleGrid[j][i] = WHITE_BACKGROUND + "  " + ANSI_RESET;
      }
    }

    for (int i=0;i<gridHeight;i++) {
      for (int j=0;j<gridWidth;j++) {
        //filled
        if (j >= tempR.left && j < tempR.left + tempR.width)  {
          if (i >= tempR.bot && i < tempR.bot + tempR.height)  {
            rectangleGrid[j+1][i+1] = RED_BACKGROUND + "  " + ANSI_RESET;
          }
        }
      }
    }

    if (topOfGrid < 0 || topOfGrid >= 10)  {
      System.out.println(ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
      topOfGrid--;
    }
    else  {
      System.out.println(" " + ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
      topOfGrid--;
    }

    for (int i=gridHeight-1;i>=0;i--) {
      if (topOfGrid < 0 || topOfGrid >= 10)  {
        System.out.print(ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
        topOfGrid--;
      }
      else  {
        System.out.print(" " + ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
        topOfGrid--;
      }
      for (int j=0;j<gridWidth;j++) {
        System.out.print(rectangleGrid[j][i]);
        if (j == gridWidth - 1) {
          System.out.println();
        }
      }
    }

    System.out.print("  ");

    for (int i=0;i<=gridWidth;i++) {
      if (leftOfGrid < 0 || leftOfGrid >= 10) {
        System.out.print(leftOfGrid);
        leftOfGrid++;
      }
      else  {
        System.out.print(" " + leftOfGrid);
        leftOfGrid++;
      }
    }

    System.out.println();
  }
  public static void drawIntersectingRectangles (Rectangle r1, Rectangle r2)  {
    Rectangle[] positionsArray = Rectangle.rectanglePositions(r1, r2);

    Rectangle lefterRectangle = new Rectangle(positionsArray[0]);
    Rectangle leftRighterRectangle = new Rectangle(positionsArray[1]);
    Rectangle lowerRectangle = new Rectangle(positionsArray[2]);
    Rectangle lowHigherRectangle = new Rectangle(positionsArray[3]);
    Rectangle righterRectangle = new Rectangle(positionsArray[4]);
    Rectangle rightLefterRectangle = new Rectangle(positionsArray[5]);
    Rectangle higherRectangle = new Rectangle(positionsArray[6]);
    Rectangle highLowerRectangle = new Rectangle(positionsArray[7]);

    //record left right bot top
    int leftOfGrid = lefterRectangle.left - 1;
    int topOfGrid = higherRectangle.bot + higherRectangle.height + 1;

    //slide it to 0, 0
    if (lefterRectangle.left < 0 || lefterRectangle.left > 0)  {
      lowHigherRectangle.left -= lefterRectangle.left;
      lowerRectangle.left -= lefterRectangle.left;
      leftRighterRectangle.left -= lefterRectangle.left;
      righterRectangle.left -= lefterRectangle.left;
      rightLefterRectangle.left -= lefterRectangle.left;
      higherRectangle.left -= lefterRectangle.left;
      highLowerRectangle.left -= lefterRectangle.left;
      lefterRectangle.left -= lefterRectangle.left;
    }
    if (lowerRectangle.bot < 0 || lowerRectangle.bot > 0) {
      leftRighterRectangle.bot -= lowerRectangle.bot;
      lefterRectangle.bot -= lowerRectangle.bot;
      lowHigherRectangle.bot -= lowerRectangle.bot;
      righterRectangle.bot -= lowerRectangle.bot;
      rightLefterRectangle.bot -= lowerRectangle.bot;
      higherRectangle.bot -= lowerRectangle.bot;
      highLowerRectangle.bot -= lowerRectangle.bot;
      lowerRectangle.bot -= lowerRectangle.bot;
    }

    Rectangle intersectedRectangle = Rectangle.intersection(lefterRectangle, leftRighterRectangle);
    
    int gridWidth = righterRectangle.left + righterRectangle.width - lefterRectangle.left + 2;
    int gridHeight = higherRectangle.bot + higherRectangle.height - lowerRectangle.bot + 2;

    String[][] rectangleGrid = new String[gridWidth][gridHeight];

    for (int i=0;i<gridHeight;i++) {
      for (int j=0;j<gridWidth;j++) {
        rectangleGrid[j][i] = WHITE_BACKGROUND + "  " + ANSI_RESET;
      }
    }

    for (int i=0;i<gridHeight;i++) {
      for (int j=0;j<gridWidth;j++) {
        //filled
        if (j >= lefterRectangle.left && j < lefterRectangle.left + lefterRectangle.width)  {
          if (i >= lefterRectangle.bot && i < lefterRectangle.bot + lefterRectangle.height)  {
            rectangleGrid[j+1][i+1] = RED_BACKGROUND + "  " + ANSI_RESET;
          }
        }
        if (j >= leftRighterRectangle.left && j < leftRighterRectangle.left + leftRighterRectangle.width)  {
          if (i >= leftRighterRectangle.bot && i < leftRighterRectangle.bot + leftRighterRectangle.height)  {
            rectangleGrid[j+1][i+1] = BLUE_BACKGROUND + "  " + ANSI_RESET;
          }
        }

        //intersections
        if (Rectangle.crossover(r1, r2))  {
          for (int k=intersectedRectangle.left;k<intersectedRectangle.left + intersectedRectangle.width;k++)  {
            for (int l=intersectedRectangle.bot;l<intersectedRectangle.bot + intersectedRectangle.height;l++) {
              rectangleGrid[k+1][l+1] = PURPLE_BACKGROUND + "  " + ANSI_RESET;
            }
          }
        }
      }
    }

    if (topOfGrid < 0 || topOfGrid >= 10)  {
      System.out.println(ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
      topOfGrid--;
    }
    else  {
      System.out.println(" " + ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
      topOfGrid--;
    }

    for (int i=gridHeight-1;i>=0;i--) {
      if (topOfGrid < 0 || topOfGrid >= 10)  {
        System.out.print(ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
        topOfGrid--;
      }
      else  {
        System.out.print(" " + ANSI_UNDERLINE + topOfGrid + " " + ANSI_NOUNDERLINE);
        topOfGrid--;
      }
      for (int j=0;j<gridWidth;j++) {
        System.out.print(rectangleGrid[j][i]);
        if (j == gridWidth - 1) {
          System.out.println();
        }
      }
    }

    System.out.print("  ");

    for (int i=0;i<=gridWidth;i++) {
      if (leftOfGrid < 0 || leftOfGrid >= 10) {
        System.out.print(leftOfGrid);
        leftOfGrid++;
      }
      else  {
        System.out.print(" " + leftOfGrid);
        leftOfGrid++;
      }
    }

    System.out.println();
  }
}


class Main {
  public static void main(String[] args) {
    Scanner user_input = new Scanner(System.in);

    String drawAgain = "y";

    System.out.println("\nhave you ever felt like giving the coordinates of two rectangles,");
    System.out.println("specifying their width and height, and getting to know their");
    System.out.println("perimeters, intersections, and areas? (y/n)\n");

    String dreams = user_input.nextLine().toLowerCase();

    if (dreams.equals("y") || dreams.equals("yes")) {
      System.out.println("\nmy friend...");
    }
    else if (dreams.equals("n") || dreams.equals("no")) {
      System.out.println("\nno need to be shy!");
    }
    else  {
      System.out.println("\nwow, you're so excited you can't even type right!");
    }
    System.out.println("today your dreams will become reality!\n");

    System.out.println("----------------------------------------------------------------");
    System.out.println("               I PRESENT TO YOU: RECTANGLE DRAWER!              ");
    System.out.println("----------------------------------------------------------------\n");

    System.out.println("in this program, you'll be able to give life to 1/2 rectangles. you");
    System.out.println("just have to give me the positions of the left side/s, bottom side/s,");
    System.out.println("height/s, and width/s, and i'll draw it out for you!\n");

    System.out.println("note: all negative widths and heights will generate a rectangle in the");
    System.out.println("opposite direction, changing the leftmost side of the rectangle.");

    while (drawAgain.equals("y")) {

      Rectangle[] yourRectangles = new Rectangle[2];
      yourRectangles[0] = new Rectangle();
      yourRectangles[1] = new Rectangle();

      int howManyRectangles = 0;

      while (howManyRectangles != 1 && howManyRectangles != 2)  {
        System.out.println("\nhow many rectangles do you want to draw? (1/2)");
        howManyRectangles = user_input.nextInt();
      }

      boolean seemsGood;
      boolean contAsking;
      String seemsGoodAns = "";

      for (int i=0;i<howManyRectangles;i++) {
        seemsGood = false;
        System.out.println("\nfor rectangle " + (i+1) + ":");
        while (seemsGood == false) {
          System.out.println("at which position is its leftmost side?");
          yourRectangles[i].setLeft(user_input.nextInt());

          System.out.println("\nat which position is its bottom side?");
          yourRectangles[i].setBot(user_input.nextInt());

          System.out.println("\nwhat's its width?");
          yourRectangles[i].setWidth(user_input.nextInt());

          System.out.println("\nwhat's its height?");
          yourRectangles[i].setHeight(user_input.nextInt());

          System.out.println("\nso this is what we've got so far for rectangle " + (i+1) + ".");
          System.out.println(yourRectangles[i].toString());
          System.out.println("seems good? (y/n)");
          seemsGoodAns = user_input.nextLine().toLowerCase();

          contAsking = true;

          while (contAsking == true) {
            System.out.println("y to continue, n to reenter fields.");
            seemsGoodAns = user_input.nextLine().toLowerCase();
            if (seemsGoodAns.equals("y"))  {
              seemsGood = true;
              contAsking = false;
            }
            else if (seemsGoodAns.equals("n")) {
              contAsking = false;
            }
          }
        }
      }

      String anythingElse;
      boolean anythingElseAsking = true;

      if (howManyRectangles == 1)  {
        System.out.println("\nhere's your rectangle!\n");

        Rectangle.drawRectangle(yourRectangles[0]);

        System.out.println("\nwhat else do you want to know?");

        while (anythingElseAsking == true)  {
          System.out.println("options: area, perimeter, nothing");
          anythingElse = user_input.nextLine().toLowerCase();
          if (anythingElse.equals("area"))  {
            System.out.println("Rectangle area: " + yourRectangles[0].area());
          }
          else if (anythingElse.equals("perimeter")) {
            System.out.println("Rectangle perimeter: " + yourRectangles[0].perimeter());
          }
          else if (anythingElse.equals("nothing"))  {
            anythingElseAsking = false;
          }
        }
      }

      if (howManyRectangles == 2) {
        System.out.println("\nhere's your rectangles!\n");

        Rectangle.drawIntersectingRectangles(yourRectangles[0], yourRectangles[1]);

        System.out.println("\nwhat else do you want to know?");

        while (anythingElseAsking == true)  {
          System.out.println("options: areas, perimeters, totalarea, totalperimeter,");
          System.out.println("         intersectedarea, intersectedperimeter, nothing");

          anythingElse = user_input.nextLine().toLowerCase();
          if (anythingElse.equals("areas"))  {
            for (int i=0;i<2;i++) {
              System.out.println("Rectangle " + (i + 1) + ": " + yourRectangles[i].area());
            }
          }
          else if (anythingElse.equals("perimeters")) {
            for (int i=0;i<2;i++) {
              System.out.println("Rectangle " + (i + 1) + ": " + yourRectangles[i].perimeter());
            }
          }
          else if (anythingElse.equals("totalarea"))  {
            System.out.println("Total Area: " + (yourRectangles[0].area() + yourRectangles[1].area() - Rectangle.intersection(yourRectangles[0], yourRectangles[1]).area()));
          }
          else if (anythingElse.equals("totalperimeter"))  {
            System.out.println("Total Perimeter: " + Rectangle.totalPerimeter(yourRectangles[0], yourRectangles[1]));
          }
          else if (anythingElse.equals("intersectedarea"))  {
            System.out.println("Intersected Rectangle Area: " + Rectangle.intersection(yourRectangles[0], yourRectangles[1]).area());
          }
          else if (anythingElse.equals("intersectedperimeter"))  {
            System.out.println("Intersected Rectangle Perimeter: " + Rectangle.intersection(yourRectangles[0], yourRectangles[1]).perimeter());
          }
          else if (anythingElse.equals("nothing"))  {
            anythingElseAsking = false;
          }
        }
      }

      System.out.println("want to draw again? (y/n)");
      drawAgain = user_input.nextLine().toLowerCase();

      while (drawAgain.equals("y") != true && drawAgain.equals("n") != true) {
        System.out.println("y for yes, n for no.");
        drawAgain = user_input.nextLine().toLowerCase();
      }
    }
    System.out.println("goodbye!");
  }
}