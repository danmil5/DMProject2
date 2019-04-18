// Daniel Miller

// The Pikachu class displays the use of inheritance and polymorphism

// In the event that the user catches a Pikachu WITHOUT giving it a nickname,
// a Pikachu object will be creating instead of a Pokemon object, which causes
// any reference to its species to return "Mouse Pokemon" instead of "Pikachu"

public class Pikachu extends Pokemon {
  
  public Pikachu(String nick) {
    super(nick, "Pikachu");
  }

  @Override
  public String getSpecies() {
    return "Mouse Pokemon";
  }
}
