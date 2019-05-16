package collection.crash;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Class represents a crash with bodily injuries.
 */
public class InjuryCrash extends AbstractCrash {

  /**
   * Represents a crash with bodily injuries.
   *
   * @param dateOfCrash - the date of the crash.
   * @param driver - the driver involved in crash.
   */
  public InjuryCrash(LocalDate dateOfCrash, IDriver driver) {
    super(dateOfCrash, driver);
  }
}
