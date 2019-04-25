// Daniel Miller

public class Pokemon {
  protected String nickname;
  protected String species;
  protected int level;
  protected static int enc;

  // This constructor is used in the event of an error when creating an..
  // instance of the Pokemon class without any arguments which shouldn't occur
  public Pokemon() {
    this("MissingNo.", "Pokemon");
  }

  // This constructor is used if the user does not enter a nickname
  public Pokemon(String spec) {
    this(spec, spec);
  }

  /**
   * Creates a new Pokemon object to be stored in an array.
   * @author Daniel Miller
   * @param nickname The nickname given to a Pokemon upon capture
   * @param species The species of the Pokemon captured
   */
  public Pokemon(String nickname, String species) {
    this.nickname = nickname;
    this.species = species;
    // generate level based on species of pokemon and encounter rarity
    // Enc is used because higher level pokemon should be more rare
    switch (species) {
      case "Pikachu":
        level = (enc <= 15 ? 27 : 25);
        break;
      case "Oddish":
        level = (enc <= 15 ? 27 : 25);
        break;
      case "Gloom":
        level = 25;
        break;
      case "Doduo":
        level = 25;
        break;
      case "Natu":
        level = 25;
        break;
      case "Girafarig":
        level = (enc <= 15 ? 27 : 25);
        break;
      case "Wobbuffet":
        level = (enc <= 15 ? 29 : 27);
        break;
      default:
    }
  }

  // Get and set methods are listed below
  public int getLevel() {
    return level;
  }

  // Overload requirement in the event that the encounter variable is a double
  public static void setEnc(int num) {
    enc = num;
  }
  
  public static void setEnc(double num) {
    enc = (int)num;
  }

  public String getName() {
    return nickname;
  }

  public void setName(String name) {
    this.nickname = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }
  

}
