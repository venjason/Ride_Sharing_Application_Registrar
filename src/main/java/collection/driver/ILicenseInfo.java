package collection.driver;

import java.time.LocalDate;

public interface ILicenseInfo {
  /**
   * Get the license number of the License.
   *
   * @return the license number of the License.
   */
  String getLicenseNumber();

  /**
   * Get the licensed driver's first name.
   *
   * @return the licensed driver's first name.
   */
  String getDriverFirstName();

  /**
   * Get the licensed driver's last name.
   *
   * @return the licensed driver's last name.
   */
  String getDriverLastName();

  /**
   * Get the driver's birth date.
   *
   * @return the driver's birth date.
   */
  LocalDate getDriverBirthDate();

  /**
   * Get the country of issue.
   *
   * @return the country of issue.
   */
  Country getIssueCountry();

  /**
   * Get the state of issue.
   *
   * @return the state of issue.
   */
  State getIssueState();

  /**
   * Get the driver's address.
   *
   * @return the driver's address.
   */
  Address getDriverAddress();

  /**
   * Get the issue date of the driver's license.
   *
   * @return the issue date of the driver's license.
   */
  LocalDate getIssueDate();

  /**
   * Get the expiration date of the driver's license.
   *
   * @return the expiration date of the driver's license.
   */
  LocalDate getExpirationDate();
}
