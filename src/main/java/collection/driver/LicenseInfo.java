package collection.driver;

import java.time.LocalDate;
import java.util.Objects;

/**
 * LicenseInfo represents a driving license with its information: license unique number, a driver’s
 * name, a driver’s address, a driver’s birth date, country and state of issuance, and issuance and
 * expiration date.
 */
public class LicenseInfo implements ILicenseInfo {

  private String licenseNumber;
  private String driverFirstName;
  private String driverLastName;
  private LocalDate driverBirthDate;
  private Country issueCountry;
  private State issueState;
  private Address driverAddress;
  private LocalDate issueDate;
  private LocalDate expirationDate;

  /**
   * Construct a new LicenseInfo object.
   *
   * @param licenseNumber the string representation of the driver's license number.
   * @param driverFirstName the string representation of the driver's first name.
   * @param driverLastName the string representation of the driver's last name.
   * @param driverBirthDate the driver's birth date.
   * @param issueCountry the license's country of issue.
   * @param issueState the license's country of issue.
   * @param driverAddress the driver's address.
   * @param issueDate the driver's address.
   * @param expirationDate the driver's address.
   */
  public LicenseInfo(
      String licenseNumber,
      String driverFirstName,
      String driverLastName,
      LocalDate driverBirthDate,
      Country issueCountry,
      State issueState,
      Address driverAddress,
      LocalDate issueDate,
      LocalDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.driverFirstName = driverFirstName;
    this.driverLastName = driverLastName;
    this.driverBirthDate = driverBirthDate;
    this.issueCountry = issueCountry;
    this.issueState = issueState;
    this.driverAddress = driverAddress;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
  }

  @Override
  public String getLicenseNumber() {
    return licenseNumber;
  }

  @Override
  public String getDriverFirstName() {
    return driverFirstName;
  }

  @Override
  public String getDriverLastName() {
    return driverLastName;
  }

  @Override
  public LocalDate getDriverBirthDate() {
    return driverBirthDate;
  }

  @Override
  public Country getIssueCountry() {
    return issueCountry;
  }

  @Override
  public State getIssueState() {
    return issueState;
  }

  @Override
  public Address getDriverAddress() {
    return driverAddress;
  }

  @Override
  public LocalDate getIssueDate() {
    return issueDate;
  }

  @Override
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof LicenseInfo)) {
      return false;
    }
    LicenseInfo that = (LicenseInfo) obj;
    return Objects.equals(getLicenseNumber(), that.getLicenseNumber())
        && Objects.equals(getDriverFirstName(), that.getDriverFirstName())
        && Objects.equals(getDriverLastName(), that.getDriverLastName())
        && Objects.equals(getDriverBirthDate(), that.getDriverBirthDate())
        && getIssueCountry() == that.getIssueCountry()
        && getIssueState() == that.getIssueState()
        && Objects.equals(getDriverAddress(), that.getDriverAddress())
        && Objects.equals(getIssueDate(), that.getIssueDate())
        && Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getLicenseNumber(), getDriverFirstName(), getDriverLastName(), getDriverBirthDate(),
            getIssueCountry(), getIssueState(), getDriverAddress(), getIssueDate(),
            getExpirationDate());
  }

  @Override
  public String toString() {
    return "LicenseInfo{"
        + "licenseNumber='" + licenseNumber + '\''
        + ", driverFirstName='" + driverFirstName + '\''
        + ", driverLastName='" + driverLastName + '\''
        + ", driverBirthDate=" + driverBirthDate
        + ", issueCountry=" + issueCountry
        + ", issueState=" + issueState
        + ", driverAddress=" + driverAddress
        + ", issueDate=" + issueDate
        + ", expirationDate=" + expirationDate
        + '}';
  }
}
