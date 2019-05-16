package collection;

import collection.crash.ICrash;
import collection.crash.InjuryCrash;
import collection.crash.NoInjuryCrash;
import collection.driver.Address;
import collection.driver.Country;
import collection.driver.Driver;
import collection.driver.IDriver;
import collection.driver.IInsuranceInfo;
import collection.driver.IPerson;
import collection.driver.IVehicle;
import collection.driver.InsuranceInfo;
import collection.driver.LicenseInfo;
import collection.driver.Make;
import collection.driver.Model;
import collection.driver.Person;
import collection.driver.State;
import collection.driver.Vehicle;
import collection.violation.DrivingUnderInfluence;
import collection.violation.IViolation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestObjectBuilder {

  public static InjuryCrash firstCrash;
  public static InjuryCrash secondCrash;
  public static InjuryCrash thirdCrash;
  public static NoInjuryCrash fourthCrash;

  public static IDriver chenxi;
  public static LocalDate chenxiBirthday;
  public static LocalDate chenxiLicenseExpirationDate;
  public static LocalDate chenxiLicenseIssueDate;
  public static LicenseInfo chenxiLicense;
  public static IVehicle chenxiVehicle;
  public static Make chenxiMake;
  public static Model chenxiModel;
  public static Address chenxiAddress;
  public static Person chenxiPerson;
  public static List<ICrash> chenxiCrashes;
  public static List<IViolation> chenxiViolations;
  public static List<ICrash> chenxiVehicleCrashes;
  public static List<IViolation> chenxiVehicleViolations;
  public static IInsuranceInfo chenxiInsurance;
  public static List<IPerson> chenxiOthersCovered;

  public static IDriver newChenxi;
  public static LocalDate newChenxiBirthday;
  public static LocalDate newChenxiLicenseExpirationDate;
  public static LocalDate newChenxiLicenseIssueDate;
  public static LicenseInfo newChenxiLicense;
  public static IVehicle newChenxiVehicle;
  public static Make newChenxiMake;
  public static Model newChenxiModel;
  public static Address newChenxiAddress;
  public static Person newChenxiPerson;
  public static List<ICrash> newChenxiCrashes;
  public static List<IViolation> newChenxiViolations;
  public static List<ICrash> newChenxiVehicleCrashes;
  public static List<IViolation> newChenxiVehicleViolations;
  public static IInsuranceInfo newChenxiInsurance;
  public static List<IPerson> newChenxiOthersCovered;

  public static IDriver jason;
  public static LocalDate jasonBirthday;
  public static LocalDate jasonLicenseExpirationDate;
  public static LocalDate jasonLicenseIssueDate;
  public static LicenseInfo jasonLicense;
  public static IVehicle jasonVehicle;
  public static Make jasonMake;
  public static Model jasonModel;
  public static Address jasonAddress;
  public static Person jasonPerson;
  public static List<ICrash> jasonCrashes;
  public static List<IViolation> jasonViolations;
  public static IInsuranceInfo jasonInsurance;
  public static List<IPerson> jasonOthersCovered;
  public static ICrash jasonRecentCrash;

  public static IDriver fernando;
  public static LocalDate fernandoBirthday;
  public static LocalDate fernandoLicenseExpirationDate;
  public static LocalDate fernandoLicenseIssueDate;
  public static LicenseInfo fernandoLicense;
  public static IVehicle fernandoVehicle;
  public static Make fernandoMake;
  public static Model fernandoModel;
  public static Address fernandoAddress;
  public static Person fernandoPerson;
  public static List<ICrash> fernandoCrashes;
  public static List<IViolation> fernandoViolations;
  public static IInsuranceInfo fernandoInsurance;
  public static List<IPerson> fernandoOthersCovered;
  public static IViolation fernandoDUI;

  public static Country country;
  public static State state;

  // Jason = Has a crash within last six months;
  // Chenxi = Has a clean record;
  // Fernando = Has a DUI;
  public static void initialize() {
    country = Country.THE_US;
    state = State.WASHINGTON;

    // Setting up Chenxi; has a clean record.
    chenxiPerson = new Person("Chenxi", "Zhou");
    chenxiBirthday = LocalDate.of(1991, 1, 1);
    chenxiMake = new Make("BMW");
    chenxiModel = new Model("X5");
    chenxiOthersCovered = new ArrayList<>();
    chenxiInsurance = new InsuranceInfo(chenxiOthersCovered, chenxiPerson,
        LocalDate.of(2020, 1, 1));
    chenxiVehicleCrashes = new ArrayList<>();
    chenxiVehicleViolations = new ArrayList<>();
    chenxiVehicle = new Vehicle(1, chenxiMake, chenxiModel, chenxiPerson, chenxiVehicleCrashes,
        chenxiVehicleViolations, chenxiInsurance);
    chenxiAddress = new Address("456", "University", "Seattle",
        "WA", 98000, "USA");
    chenxiLicenseIssueDate = LocalDate.of(2018, 1, 1);
    chenxiLicenseExpirationDate = LocalDate.of(2020, 1, 1);
    chenxiLicense = new LicenseInfo("67890", "Chenxi",
        "Zhou", LocalDate.of(1991, 1, 1), country, state,
        chenxiAddress, chenxiLicenseIssueDate, chenxiLicenseExpirationDate);
    chenxiCrashes = new ArrayList<>();
    chenxiViolations = new ArrayList<>();
    chenxi = new Driver("Chenxi", "Zhou", chenxiBirthday, chenxiLicense,
        chenxiVehicle, chenxiViolations);
    // Setting up newChenxi; has a clean record.
    newChenxiPerson = new Person("Chenxi", "Zhou");
    newChenxiBirthday = LocalDate.of(1991, 1, 1);
    newChenxiMake = new Make("BMW");
    newChenxiModel = new Model("X5");
    newChenxiOthersCovered = new ArrayList<>();
    newChenxiInsurance = new InsuranceInfo(newChenxiOthersCovered, newChenxiPerson,
        LocalDate.of(2020, 1, 1));
    newChenxiVehicleCrashes = new ArrayList<>();
    newChenxiVehicleViolations = new ArrayList<>();
    newChenxiVehicle = new Vehicle(1, newChenxiMake, newChenxiModel, newChenxiPerson, newChenxiVehicleCrashes,
        newChenxiVehicleViolations, newChenxiInsurance);
    newChenxiAddress = new Address("456", "University", "Seattle",
        "WA", 98000, "USA");
    newChenxiLicenseIssueDate = LocalDate.of(2018, 1, 1);
    newChenxiLicenseExpirationDate = LocalDate.of(2020, 1, 1);
    newChenxiLicense = new LicenseInfo("67890", "Chenxi",
        "Zhou", LocalDate.of(1991, 1, 1), country, state,
        newChenxiAddress, newChenxiLicenseIssueDate, newChenxiLicenseExpirationDate);
    newChenxiCrashes = new ArrayList<>();
    newChenxiViolations = new ArrayList<>();
    newChenxi = new Driver("Chenxi", "Zhou", newChenxiBirthday, newChenxiLicense,
        newChenxiVehicle, newChenxiViolations);
    // ----------------------------------------------------
    // Setting up Jason; has a crash.
    jasonPerson = new Person("Jason", "Ven");
    jasonBirthday = LocalDate.of(1995, 2, 13);
    jasonMake = new Make("Toyota");
    jasonModel = new Model("Camry");
    jasonOthersCovered = new ArrayList<>();
    jasonInsurance = new InsuranceInfo(jasonOthersCovered, jasonPerson,
        LocalDate.of(2020, 1, 1));

    jasonCrashes = new ArrayList<>();


    jasonRecentCrash = new InjuryCrash(LocalDate.now().minusMonths(5), jason);
    // Jason has injury crash within last six months.
    jasonCrashes.add(jasonRecentCrash);


    jasonVehicle = new Vehicle(10, jasonMake, jasonModel, jasonPerson, jasonCrashes,
        jasonViolations, jasonInsurance);
    jasonAddress = new Address("123", "Northeastern", "Seattle",
        "WA", 98000, "USA");
    jasonLicenseIssueDate = LocalDate.of(2000, 1, 1);
    jasonLicenseExpirationDate = LocalDate.of(2020, 1, 1);
    jasonLicense = new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate);
    jasonViolations = new ArrayList<>();
    jason = new Driver("Jason", "Ven", jasonBirthday, jasonLicense, jasonVehicle,
        jasonViolations);


    // Chenxi is covered under Jason's insurance.
    jasonOthersCovered.add(chenxiPerson);

    // ----------------------------------------------------
    // Setting up Fernando; has a DUI under record.
    fernandoPerson = new Person("Fernando", "Winfield");
    fernandoBirthday = LocalDate.of(1995, 1, 1);
    fernandoMake = new Make("Mercedes");
    fernandoModel = new Model("c500");
    fernandoOthersCovered = new ArrayList<>();
    fernandoInsurance = new InsuranceInfo(fernandoOthersCovered, fernandoPerson,
        LocalDate.of(2020, 1, 1));
    fernandoVehicle = new Vehicle(1, fernandoMake, fernandoModel, fernandoPerson,
        fernandoCrashes, fernandoViolations, fernandoInsurance);
    fernandoAddress = new Address("789", "Northwest", "Seattle",
        "WA", 98000, "USA");
    fernandoLicenseIssueDate = LocalDate.of(2020, 1, 1);
    fernandoLicenseExpirationDate = LocalDate.of(2020, 1, 1);
    fernandoLicense = new LicenseInfo("13579", "Fernando",
        "Winfield", LocalDate.of(1995, 1, 1),
        country, state, fernandoAddress, fernandoLicenseIssueDate, fernandoLicenseExpirationDate);
    fernandoCrashes = new ArrayList<>();
    fernandoViolations = new ArrayList<>();
    fernando = new Driver("Fernando", "Winfield", fernandoBirthday,
        fernandoLicense, fernandoVehicle, fernandoViolations);
    // Fernando has a DUI.
    fernandoDUI = new DrivingUnderInfluence(LocalDate.now().minusMonths(20), fernando);
    fernandoViolations.add(fernandoDUI);
    // ----------------------------------------------------
    firstCrash = new InjuryCrash(LocalDate.of(2018, 1, 1), jason);
    secondCrash = new InjuryCrash(LocalDate.of(2019, 1, 1), fernando);
    thirdCrash = new InjuryCrash(LocalDate.of(2018, 1, 1), jason);
    fourthCrash = new NoInjuryCrash(LocalDate.of(2019, 1, 1), fernando);

    buildNewChenxi();
    resetApprovedDriverPool();
  }

  private static void resetApprovedDriverPool() {

  }

  public static void rebuildChenxi() {
    chenxiInsurance = new InsuranceInfo(chenxiOthersCovered, chenxiPerson,
        LocalDate.of(2020, 1, 1));
    chenxi = new Driver("Chenxi", "Zhou", chenxiBirthday, chenxiLicense,
        chenxiVehicle, chenxiViolations);
  }

  private static void buildNewChenxi() {
    LicenseInfo newChenxiLicense = new LicenseInfo(
        chenxiLicense.getLicenseNumber(),
        chenxiLicense.getDriverFirstName(),
        chenxiLicense.getDriverLastName(),
        chenxiLicense.getDriverBirthDate(),
        chenxiLicense.getIssueCountry(),
        chenxiLicense.getIssueState(),
        chenxiLicense.getDriverAddress(),
        chenxiLicense.getIssueDate(),
        chenxiLicense.getExpirationDate()
    );
    List<ICrash> newChenxiCrashes = new ArrayList<>();
    List<IViolation> newChenxiViolations = new ArrayList<>();
    InsuranceInfo newChenxiInsurance = new InsuranceInfo(
        new ArrayList<IPerson>(),
        new Person(chenxi.getFirstName(), chenxi.getLastName()),
        LocalDate.of(
            chenxiInsurance.getExpirationDate().getYear(),
            chenxiInsurance.getExpirationDate().getMonthValue(),
            chenxiInsurance.getExpirationDate().getDayOfMonth()
        )
    );
    Vehicle newChenxiVehicle = new Vehicle(
        chenxiVehicle.getYearsUsed(),
        new Make(chenxiVehicle.getMake().getMake()),
        new Model(chenxiVehicle.getModel().getModel()),
        new Person(chenxi.getFirstName(), chenxi.getLastName()),
        newChenxiCrashes,
        newChenxiViolations,
        newChenxiInsurance

    );
    newChenxi = new Driver(
        chenxi.getFirstName(),
        chenxi.getLastName(),
        chenxi.getBirthDate(),
        newChenxiLicense,
        newChenxiVehicle,
        chenxi.getViolations()
    );
  }
}

