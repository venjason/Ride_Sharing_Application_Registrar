package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Abstract class encodes common states and behaviors of a non-moving violation.
 */
public abstract class AbstractNonMovingViolation extends AbstractViolation {

  /**
   * Represents a violation.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public AbstractNonMovingViolation(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
