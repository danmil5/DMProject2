// Daniel Miller

// Project Idea: Recreate the Safari Zone from Pokemon Emerald/Ruby/Sapphire

// What to accomplish in later stages of this project:
// Ask for user input to determine the direction of step the user takes.
// With each step, use a random-number-generator alongside the original catch..
// rates to determine if a Pokemon will spawn, what Pokemon it will be, and...
// the catch/escape rates of each pokemon throughout each encounter.
// Use a running variable to limit steps to 50. (Actual # 500 in game)
// Limit the number of Safari Balls to 30, and include other functions to...
// alter catch/escape rates - "go near", "throw PokeBlock", and "run".
// Let the user know when the game is over, either when they run out of steps..
// or Safari Balls, and display the names and amount of each Pokemon caught.

// Only Pokemon from Area 1 will be implemented with the original catch rates..
// for now: https://bulbapedia.bulbagarden.net/wiki/Hoenn_Safari_Zone#Area_1_2
// These 7 Pokemon with their original catch rates and encounter rates are:
// Pikachu - Catch Rate 190 - Encounter Rate 5%
// Oddish - Catch Rate 255 - Encounter Rate 40%
// Gloom - Catch Rate 120 - Encounter Rate 5%
// Doduo - Catch Rate 190 - Encounter Rate 10%
// Natu - Catch Rate 190 - Encounter Rate 10%
// Girafarig - Catch Rate 60 - Encounter Rate 20%
// Wobbuffet - Catch Rate 45 - Encounter Rate 10%

// Encounter Rate:
// The encounter rates are calculated after the chance of actually finding...
// a Pokemon with each step, which is originally 5.33%, however due to the...
// decrease in allowed steps, the propotional catch rate for this project...
// will be 35.5% per step..

// Catch Rate:
// The likelihood of catching a Pokemon in the Safari Zone is determined by...
// using a catch factor, which is the catch rate listed above multiplied by...
// 100, then divided by 1275. This number is then rounded down, unless it is..
// less than 1, in which case it is set to 1. This catch factor can change...
// through the user's actions, and when a Safari Ball is thrown, produces a...
// modified catch rate of (Catch_Factor*1275)/100. The probability of the...
// Pokemon being caught should be equal to (Modified_Catch_Rate)/255.

// Escape Rate:
// Using data from the original game, escape rate will be determined by...
// generating a random number from 0-99 at the end of each turn cycle, and...
// the Pokemon will flee if this number is <= 3*Escape_Factor, where the...
// escape factor starts at 3 and can be changed by the user's actions.

// Data Types and Ranges:
// Byte: -128 to 127
// Short: -32,768 to 32,767
// Integer (Int): -2^31 to 2^31 - 1
// Long: -2^63 to 2^63 - 1
// Double: Most Decimal Values
// Boolean: True or False Values
// String: Non-Numerical Values

// A variable is most similar to a box which a value can be put into, or ...
// "assigned to," which allows more convenient expression and usage of the ...
// value contained within the variable.

