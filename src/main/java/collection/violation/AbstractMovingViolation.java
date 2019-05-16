package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Abstract class AbstractMovingViolation encodes common states and behaviors of a moving violation.
 */
public abstract class AbstractMovingViolation extends AbstractViolation {

  /**
   * Represents a violation.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public AbstractMovingViolation(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
