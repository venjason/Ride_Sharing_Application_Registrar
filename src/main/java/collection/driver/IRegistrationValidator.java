package collection.driver;

/**
 * Interface IDriver represents a driver of the system.
 */
public interface IRegistrationValidator {

  /**
   * Process the applications from Drivers.
   *
   * @return the application result: true for success and false otherwise.
   */
  Boolean processApplication(IDriver driver);
}