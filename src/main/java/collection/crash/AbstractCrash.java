package collection.crash;

import collection.driver.IDriver;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract class AbstractCrash encodes common states and behaviors among violations.
 */
public abstract class AbstractCrash implements ICrash {

  private LocalDate dateOfCrash;
  private IDriver driver;

  /**
   * Represents a crash.
   *
   * @param dateOfCrash - the date of the crash.
   * @param driver - the driver involved in crash.
   */
  public AbstractCrash(LocalDate dateOfCrash, IDriver driver) {
    this.dateOfCrash = dateOfCrash;
    this.driver = driver;
  }

  @Override
  public LocalDate getDate() {
    return this.dateOfCrash;
  }

  @Override
  public IDriver getDriver() {
    return driver;
  }

  @Override
  public boolean isAfterSixMonths() {
    LocalDate todayDate = LocalDate.now();
    // Get today's date minus six months.
    LocalDate sixMonthsPrevious = todayDate.minusMonths(6);
    return (this.dateOfCrash.isBefore(sixMonthsPrevious));
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfCrash, getDriver());
  }

  @Override
  public boolean equals(Object crash) {
    if (this == crash) {
      return true;
    }
    if (!(crash instanceof AbstractCrash)) {
      return false;
    }
    AbstractCrash that = (AbstractCrash) crash;
    return Objects.equals(dateOfCrash, that.dateOfCrash)
        && Objects.equals(getDriver(), that.getDriver());
  }

  @Override
  public String toString() {
    return ("Driver involved in crash: " + this.driver.getName()
        + ". Date of accident: " + this.getDate().getMonthValue() + "/"
        + this.getDate().getDayOfMonth() + "/" + this.getDate().getYear() + ".");
  }

  @Override
  public int compareTo(ICrash otherCrash) {
    final int Before = -1;
    final int Equal = 0;
    final int After = 1;

    if (this.getDate().isEqual(otherCrash.getDate())) {
      return Equal;
    }
    if (this.getDate().isBefore(otherCrash.getDate())) {
      return Before;
    } else {
      return After;
    }
  }
}
