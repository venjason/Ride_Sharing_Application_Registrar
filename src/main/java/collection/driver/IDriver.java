package collection.driver;

import collection.violation.IViolation;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface IDriver represents a driver of the system.
 */
public interface IDriver extends IPerson {
  /**
   * Get the birth date of the Driver.
   *
   * @return -  the full name string.
   */
  LocalDate getBirthDate();

  /**
   * Get the License Information of the Driver.
   *
   * @return - the License information of the driver
   */
  LicenseInfo getLicense();

  /**
   * Get the vehicle of the Driver.
   *
   * @return - the Vehicle.
   */
  IVehicle getVehicle();

  /**
   * Get the the list of crash history of the Driver.
   *
   * @return - a list of crashes
   */
  List<IViolation> getViolations();

  /**
   * Register to be a driver in the system.
   *
   * @return - the truth value that the application is successful.
   */
  Boolean register();
}