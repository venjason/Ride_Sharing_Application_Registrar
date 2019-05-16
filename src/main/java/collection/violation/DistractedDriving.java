package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of distracted driving.
 */
public class DistractedDriving extends AbstractMovingViolation {

  /**
   * Represents a moving violation of distracted driving.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public DistractedDriving(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
