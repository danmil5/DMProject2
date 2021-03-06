// Daniel Miller

// Pikachu - Catch Rate 190 - Encounter Rate 5%
// Oddish - Catch Rate 255 - Encounter Rate 40%
// Gloom - Catch Rate 120 - Encounter Rate 5%
// Doduo - Catch Rate 190 - Encounter Rate 10%
// Natu - Catch Rate 190 - Encounter Rate 10%
// Girafarig - Catch Rate 60 - Encounter Rate 20%
// Wobbuffet - Catch Rate 45 - Encounter Rate 10%

// Catch rates of Pikachu and Oddish have been altered to more consistently..
// display the polymorphism features of the Pikachu class

// The header determines the name of the method "Enc", and determines which...
// type of variable will be returned, which in this case is a string.

// As stated in the Main class, the "enco" variable is passed as an argument
// to fulfill the single parameter, which will be used to determine which
// Pokemon will be encountered, the String value of which will be returned to
// the Main class.
public class Encounter {
  
  /**
   * Determines which Pokemon is encountered and its level.
   * @author Daniel Miller
   * @param enco The value used to determine the rarity of Pokemon encountered
   * @return The name of the Pokemon encountered
   */
  public static String encounterPmon(int enco) {
    String pmon = "";
    // All statements below fulfill conditional operator requirements

    // Due to operator precedence, the relational operators >= and <= are..
    // evaluated before the conditional operator &&.
    if (enco >= 0 && enco <= 9) {
      pmon = "Pikachu";
    } else if (enco >= 10 && enco <= 44) {
      pmon = "Oddish";
    } else if (enco >= 45 && enco <= 49) {
      pmon = "Gloom";
    } else if (enco >= 50 && enco <= 59) {
      pmon = "Doduo";
    } else if (enco >= 60 && enco <= 69) {
      pmon = "Natu";
    } else if (enco >= 70 && enco <= 89) {
      pmon = "Girafarig";
    } else if (enco >= 90 && enco <= 99) {
      pmon = "Wobbuffet";
    } else {
      pmon = "Pikachu";
    }
    return pmon;
  }
}
