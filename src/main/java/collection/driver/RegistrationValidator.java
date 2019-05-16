package collection.driver;

import collection.violation.AbstractMovingViolation;
import collection.violation.DrivingUnderInfluence;
import collection.violation.DrivingWithoutLicenseOrInsurance;
import collection.violation.IViolation;
import collection.violation.RecklessDriving;
import collection.violation.Speeding;
import collection.crash.ICrash;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Interface IDriver represents a driver of the system.
 */
public class RegistrationValidator implements IRegistrationValidator {

  private static Integer minimumDriverAge = 21;
  private static Integer maxUsedYearOfVehicle = 20;
  private static Integer minimumLicensedMonth = 6;
  private static Integer minimumMonthToLastVehicleViolation = 6;
  private static Integer minimumMonthToLastVehicleCrash = 6;
  private static Set<Class> dangerousViolations;
  private Set<IDriver> approvedDrivers;

  /**
   * Build the static dangerous violation set of the RegistrationValidator.
   */
  static {
    dangerousViolations = new HashSet<>();
    dangerousViolations.add(DrivingUnderInfluence.class);
    dangerousViolations.add(DrivingWithoutLicenseOrInsurance.class);
    dangerousViolations.add(RecklessDriving.class);
    dangerousViolations.add(Speeding.class);
  }

  /**
   * Construct the validator with a previously exited pool of approved drivers. or null if it is not
   * there yet.
   */
  public RegistrationValidator() {
    this.approvedDrivers = new HashSet<>();
  }

  @Override
  public Boolean processApplication(IDriver driver) {
    if (!approvedDrivers.contains(driver)
        && driverChecker(driver)
        && licenseChecker(driver)
        && vehicleChecker(driver.getVehicle())
        && vehicleInsuranceChecker(driver)
        && driverHistoryChecker(driver.getViolations())
        && vehicleHistoryChecker(
        driver.getVehicle().getCrashes(),
        driver.getVehicle().getViolations()
    )
    ) {
      approvedDrivers.add(driver);
      return true;
    }
    return false;
  }

  /**
   * Check if the driver's age meet the application requirement.
   *
   * @param driver the driver to be checked.
   * @return the truth value that the driver's age indeed meets the application requirement.
   */
  private Boolean driverChecker(IDriver driver) {
    return !dateDistanceIsWithin(driver.getBirthDate(), LocalDate.now(), minimumDriverAge, 0, 0);
  }

  /**
   * Check if the driver's license details meet the application requirement.
   *
   * @param driver the driver to be checked.
   * @return the truth value that the driver's license details indeed meet the application
   * requirement.
   */
  private Boolean licenseChecker(IDriver driver) {
    return driver.getFirstName().equals(driver.getLicense().getDriverFirstName())
        && driver.getLastName().equals(driver.getLicense().getDriverLastName())
        && driver.getBirthDate().equals(driver.getLicense().getDriverBirthDate())
        && driver.getLicense().getIssueCountry() == Country.THE_US
        && !dateDistanceIsWithin(
        driver.getLicense().getIssueDate(),
        LocalDate.now(),
        0,
        minimumLicensedMonth,
        0)
        && LocalDate.now().isBefore(driver.getLicense().getExpirationDate());
  }

  /**
   * Check if the age of the driver's vehicle meet the application requirement.
   *
   * @param vehicle the driver to be checked.
   * @return the truth value that age of the driver's vehicle indeed meets the application
   * requirement.
   */
  private Boolean vehicleChecker(IVehicle vehicle) {
    return vehicle.getYearsUsed() <= maxUsedYearOfVehicle;
  }

  /**
   * Check if the insurance of the driver's vehicle meet the application requirement.
   *
   * @param driver the driver.
   * @return the truth value that insurance of the driver's vehicle indeed meets the application
   * requirement.
   */
  private Boolean vehicleInsuranceChecker(IDriver driver) {
    IInsuranceInfo insurance = driver.getVehicle().getInsuranceInfo();
    IPerson driverPerson = new Person(driver.getFirstName(), driver.getLastName());
    Boolean applicantCovered = insurance.getOwner().equals(driverPerson)
        || insurance.getOthersCovered().contains(driverPerson);
    return LocalDate.now().isBefore(insurance.getExpirationDate()) && applicantCovered;
  }

  /**
   * Check if the history record of the driver's vehicle meet the application requirement.
   *
   * @param violations the list of all crashes of the
   * @return the truth value that history record of the driver's vehicle indeed meets the
   * application requirement.
   */
  private Boolean driverHistoryChecker(List<IViolation> violations) {
    for (IViolation violation : violations) {
      if (dangerousViolations.contains(violation.getClass())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if the history record of the driver's vehicle meet the application requirement.
   *
   * @return the truth value that history record of the driver's vehicle indeed meets the
   * application requirement.
   */
  private Boolean vehicleHistoryChecker(
      List<ICrash> crashes,
      List<IViolation> violations) {
    for (IViolation violation : violations) {
      if (violation instanceof AbstractMovingViolation
          && dateDistanceIsWithin(
          violation.getDate(),
          LocalDate.now(),
          0,
          minimumMonthToLastVehicleViolation,
          0)
      ) {
        return false;
      }
    }
    for (ICrash crash : crashes) {
      if (dateDistanceIsWithin(
          crash.getDate(),
          LocalDate.now(),
          0,
          minimumMonthToLastVehicleCrash,
          0)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if the period from date1 to date2 is within a given period of time.
   *
   * @param date1 the earlier date.
   * @param date2 the later date.
   * @param year the number of years of the given period.
   * @param month the number of years of the given period.
   * @param day the number of years of the given period.
   * @return the truth value that the period from date1 to date2 is within the given period.
   */
  private Boolean dateDistanceIsWithin(
      LocalDate date1,
      LocalDate date2,
      Integer year,
      Integer month,
      Integer day) {
    date1 = date1.plusYears(Long.valueOf(year))
        .plusMonths(Long.valueOf(month))
        .plusDays(day);
    return date1.isAfter(date2);
  }

  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }

  @Override
  public int hashCode() {
    return Objects.hash(approvedDrivers);
  }

  @Override
  public String toString() {
    return "RegistrationValidator{" + "approvedDrivers=" + approvedDrivers + '}';
  }
}