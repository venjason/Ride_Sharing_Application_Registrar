package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a moving violation of driving without valid license or insurance.
 */
public class DrivingWithoutLicenseOrInsurance extends AbstractMovingViolation {

  /**
   * Represents a moving violation of driving without valid license or insurance.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public DrivingWithoutLicenseOrInsurance(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
