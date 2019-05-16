package collection.crash;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a fender bender crash.
 */
public class FenderBenderCrash extends AbstractCrash {

  /**
   * Represents a fender bender crash.
   *
   * @param dateOfCrash - the date of the crash.
   * @param driver - the driver involved in crash.
   */
  public FenderBenderCrash(LocalDate dateOfCrash, IDriver driver) {
    super(dateOfCrash, driver);
  }
}
