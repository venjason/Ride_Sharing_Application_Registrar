package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a non-moving violation of issues with vehicle.
 */
public class ProblemsWithVehicle extends AbstractNonMovingViolation {

  /**
   * Represents a  non-moving violation of issues with vehicle..
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public ProblemsWithVehicle(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
