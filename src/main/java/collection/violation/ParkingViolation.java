package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a non-moving violation of a parking violation.
 */
public class ParkingViolation extends AbstractNonMovingViolation {

  /**
   * Represents a non-moving violation of parking violation.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public ParkingViolation(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
