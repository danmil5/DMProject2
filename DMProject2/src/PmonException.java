// Daniel Miller

// The custom exception PmonException is thrown in the RandMon class in the..
// event that a Pokemon was "encountered," however the name of the Pokemon..
// given to the RandMon class was not recognized by the genMon method

@SuppressWarnings("serial")
public class PmonException extends Exception {
  public PmonException(String errorMessage) {
    super(errorMessage);
  }
}
