package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of failing to respect traffic signs.
 */
public class FailureToRespectTrafficSigns extends AbstractMovingViolation {

  /**
   * Represents a moving violation of failing to respect traffic signs.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public FailureToRespectTrafficSigns(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
