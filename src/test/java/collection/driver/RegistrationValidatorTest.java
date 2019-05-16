package collection.driver;

import static collection.TestObjectBuilder.*;
import static org.junit.Assert.*;

import collection.crash.FenderBenderCrash;
import collection.crash.InjuryCrash;
import collection.crash.NoInjuryCrash;
import collection.violation.DrivingUnderInfluence;
import collection.violation.FailureToRespectTrafficSigns;
import collection.violation.ParkingViolation;
import collection.violation.ProblemsWithVehicle;
import collection.violation.RecklessDriving;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {

  @Before
  public void setUp() throws Exception {
    initialize();
  }

  @Test
  public void processApplication() {
    assertTrue(chenxi.register());
    // check driver age
    initialize();
    chenxiBirthday = LocalDate.now().minusYears(17);
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication2() {
    // check driver license name
    initialize();
    chenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        "Chou",
        chenxiLicense.getDriverBirthDate(),
        chenxiLicense.getIssueCountry(),
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        chenxiLicense.getIssueDate(),
        chenxiLicense.getExpirationDate()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
    // check driver license birth date
    initialize();
    chenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        chenxiLicense.getDriverLastName(),
        chenxiLicense.getDriverBirthDate().minusDays(1),
        chenxiLicense.getIssueCountry(),
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        chenxiLicense.getIssueDate(),
        chenxiLicense.getExpirationDate()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
    // check driver license country
    initialize();
    chenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        chenxiLicense.getDriverLastName(),
        chenxiLicense.getDriverBirthDate(),
        country.OTHER_COUNTRIES,
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        chenxiLicense.getIssueDate(),
        chenxiLicense.getExpirationDate()
    );
    // check driver license issue date
    initialize();
    chenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        chenxiLicense.getDriverLastName(),
        chenxiLicense.getDriverBirthDate(),
        chenxiLicense.getIssueCountry(),
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        LocalDate.now().minusMonths(5),
        chenxiLicense.getExpirationDate()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
    // check driver license expiration date
    initialize();
    chenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        chenxiLicense.getDriverLastName(),
        chenxiLicense.getDriverBirthDate(),
        chenxiLicense.getIssueCountry(),
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        chenxiLicense.getIssueDate(),
        LocalDate.now().minusDays(1)
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication3() {
    assertTrue(chenxi.register());
    // check vehicle age
    initialize();
    chenxiVehicle = new Vehicle(
        21,
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication4() {
    assertTrue(chenxi.register());
    // check driver insurance coverage
    initialize();
    chenxiInsurance = new InsuranceInfo(chenxiOthersCovered, fernandoPerson,
        LocalDate.of(2020, 1, 1));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiInsurance
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
    chenxiInsurance.getOthersCovered().add(chenxiPerson);
    assertTrue(chenxi.register());
    // check driver insurance expiration
    initialize();
    chenxiInsurance = new InsuranceInfo(chenxiOthersCovered, chenxiPerson,
        LocalDate.now().minusDays(1));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiInsurance
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication5() {
    // check non-moving violations
    initialize();
    chenxiViolations.add(
        new ParkingViolation(LocalDate.now().minusDays(1), chenxi)
    );
    chenxiViolations.add(
        new ParkingViolation(LocalDate.now().minusDays(1), chenxi)
    );
    rebuildChenxi();
    assertTrue(chenxi.register());
  }

  @Test
  public void processApplication6() {
    // check moving violations
    initialize();
    chenxiViolations.add(
        new ParkingViolation(LocalDate.now().minusDays(1), chenxi)
    );
    chenxiViolations.add(
        new ParkingViolation(LocalDate.now().minusDays(1), chenxi)
    );
    chenxiViolations.add(
        new DrivingUnderInfluence(LocalDate.now().minusYears(10), chenxi)
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication7() {
    // check vehicle with crashes at date >= 6 months ago
    initialize();
    chenxiVehicle.getCrashes().add(new FenderBenderCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getCrashes().add(new NoInjuryCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getCrashes().add(new InjuryCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertTrue(chenxi.register());
  }

  @Test
  public void processApplication8() {
    // check vehicle with crashes at date < 6 months ago
    initialize();
    chenxiVehicle.getCrashes().add(new FenderBenderCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getCrashes().add(new NoInjuryCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getCrashes().add(new InjuryCrash(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getCrashes().add(new InjuryCrash(LocalDate.now().minusMonths(5), chenxi));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication10() {
    // check vehicle with violations at date >= 6 months ago
    initialize();
    chenxiVehicle.getViolations()
        .add(new DrivingUnderInfluence(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new ParkingViolation(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new RecklessDriving(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations()
        .add(new ProblemsWithVehicle(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertTrue(chenxi.register());
  }

  @Test
  public void processApplication11() {
    // check vehicle with violation at date < 6 months ago
    initialize();
    chenxiVehicle.getViolations()
        .add(new DrivingUnderInfluence(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new ParkingViolation(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new RecklessDriving(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations()
        .add(new ProblemsWithVehicle(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new ParkingViolation(LocalDate.now().minusMonths(5), chenxi));
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertTrue(chenxi.register());
  }

  @Test
  public void processApplication12() {
    // check vehicle with violation at date < 6 months ago
    initialize();
    chenxiVehicle.getViolations()
        .add(new DrivingUnderInfluence(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new ParkingViolation(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new RecklessDriving(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations()
        .add(new ProblemsWithVehicle(LocalDate.now().minusMonths(6), chenxi));
    chenxiVehicle.getViolations().add(new ParkingViolation(LocalDate.now().minusMonths(5), chenxi));
    chenxiVehicle.getViolations().add(
        new FailureToRespectTrafficSigns(LocalDate.now().minusMonths(5), chenxi)
    );
    chenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        chenxiVehicle.getMake(),
        chenxiVehicle.getModel(),
        chenxiVehicle.getOwner(),
        chenxiVehicle.getCrashes(),
        chenxiVehicle.getViolations(),
        chenxiVehicle.getInsuranceInfo()
    );
    rebuildChenxi();
    assertFalse(chenxi.register());
  }

  @Test
  public void processApplication13() {
    assertTrue(chenxi.register());
    assertFalse(chenxi.register());
  }
}