// The term scope refers to the access that a class has to a variable or set...
// of variables, most notably used when describing the ability of classes to...
// access only private variables declared within that specific class.

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    // Create scanner and random tools
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    
    // IMPORTANT: To change the duration of this program, change the two..
    // variables below; "totalSteps" is used only in print statements, while..
    // "steps" changes the actual amount of steps the user starts off with.
    
    // Initialize running integer variable to be used to track steps left
    int steps = 25;
    // Variable below used to reference starting amount of steps
    int totalSteps = 25;

    // The catch rate variables are not used yet, however they do help to...
    // show an example of casting variables by creating integer-type copies...
    // of double-type values and vice-versa to round down the variables...
    // since all variables regarding catch probability should be rounded down.
    
    // Constants used to track of catch factor and catch probability changes:
    // int chanToFact = 100/1275;
    // int factToChan = 1275/100;
    // int chanToProb = 100/225;
    
    // double pikaCatchChance = 190*chanToFact;
    // int pikaFactor = (int) pikaCatchChance;
    // double pikaFactor2 = (double) pikaFactor;
    // For this example, the catch factor will be increased by 3, which...
    // originally occurs when approaching the Pokemon for the first time.
    // pikaFactor2 = pikaFactor2 + 3;
    // double pikaNewFactor = pikaFactor2*factToChan;
    // int pikaNewCatch = (int) pikaNewFactor;
    // double pikaCatch2 = (double) pikaNewCatch;
    // double pikaCatchProb = pikaCatch2*chanToProb;
    // When a Safari Ball is thrown at this point, the random tool would be...
    // used, and if the random number from 1-100 is less than pikaCatchProb...
    // (which in this case is 84.7%) then the Pikachu will be caught.

    // Variables Used to Determine Which Pokemon is Encountered
    int enco;
    String pmon;
    String newName;

    // Variable to determine if encounter takes place
    boolean battle;
    // Additional encounter-related variables
    int flee = 99;
    int escape;
    int caught;
    
    // Create an array to store Pokemon objects
    ArrayList<Pokemon> pArray= new ArrayList<Pokemon>(0);
    int pAcc = 0;
    
    // Create an arraylist to keep track of pokeballs thrown per pokemon
    ArrayList<Integer> thrownBalls = new ArrayList<Integer>(0);
    
    // Create variables used to keep track of the the total balls thrown
    int balls;
    int ballTrack = 0;
    int totalBalls = 0;
    int wastedBalls = 0;
    
    // Create a variable to satisfy the ternary operator requirement later on
    String only;

    // Strings to be used at the beginning to fulfill PSI requirements

    
    String num;
    int num2 = 5;
    int testAcc;
    
    // call method to print introduction
    printIntro();
    
    scan.nextLine();
    for (testAcc = 1; testAcc <= 5; testAcc++) {
      System.out.println("Please enter an integer less than 9:");
      num = scan.nextLine();
      try {
        num2 = Integer.parseInt(num);
      } catch (NumberFormatException e) {
        if (testAcc < 5)
          System.out.println("Type only integers please!");
        continue;
      }
      if ((num.compareTo("9") < 0) && (num2 < 9)) {
        testAcc = 7;
      } else if (num2 >= 9) {
        System.out.println("Only type numbers less than 9 please!");
      } else {
        System.out.println("Sorry, could you try that again?");
      }
    }

    if (testAcc == 6) {
      System.out.println("I think I've given you enough tries already,"
          + " let's just pretend that you typed the number 5...");
      num2 = 5;
      System.out.println("Press \"\\ENTER\\\" to continue");
      scan.nextLine();
    }
    System.out.println("Just to let you know," + 
        " your number divided by 2 is " + num2 / 2
        + " with " + "a remainder of " + num2 % 2 + 
        ", and your number squared is "
        + Math.pow(num2, 2) + "!");
    System.out.println("");
    // Console output requirement
    System.out.println(
        "Now with that out of the way, I'd like to formally welcome " 
    + "you to the Hoenn Safari Zone!");
    System.out.println("Press \"\\ENTER\\\" to continue");
    scan.nextLine();
    
    // call method to ask for confirmation before starting rest of the program
    confirmStart(totalSteps, scan);

    // Initialize double variable to be used, using the final keyword so that..
    // its value will remain constant throughout the program
    final double ENCRATE = 35.5;
    // Initialize running integer variable to be used
    int encVar;
    // While loop requirement
    while (steps > 0) {
      // Mandatory ternary operator to determine if the word "only" is used
      only = (steps <= 5 ? " only" : "");
      if (steps != totalSteps) {
        System.out.println("");
      }
      if (steps != 1) {
      System.out.println("You" + only + " have " + steps + " steps left!");
      }
      else if (steps == 1) {
        System.out.println("You" + only + " have " + steps + " step left!");
      }
      System.out.println("Press \"\\ENTER\\\" to continue.");
      scan.nextLine();
      System.out.println("You take a few steps forward and...");
      
      // Generate a random number from 1 to 100 and compare it to the base..
      // encounter rate to determine if a Pokemon is encountered.
      encVar = rand.nextInt(100) + 1;
      // line below is used to determine Pokemon level (higher lvl = more rare)
      Pokemon.setEnc(encVar);
      
      // boolean serves as a backup in case the switch statement defaults
      battle = encVar < ENCRATE;
      
      if (battle) {
        // Call the encounterPmon method to determine which Pokemon appears
        enco = rand.nextInt(100);
        
        // Use the randomly-generated "enco" variable as the argument, further
        // explained in the "Encounter" class
        pmon = Encounter.encounterPmon(enco);
        
        
        // Use switch statement to display the encountered Pokemon
        try {
          System.out.println(RandMon.genMon(pmon));
        } catch (PmonException ex) {
          System.out.println("");
          battle = false;
        }
        

        if (battle) {
          // All battle-related code goes here
          System.out.println("");
          escape = 3;
          balls = 0;
          // Do-while loop requirement
          do {
            // "escape" can be changed during the encounter
            System.out.println("Press \"\\ENTER\\\" to throw a Safari ball!");
            scan.nextLine();
            balls++;
            // To keep things fast for now, catch chance will be 50 percent...
            // and the escape chance will rapidly increase each turn cycle.
            System.out.println("You threw a Safari ball and...");
            caught = rand.nextInt(100);
            if (caught >= 50) {
              System.out.println("You caught the wild " + pmon + "!");
              System.out.println("");
              thrownBalls.add(balls);
              ballTrack++;
              // Break statement will exit the loop if Pokemon has been caught
              System.out.println("Give your " + pmon + " a nickname:");
              newName = scan.nextLine();
              if (pmon.equals("Pikachu")) {
                if (newName.length() == 0 || newName.equalsIgnoreCase(pmon)) {
                  pArray.add(new Pikachu(pmon));
                  System.out.println("Your " + pmon + " was sent to storage!");
                }
                else {
                  pArray.add(new Pokemon(newName, pmon));
                  System.out.println(newName + " was sent to storage!");
                }
              } 
              else {
                if (newName.length() == 0) {
                  pArray.add(new Pokemon(pmon));
                  System.out.println("Your " + pmon + " was sent to storage!");
                } 
                else {
                  pArray.add(new Pokemon(newName, pmon));
                  System.out.println(newName + " was sent to storage!");
                }
              }
              pAcc++;
              break;
            }
            else if (caught >= 25 && caught < 50) {
              // If the ball misses, the next loop will be iterated before..
              // the Pokemon has a chance to flee.
              System.out.println("The Safari Ball missed! Try again!");
              System.out.println("");
              continue;
            } 
            else {
              System.out.println("The " + pmon + " broke free!");
              System.out.println("");
              flee = rand.nextInt(100);
              // Fulfills the += operator requirement
              escape += 5;
              if (flee <= 3 * escape) {
                System.out.println("The wild " + pmon + " escaped!");
                wastedBalls+=balls;
              }
            }   
          } while (flee > 3 * escape);
        }
        --steps;
      } else {
        System.out.println("There's no Pokemon to be found...");
        --steps;
      }
      // Afterwards, repeat the method by prompting user to take another step
    }
    System.out.println("");
    System.out.println("Your " + totalSteps + 
        " steps are up! Here's everything you caught:");
    
    if (pArray.size() == 0) {
      System.out.println("You uh.. didn't catch anything..?");
      pAcc = 0;
    }
    
    for (int pNum = 0; pNum < pAcc; pNum++)
      System.out.println(pArray.get(pNum).getName() + " the level " + 
          pArray.get(pNum).getLevel() + " " + pArray.get(pNum).getSpecies() +
      " ( " + thrownBalls.get(pNum) + 
      (thrownBalls.get(pNum) == 1 ? " ball" : " balls") + " used )");
    
    System.out.println("");
    
    // Array accumulator requirement
    for (int bNum = 0; bNum < ballTrack; bNum++) {
      totalBalls += thrownBalls.get(bNum);
    }
    totalBalls += wastedBalls;
    
    System.out.println("Extra Stats:");
    System.out.println("");
    System.out.println("Total Balls Thrown and Wasted:");
    

    System.out.println("You threw a total of " + totalBalls + " Safari "
      + "balls, and " + wastedBalls + " went to waste.");
    
    
    // use a two-dimensional array requirement(s)
    String[][] oddBalls = new String[pAcc][2];
    for (int p1 = 0; p1 < pAcc; p1++) {
      oddBalls[p1][0] = pArray.get(p1).getSpecies();
      oddBalls[p1][1] = Integer.toString(thrownBalls.get(p1));
    }
    
    System.out.println("");
    System.out.println("List of Oddishes Caught:");
    
    // call method to print number of oddishes caught
    numOddishes(pAcc, oddBalls);
 
    System.out.println("");
    int leastB = 0;
    leastB = Integer.parseInt(oddBalls[0][1]);
    
    String[][] tiedLeast = new String[pAcc][2];
    int tie = 0;
    String leastNum;
    
    // For loop finds the lowest number of balls used to catch pokemon
    for (int cNum = 0; cNum < pAcc; cNum++) {
      if (Integer.parseInt(oddBalls[cNum][1]) < leastB) {
        leastB = cNum;
      }
    }
    
    // Sort each pokemon caught using the least number of balls
    for (int cNum = 0; cNum < pAcc; cNum++) {
      if (Integer.parseInt(oddBalls[cNum][1]) == leastB) {
        switch (cNum) {
          case 0:
            leastNum = "1st";
            break;
          case 1:
            leastNum = "2nd";
            break;
          case 2:
            leastNum = "3rd";
            break;
          default:
            leastNum = (cNum + 1) + "th";
        }
        if (oddBalls[cNum][0] == "Mouse Pokemon") {
          tiedLeast[tie][0] = "Pikachu";
        }
        else if (oddBalls[cNum][0] != "Mouse Pokemon") {
        tiedLeast[tie][0] = oddBalls[cNum][0];
        }
        tiedLeast[tie++][1] = leastNum;
      }
    }
    
    String lb = (leastB == 1 ? "ball" : "balls");
   
    
    System.out.println("Least Amount of Safari Balls Used to Catch Pokemon:");

    printLeastBalls(leastB, lb, tie, tiedLeast);

    System.out.println("");
    System.out.println("Scroll up for more stats, and thanks for playing!");

    // Close the scanner
    scan.close();
  }
  
  // Methods
  
  // method prints intro text
  private static void printIntro() {
    System.out.println("Welcome to the Hoenn Safari Zone! Let's use a quick "
        + "test to make sure everything works properly before starting.");
    System.out.println("Press \"\\ENTER\\\" to continue");
  }
  
  private static void confirmStart(int totalSteps, Scanner scan) {
    int loopTest = 0;
    char startChar;
    String confirm;
    String confChar;
    String start = "";
    String startLower;
    
    while (loopTest < 5) {
      System.out.println("You'll have " + totalSteps + 
          " steps, ready to begin? (y/n)");
      // Check to see if user input begins with "y" using the "==" operator...
      // which determines if both sides of the expression equal 'y'.
      try {
        start = scan.nextLine();
        startLower = start.toLowerCase();
        startChar = startLower.charAt(0);
      } catch (StringIndexOutOfBoundsException ex) {
        loopTest++;
        if (loopTest != 5) {
          System.out.println("Sorry, could you try that again?");
        }
        if (loopTest >= 5) {
          System.out.println("You've had enough tries, let's start already!");
          System.out.println("Press \"\\ENTER\\\" to continue");
          scan.nextLine();
        }
        continue;
      }
      
      if (startChar == 'y') {
        System.out.println("Great, let's start!");
        System.out.println("Press \"\\ENTER\\\" to continue");
        scan.nextLine();
        loopTest = 5;
      } else if (startChar == 'n') {
        System.out.println("Are you sure? (y/n)");
        // Again, check to see if user input begins with "y"
        confirm = scan.nextLine();
        confChar = confirm.toLowerCase();
        // Equals method requirement
        if (confChar.equals("y")) {
          System.out.println("Well that's too bad, let's begin!");
          System.out.println("Press \"\\ENTER\\\" to continue");
          scan.nextLine();
          loopTest = 5;
        } else if (confChar.charAt(0) == 'n') {
          System.out.println("Alrighty then, I'll ask again!");
        } else {
          System.out.println("I didn't quite catch that, so I'll ask again!");
        }
      } else {
        System.out.println("I didn't quite catch that, so I'll ask again!");
      }
    }
  }
  
  private static void numOddishes(int pAcc, String oddBalls[][]) {
    String oddPos;
    int oddCount = 0;
    // For loop finds and lists how many Oddishes were caught
    for (int pNum = 0; pNum < pAcc; pNum++) {
      for (int oNum = 0; oNum < oddBalls[pNum].length; oNum++) {
        if (oddBalls[pNum][0] == "Oddish") {
          switch (pNum) {
            case 0:
              oddPos = "1st";
              break;
            case 1:
              oddPos = "2nd";
              break;
            case 2:
              oddPos = "3rd";
              break;
            default:
              oddPos = (pNum + 1) + "th";
          }
          try {
            System.out.println("Your " + oddPos + " caught Pokemon was an "
                + "Oddish, and it took you "
                  + Integer.parseInt(oddBalls[pNum][oNum]) + 
            (Integer.parseInt(oddBalls[pNum][oNum]) == 1 ? " ball" : " balls")
                    + " to catch!");
            oddCount++;
            } catch (NumberFormatException en) {
              continue;
            } 
        }
      }
    }
    if (oddCount == 0) {
      System.out.println("No Oddishes caught!");
    }
  }
  
  // method to print least amount of balls used 
  private static void printLeastBalls(int leastB, String lb, int tie, 
      String[][] tiedLeast) {
    if (tie == 1) {
      System.out.println("Your " + tiedLeast[0][1] + "-caught Pokemon (" 
    + tiedLeast[0][0]
          + ") took only " + leastB + " " + lb + " to catch!");
    } else if (tie == 2) {
      System.out.println("Your " + tiedLeast[0][1] + "-caught Pokemon (" 
    + tiedLeast[0][0]
          + ") and your " + tiedLeast[1][1] + "-caught Pokemon (" + 
    tiedLeast[1][0]
          + ") took only " + leastB + " " + lb + " to catch!");
    } else if (tie > 2) {
      System.out.print("Your " + tiedLeast[0][1] + "-caught Pokemon (" + 
    tiedLeast[0][0] + "),");
      for (int fNum = 1; fNum < tie - 1; fNum++) {
        System.out.print(
            " your " + tiedLeast[fNum][1] + "-caught Pokemon (" + 
        tiedLeast[fNum][0] + "),");
      }
      System.out.println(" and your " + tiedLeast[tie - 1][1] + 
          "-caught Pokemon ("
          + tiedLeast[tie - 1][0] + ") all took only " + leastB + " " 
          + lb + " to catch!");
    }
    
  }

 
}
