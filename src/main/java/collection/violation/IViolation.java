package collection.violation;

import collection.driver.IDriver;

import java.time.LocalDate;

/**
 * Interface IViolation represents public behavior of a violation.
 */
public interface IViolation extends Comparable<IViolation> {

  /**
   * Getter method returns the date of the violation.
   *
   * @return - the date of violation.
   */
  LocalDate getDate();

  /**
   * Getter method returns the driver responsible for violation.
   *
   * @return - the driver who caused the violation.
   */
  IDriver getDriver();

  /**
   * Method compares a the violation date and the current date.
   *
   * @return if more than six months long, returns true, otherwise returns false.
   */
  boolean isAfterSixMonths();
}
