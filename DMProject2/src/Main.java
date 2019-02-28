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

public class Main {

  public static void main(String[] args) {
    // Create scanner and random tools
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    // The catch rate variables are not used yet, however they do help to...
    // show an example of casting variables by creating integer-type copies...
    // of double-type values and vice-versa to round down the variables...
    // since all variables regarding catch probability should be rounded down.
    double pikaCatchChance = (190 * 100) / 1275;
    int pikaFactor = (int) pikaCatchChance;
    double pikaFactor2 = (double) pikaFactor;
    // For this example, the catch factor will be increased by 3, which...
    // originally occurs when approaching the Pokemon for the first time.
    pikaFactor2 = pikaFactor2 + 3;
    double pikaNewFactor = (pikaFactor2 * 1275) / 100;
    int pikaNewCatch = (int) pikaNewFactor;
    double pikaCatch2 = (double) pikaNewCatch;
    double pikaCatchProb = (pikaCatch2 / 255) * 100;
    // When a Safari Ball is thrown at this point, the random tool would be...
    // used, and if the random number from 1-100 is less than pikaCatchProb...
    // (which in this case is 84.7%) then the Pikachu will be caught.

    // Variables Used to Determine Which Pokemon is Encountered
    int enco;
    String pmon;

    // Variable to determine if encounter takes place and boolean requirement
    boolean battle;
    // Additional encounter-related variables
    int flee = 99;
    int escape;
    int caught;

    // Create a variable to satisfy the ternary operator requirement later on
    String only;

    // Strings to be used at the beginning just for show
    String start;
    String startChar;
    String confirm;
    String confChar;
    String num;
    int num2 = 5;
    int k;
    // For loop requirement
    for (k = 1; k <= 5; k++) {
      System.out.println("Please type an integer less than 9!");
      num = scan.nextLine();
      System.out.println(num.compareTo("9"));
      try {
        num2 = Integer.parseInt(num);
      } catch (NumberFormatException e) {
        if (k < 5)
          System.out.println("Please type only numbers!");
        continue;
      }
      if ((num.compareTo("9") < 0) && (num2 < 9)) {
        k = 7;
      } else if (num2 >= 9) {
        System.out.println("Please type only numbers less than 9!");
      } else {
        System.out.println("Sorry, could you try that again?");
      }
    }

    if (k == 6) {
      System.out.println("I think I've given you enough tries already..."
          + " let's just pretend that you typed the number 5!");
      num2 = 5;
    }
    System.out.println("Just to let you know," + " your number divided by 2 is " + num2 / 2
        + " with " + "a remainder of " + num2 % 2 + ", and your number squared " + " is "
        + Math.pow(num2, 2) + "!");

    // Console output requirement
    System.out.println(
        "Now with all that out of the way, I'd like to welcome " + "you to the Hoenn Safari Zone!");
    int n = 0;
    while (n == 0) {
      System.out.println("You'll have 50 steps, ready to begin? (y/n)");
      // Check to see if user input begins with "y" using the "==" operator...
      // which determines if both sides of the expression equal 'y'.
      start = scan.nextLine();
      startChar = start.toLowerCase();
      if (startChar.charAt(0) == 'y') {
        System.out.println("Great, let's begin!");
        n = 1;
      } else if (startChar.charAt(0) == 'n') {
        System.out.println("Are you sure? (y/n)");
        // Again, check to see if user input begins with "y"
        confirm = scan.nextLine();
        confChar = confirm.toLowerCase();
        // Equals method requirement
        if (confChar.equals("y")) {
          System.out.println("Well that's too bad, let's begin!");
          n = 1;
        } else if (confChar.charAt(0) == 'n') {
          System.out.println("Alrighty then, I'll ask again!");
        } else {
          System.out.println("I didn't quite catch that, so I'll ask again!");
        }
      } else {
        System.out.println("I didn't quite catch that, so I'll ask again!");
      }
    }

    // Initialize double variable to be used, using the final keyword so that..
    // its value will remain constant throughout the program
    final double encRate = 35.5;
    // Initialize running integer variable to be used
    int encVar;
    // Initialize running integer variable to be used
    int steps = 50;
    // While loop requirement
    while (steps > 0) {
      // Mandatory ternary operator to determine if the word "only" is used
      only = (steps <= 10 ? " only" : "");

      System.out.println("");
      System.out.println("You" + only + " have " + steps + " steps left!");
      System.out.println("Press \"\\ENTER\\\" to continue.");
      scan.nextLine();
      try {
        System.out.println("You take a few steps forward...");
        Thread.sleep(1000);
        System.out.println("You hear rustling in the bushes beside you...");
        Thread.sleep(1500);
        System.out.println("And...");
        Thread.sleep(500);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
      // Generate a random number from 1 to 100 and compare it to the base..
      // encounter rate to determine if a Pokemon is encountered.
      encVar = rand.nextInt(100) + 1;

      // This was where the boolean variable I used in the example was...
      // located, however it was much easier to do without it.

      if (encVar < encRate) {
        // Call the Enc method to determine which pokemon appears
        enco = rand.nextInt(100);
        pmon = Encounter.Enc(enco);
        battle = true;

        // Use switch statement to display the encountered pokemon
        switch (pmon) {
          case "Pikachu":
            System.out.println("You have encountered a wild Pikachu!");
            break;
          case "Oddish":
            System.out.println("You have encountered a wild Oddish!");
            break;
          case "Gloom":
            System.out.println("You have encountered a wild Gloom!");
            break;
          case "Doduo":
            System.out.println("You have encountered a wild Doduo!");
            break;
          case "Natu":
            System.out.println("You have encountered a wild Natu!");
            break;
          case "Girafarig":
            System.out.println("You have encountered a wild Girafarig!");
            break;
          case "Wobbuffet":
            System.out.println("You have encountered a wild Wobbuffet!");
            break;
          default:
            battle = false;
            System.out.println("You have encountered.. nothing?");
            break;
        }

        if (battle = true) {
          // All battle-related code goes here
          System.out.println("");
          escape = 3;
          // Do-while loop requirement
          do {
            // "escape" can be changed during the encounter
            System.out.println("Press \"\\ENTER\\\" to throw a Safari ball!");
            scan.nextLine();
            // To keep things fast for now, catch chance will be 50 percent...
            // and the escape chance will rapidly increase each turn cycle.
            System.out.println("You threw a Safari ball and...");
            caught = rand.nextInt(100);
            if (caught >= 50) {
              System.out.println("You caught the wild " + pmon + "!");
              // Break statement will exit the loop if pokemon has been caught
              break;
            } else if (caught >= 25 && caught < 50) {
              // If the ball misses, the next loop will be iterated before..
              // the pokemon has a chance to flee.
              System.out.println("The Safari Ball missed! Try again!");
              continue;
            } else {
              System.out.println("The " + pmon + " broke free!");
            }

            flee = rand.nextInt(100);
            // Fulfills the += operator requirement
            escape += 5;
            if (flee <= 3 * escape) {
              System.out.println("The wild " + pmon + " escaped!");
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
    System.out.println("Your 50 steps are up! Thanks for playing!");
    // This would be the part where the program tells the user what Pokemon...
    // they've caught and how many of each Pokemon they've caught.
    // Close the scanner
    scan.close();
  }
}
