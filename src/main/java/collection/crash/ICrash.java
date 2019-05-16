package collection.crash;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Interface ICrash represents public behavior of a violation.
 */
public interface ICrash extends Comparable<ICrash> {

  /**
   * Method returns the date of the crash incident.
   *
   * @return - the date of crash.
   */
  LocalDate getDate();

  /**
   * Getter method returns the driver responsible for crash.
   *
   * @return - the driver who caused the crash.
   */
  IDriver getDriver();

  /**
   * Method compares a the crash date and the current date.
   *
   * @return if more than six months long, returns true, otherwise returns false.
   */
  boolean isAfterSixMonths();
}
