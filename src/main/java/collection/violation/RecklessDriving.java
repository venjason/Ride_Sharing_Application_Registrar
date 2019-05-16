package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of reckless driving.
 */
public class RecklessDriving extends AbstractMovingViolation {

  /**
   * Represents a moving violation reckless driving.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public RecklessDriving(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
