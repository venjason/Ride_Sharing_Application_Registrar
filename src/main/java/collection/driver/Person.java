package collection.driver;

import java.util.Objects;

/**
 * Class Person represents a natural person of the system with the name.
 */
public class Person implements IPerson {

  private String firstName;
  private String lastName;

  /**
   * Construct a new Person object with his/her first name and last name.
   *
   * @param firstName the person's first name.
   * @param lastName the person's last name.
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Person)) {
      return false;
    }
    Person person = (Person) obj;
    return Objects.equals(
        getFirstName(),
        person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }

  @Override
  public String toString() {
    return "Person{"
        + "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + '}';
  }
}
