package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a non-moving violation of a paperwork issues.
 */
public class PaperworkIssues extends AbstractNonMovingViolation {

  /**
   * Represents a non-moving violation of a paperwork issues.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public PaperworkIssues(LocalDate dateOfViolation, IDriver driver) {
    super(dateOfViolation, driver);
  }
}
