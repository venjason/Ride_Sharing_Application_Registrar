package collection.driver;

/**
 * Interface IPerson represents a natural person of the system with the name.
 */
public interface IPerson {
  /**
   * Get the first name.
   *
   * @return the first name
   */
  String getFirstName();

  /**
   * Get the last name.
   *
   * @return the last name
   */
  String getLastName();

  /**
   * Get the full name.
   *
   * @return the full name
   */
  String getName();
}
