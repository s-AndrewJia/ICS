import java.util.Scanner;

class Main {
  //feel free to use the following output statements.  They may need some modification to fit expected output.
  
  public static void main(String[] args) {
    //varible # of teams
    int numberOfTeams;
    
    //ask
    Scanner user_input = new Scanner(System.in);
    System.out.println("Enter number of teams: ");
    numberOfTeams = user_input.nextInt();
    
    while (numberOfTeams < 1) {
      System.out.println("Please enter a valid number of teams.");
      numberOfTeams = user_input.nextInt();
    }
    
    //varibles, kept here because they are now remembered more than just the for loop & can be used later(e.g. what are the names of the two teams?)
    String [] teamName = new String[numberOfTeams];
    int [] ranks = new int[3 * numberOfTeams];
    char [] playerClassifications = new char[3 * numberOfTeams];
    int [] teamEqualityClassification = new int[numberOfTeams];
    int [] teamTotal = new int[numberOfTeams];
    char [] teamSkillClassification = new char[numberOfTeams];
    int [] teamBonus = new int[numberOfTeams];
    int [] overallScore = new int[numberOfTeams];
    
    //loop number of times there are teams
    for (int c=0;c<numberOfTeams;c++) {
      teamEqualityClassification[c] = 3;
      teamTotal[c] = 0;
      teamBonus[c] = 20;
      
      //ask & get team name
      System.out.println("Enter team " + (c + 1) + " name:");
      //for some weird reason, it would skip the nextLine() function if the Scanner user_input = new Scanner(System.in); wasn't right above it while in a for loop, unless i preceeded nextLine() with next(). Really weird.
      teamName[c] = user_input.next() + user_input.nextLine();
      
      //ask and get ranks
      System.out.println("Enter team member ranks:");
      for (int i=0;i<3;i++) {
        ranks[i + 3 * c] = user_input.nextInt();
        int counter = 0;
        while (ranks[i + 3 * c] <= 0 || ranks[i + 3 * c] > 20)  {
          System.out.println("Enter valid rank(between 1-20 inclusive): ");
          ranks[i + 3 * c] = user_input.nextInt();
          counter++;
          if (counter == 2) {
            ranks[i + 3 * c] = 0;
            break;
          }
        }
        //get teamTotal
        teamTotal[c] += ranks[i + 3 * c];
      }
      
      //ask and get player classifications
      for (int i=0;i<3;i++) {
        if (ranks[i + 3 * c] > 15)  {
          playerClassifications[i + 3 * c] = 'F';
        }
        else if (ranks[i + 3 * c] > 9)  {
          playerClassifications[i + 3 * c] = 'M';
        }
        else  {
          playerClassifications[i + 3 * c] = 'N';
        }
      }
      System.out.println("Player Classification: " + playerClassifications[0 + 3 * c] + ", " + playerClassifications[1 + 3 * c] + ", " + playerClassifications[2 + 3 * c]);
      
      //get and output team equality classification
      if (playerClassifications[0 + 3 * c] == playerClassifications[1 + 3 * c] || playerClassifications[0 + 3 * c] == playerClassifications[2 + 3 * c] || playerClassifications[1 + 3 * c] == playerClassifications[2 + 3 * c] )  {
        teamEqualityClassification[c] -= 1;
        if (playerClassifications[0 + 3 * c] == playerClassifications[1 + 3 * c] && playerClassifications[1 + 3 * c] == playerClassifications[2 + 3 * c]) {
          teamEqualityClassification[c] -= 1;
        }
      }
      System.out.println("Team Equality Classification: " + teamEqualityClassification[c]);
      
      //get and output team skill classification
      if (teamTotal[c] >= 46)  {
        teamSkillClassification[c] = 'E';
      } 
      else if (teamTotal[c] >= 26) {
        teamSkillClassification[c] = 'A';
      }
      else  {
        teamSkillClassification[c] = 'B';
      }
      System.out.println("Team Skill Classification: " + teamSkillClassification[c]);
      
      //output team total
      System.out.println("Team Total: " + teamTotal[c]);
      
      //get and output team bonus
      if (teamEqualityClassification[c] != 3)  {
        if (teamSkillClassification[c] == 'E') {
          teamBonus[c] = (int)Math.round(((teamEqualityClassification[c] + 2) / 3.0) * Math.sqrt(teamTotal[c]));
        }
        else if (teamSkillClassification[c] == 'A')  {
          teamBonus[c] = (int)Math.round(((teamEqualityClassification[c] + 4) / 3.0) * Math.sqrt(teamTotal[c]));
        }
        else  {
          teamBonus[c] = (int)Math.round(((teamEqualityClassification[c] + 5) / 3.0) * Math.sqrt(teamTotal[c]));
        }
      }
      System.out.println("Team Bonus: " + teamBonus[c]);
      
      //get and output overall score
      overallScore[c] = teamTotal[c] + teamBonus[c];
      System.out.println(teamName[c] + " Overall Score: " + overallScore[c] + "\n");
    }
  }
}