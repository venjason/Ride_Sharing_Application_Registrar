package collection.driver;

import static collection.TestObjectBuilder.*;

import static org.junit.Assert.*;

import collection.TestObjectBuilder;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class LicenseInfoTest {

  @Before
  public void setUp() throws Exception {
    TestObjectBuilder.initialize();
  }

  @Test
  public void getLicenseNumber() {
    assertEquals("67890", chenxiLicense.getLicenseNumber());
    assertEquals("12345", jasonLicense.getLicenseNumber());
  }

  @Test
  public void getDriverFirstName() {
    assertEquals("Chenxi", chenxiLicense.getDriverFirstName());
    assertEquals("Jason", jasonLicense.getDriverFirstName());
  }

  @Test
  public void getDriverLastName() {
    assertEquals("Zhou", chenxiLicense.getDriverLastName());
    assertEquals("Ven", jasonLicense.getDriverLastName());
  }

  @Test
  public void getDriverBirthDate() {
    assertEquals(chenxiBirthday, chenxiLicense.getDriverBirthDate());
    assertEquals(jasonBirthday, jasonLicense.getDriverBirthDate());
  }

  @Test
  public void getIssueCountry() {
    assertEquals(country, chenxiLicense.getIssueCountry());
    assertEquals(country, jasonLicense.getIssueCountry());

  }

  @Test
  public void getIssueState() {
    assertEquals(state, chenxiLicense.getIssueState());
    assertEquals(state, jasonLicense.getIssueState());

  }

  @Test
  public void getDriverAddress() {
    assertEquals(chenxiAddress, chenxiLicense.getDriverAddress());
    assertEquals(jasonAddress, jasonLicense.getDriverAddress());

  }

  @Test
  public void getIssueDate() {
    assertEquals(LocalDate.of(2018, 1, 1), chenxiLicense.getIssueDate());
    assertEquals(jasonLicenseIssueDate, jasonLicense.getIssueDate());

  }

  @Test
  public void getExpirationDate() {
    assertEquals(LocalDate.of(2020, 1, 1), chenxiLicense.getExpirationDate());
    assertEquals(jasonLicenseExpirationDate, jasonLicense.getExpirationDate());

  }

  @Test
  public void equalsTest() {
    assertEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
    assertEquals(jasonLicense, jasonLicense);
    assertNotEquals(jasonLicense, chenxiLicense);
    assertNotEquals(jasonLicense, new Name("Blake", "Griffin"));
    assertNotEquals(jasonLicense, null);
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, LocalDate.of(1900, 1, 1)));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, LocalDate.of(1900, 1, 1), jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        new Address("789", "Northwest", "Seattle",
            "WA", 98000, "USA"), jasonLicenseIssueDate,
        jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country,
        State.OHIO, jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1995, 2, 13),
        Country.OTHER_COUNTRIES, state, jasonAddress, jasonLicenseIssueDate,
        jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "Ven", LocalDate.of(1900, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "Jason",
        "V", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("12345", "J",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
    assertNotEquals(jasonLicense, new LicenseInfo("1", "Jason",
        "Ven", LocalDate.of(1995, 2, 13), country, state,
        jasonAddress, jasonLicenseIssueDate, jasonLicenseExpirationDate));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(chenxiLicense.hashCode(), chenxiLicense.hashCode());
    assertEquals(jasonLicense.hashCode(), jasonLicense.hashCode());

  }

  @Test
  public void toStringTest() {
    assertEquals("LicenseInfo{licenseNumber='67890', driverFirstName='Chenxi', "
            + "driverLastName='Zhou', driverBirthDate=1991-01-01, issueCountry=THE_US, "
            + "issueState=WASHINGTON, driverAddress=Address{streetNumber='456', "
            + "streetName='University', cityName='Seattle', stateAcronym='WA', zipCode=98000, "
            + "countryName='USA'}, issueDate=2018-01-01, expirationDate=2020-01-01}",
        chenxiLicense.toString());
  }
}