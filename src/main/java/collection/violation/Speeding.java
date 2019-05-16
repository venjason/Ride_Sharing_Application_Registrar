package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of speeding.
 */
public class Speeding extends AbstractMovingViolation {

  /**
   * Represents a moving violation of speeding.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public Speeding(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
