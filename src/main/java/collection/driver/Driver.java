package collection.driver;

import collection.violation.IViolation;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Class Driver represents a driver of the system.
 */
public class Driver implements IDriver {

  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private LicenseInfo license;
  private IVehicle vehicle;
  private List<IViolation> violations;
  private IRegistrationValidator appProcessor;

  /**
   * Construct a new Driver object.
   *
   * @param firstName the first name of the driver.
   * @param lastName the last name of the driver.
   * @param birthDate the birth date of the driver.
   * @param license the license info of the driver.
   * @param vehicle the vehicle of the driver.
   * @param violations the violation list of the driver.
   */
  public Driver(
      String firstName,
      String lastName,
      LocalDate birthDate,
      LicenseInfo license,
      IVehicle vehicle,
      List<IViolation> violations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.license = license;
    this.vehicle = vehicle;
    this.violations = violations;
    // This method should not be here since all drivers should share a same validator,
    // Singleton on validator or a static final field in this class could be used. However,
    // for the convenience of testing of this assignment(since we are not expected to
    // use mock testing), we create a new validator as each new driver.
    appProcessor = new RegistrationValidator();
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public String getName() {
    return this.getFirstName() + " " + this.getLastName();
  }

  @Override
  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public LicenseInfo getLicense() {
    return license;
  }

  @Override
  public IVehicle getVehicle() {
    return vehicle;
  }

  @Override
  public List<IViolation> getViolations() {
    return violations;
  }

  @Override
  public Boolean register() {
    return appProcessor.processApplication(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Driver)) {
      return false;
    }
    Driver driver = (Driver) obj;
    return Objects.equals(getFirstName(), driver.getFirstName())
        && Objects.equals(getLastName(), driver.getLastName())
        && Objects.equals(getBirthDate(), driver.getBirthDate())
        && Objects.equals(getLicense(), driver.getLicense())
        && Objects.equals(getVehicle(), driver.getVehicle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getBirthDate(), getLicense(), getVehicle());
  }

  @Override
  public String toString() {
    return "Driver{"
        + "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + ", birthDate=" + birthDate
        + ", license=" + license
        + ", vehicle=" + vehicle
        + ", violations=" + violations
        + '}';
  }
}