package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract class AbstractViolation encodes common states and behaviors among violations.
 */
public abstract class AbstractViolation implements IViolation {

  protected LocalDate dateOfViolation;
  protected IDriver driver;

  /**
   * Represents a violation.
   *
   * @param dateOfViolation - the date of the violation.
   * @param driver - the driver responsible for violation.
   */
  public AbstractViolation(LocalDate dateOfViolation, IDriver driver) {
    this.dateOfViolation = dateOfViolation;
    this.driver = driver;
  }

  @Override
  public LocalDate getDate() {
    return this.dateOfViolation;
  }

  @Override
  public IDriver getDriver() {
    return this.driver;
  }

  @Override
  public boolean isAfterSixMonths() {
    LocalDate todayDate = LocalDate.now();
    // Get today's date minus six months.
    LocalDate sixMonthsPrevious = todayDate.minusMonths(6);
    return (this.dateOfViolation.isBefore(sixMonthsPrevious));
  }


  @Override
  public boolean equals(Object violation) {
    if (this == violation) {
      return true;
    }
    if (!(violation instanceof AbstractViolation)) {
      return false;
    }
    AbstractViolation that = (AbstractViolation) violation;
    return Objects.equals(dateOfViolation, that.dateOfViolation)
        && Objects.equals(getDriver(), that.getDriver());
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfViolation, getDriver());
  }

  @Override
  public String toString() {
    return ("Driver involved in violation: " + this.getDriver().getName()
        + ". Date of violation: " + this.getDate().getMonthValue() + "/"
        + this.getDate().getDayOfMonth() + "/" + this.getDate().getYear() + ".");
  }

  @Override
  public int compareTo(IViolation otherViolation) {
    final int Equal = 0;
    final int After = 1;
    final int Before = -1;

    if (this.getDate().isBefore(otherViolation.getDate())) {
      return Before;
    }
    if (this.getDate().isAfter(otherViolation.getDate())) {
      return After;
    } else {
      return Equal;
    }
  }
}

