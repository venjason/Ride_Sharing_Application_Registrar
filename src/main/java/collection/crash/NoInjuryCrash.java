package collection.crash;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a crash without bodily injuries.
 */
public class NoInjuryCrash extends AbstractCrash {

  /**
   * Represents a crash without bodily injuries.
   *
   * @param dateOfCrash - the date of the crash.
   * @param driver - the driver involved in crash.
   */
  public NoInjuryCrash(LocalDate dateOfCrash, IDriver driver) {
    super(dateOfCrash, driver);
  }
}
