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
    double pikaCatchChance = (190*100)/1275;
    int pikaFactor = (int)pikaCatchChance;
    double pikaFactor2 = (double)pikaFactor;
    // For this example, the catch factor will be increased by 3, which...
    // originally occurs when approaching the Pokemon for the first time.
    pikaFactor2 = pikaFactor2 + 3;
    double pikaNewFactor = (pikaFactor2*1275)/100;
    int pikaNewCatch = (int)pikaNewFactor;
    double pikaCatch2 = (double)pikaNewCatch;
    double pikaCatchProb = (pikaCatch2/255)*100;
    // When a Safari Ball is thrown at this point, the random tool would be...
    // used, and if the random number from 1-100 is less than pikaCatchProb...
    // (which in this case is 84.7%) then the Pikachu will be caught.
    
  
    // Console output requirement
    System.out.println("Welcome to the Hoenn Safari Zone!");
    int n = 0;
    while (n == 0) {
      System.out.println("Ready to begin? (y/n)");
      // Check to see if user input begins with "y"
      String start = scan.nextLine();
      String startChar = start.toLowerCase();
      if (startChar.charAt(0) == 'y') {
        System.out.println("Great, let's begin!");
        n = 1;
      }
      else {
        System.out.println("Are you sure? (y/n)");
        // Again, check to see if user input begins with "y"
        String confirm = scan.nextLine();
        String confChar = confirm.toLowerCase();
        if (confChar.charAt(0) == 'y') {
          System.out.println("Well that's too bad, let's begin!");
          n = 1;
        }
        else {
          System.out.println("Alrighty then, I'll ask again.");
        }   
      }
    }
    
    // Initialize double variable to be used, using the final keyword so that..
    // its value will remain constant throughout the program
    final double encRate = 35.5;
    // Initialize integer variable to be used
    int encVar;
    // Initialize integer variable to be used
    int steps = 50;
    // Initialize boolean variable to be used
    while (steps > 0) {
      System.out.println("You have " + steps + " steps left!");
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
        System.out.println("You have encountered a Pokemon!");
        // Use rng to determine what Pokemon was encountered and to determine..
        // both its flee and capture rates.
        --steps;
      }
      else { 
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