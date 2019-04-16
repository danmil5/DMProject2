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
        throw new PmonException("No Pokemon found!");
    }
  }
}
