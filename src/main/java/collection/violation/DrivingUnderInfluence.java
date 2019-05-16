package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of driving under the influence.
 */
public class DrivingUnderInfluence extends AbstractMovingViolation {

  /**
   * Represents a moving violation of driving under the influence.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public DrivingUnderInfluence(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
