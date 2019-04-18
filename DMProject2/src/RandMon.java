// Daniel Miller

// The genMon (generate Pokemon) method in the RandMon class is called when..
// a string should be returned which alters the user of which Pokemon has
// been encountered

public class RandMon {

  public static String genMon(String s) throws PmonException {

    switch (s) {
      case "Pikachu":
        return "You have encountered a wild Pikachu!";
      case "Oddish":
        return "You have encountered a wild Oddish!";
      case "Gloom":
        return "You have encountered a wild Gloom!";
      case "Doduo":
        return "You have encountered a wild Doduo!";
      case "Natu":
        return "You have encountered a wild Natu!";
      case "Girafarig":
        return "You have encountered a wild Girafarig!";
      case "Wobbuffet":
        return "You have encountered a wild Wobbuffet!";
      default:
        throw new PmonException("There's no Pokemon to be found..?");
    }

  }

}
