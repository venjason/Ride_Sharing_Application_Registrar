package collection.driver;

import java.util.Objects;

/**
 * Class Name represents a name.
 */
public class Name {

  private String first;
  private String last;

  /**
   * Creates a name given first and last name.
   *
   * @param first the first name.
   * @param last the last name.
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Returns true if this name and the given object are equals. Returns false if they are not.
   *
   * @param obj the object to compare this name to.
   * @return true if the objects are equals, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(first, name.first)
        && Objects.equals(last, name.last);
  }

  /**
   * Returns the hashcode for this name.
   *
   * @return the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  /**
   * Returns the string representation of this name.
   *
   * @return the string representation.
   */
  @Override
  public String toString() {
    return this.first + " " + this.last;
  }

  /**
   * Gets the first name.
   *
   * @return the first name
   */
  public String getFirst() {
    return this.first;
  }

  /**
   * Gets the last name.
   *
   * @return the last name.
   */
  public String getLast() {
    return this.last;
  }
}
