package collection.driver;

import java.util.Objects;

/**
 * Class Make represents a vehicle's make (brand) with its String representation.
 */
public class Make {

  private String makeString;

  /**
   * Creates a new Model instance given the String representation.
   *
   * @param makeString the plate's number.
   */
  public Make(String makeString) {
    this.makeString = makeString;
  }

  /**
   * Get the make as a string.
   *
   * @return get the String representation of a vehicle's make(brand)
   */
  public String getMake() {
    return this.makeString;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Make)) {
      return false;
    }
    Make make1 = (Make) obj;
    return Objects.equals(getMake(), make1.getMake());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMake());
  }

  @Override
  public String toString() {
    return "Make{" + "make='" + makeString + '\'' + '}';
  }
}
