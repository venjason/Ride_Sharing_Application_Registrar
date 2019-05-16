package collection.driver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
  static Address address;
  private String testStreetNumber;
  private String testStreetName;
  private String testCityName;
  private String testStateAcronym;
  private int testZipCode;
  private String testCountryName;
  static Address address2;
  private String testStreetNumber2;
  private String testStreetName2;
  private String testCityName2;
  private String testStateAcronym2;
  private int testZipCode2;
  private String testCountryName2;
  static Address address3;
  private String testStreetNumber3;
  private String testStreetName3;
  private String testCityName3;
  private String testStateAcronym3;
  private int testZipCode3;
  private String testCountryName3;

  @Before
  public void setUp() throws Exception {
    testStreetNumber = "12345";
    testStreetName = "John St.";
    testCityName = "Seattle";
    testStateAcronym = "WA";
    testZipCode = 98100;
    testCountryName = "US";
    this.address = new Address(
        testStreetNumber,
        testStreetName,
        testCityName,
        testStateAcronym,
        testZipCode,
        testCountryName
    );
    testStreetNumber2 = "12345";
    testStreetName2 = "John St.";
    testCityName2 = "Seattle";
    testStateAcronym2 = "WA";
    testZipCode2 = 98100;
    testCountryName2 = "US";
    this.address2 = new Address(
        testStreetNumber2,
        testStreetName2,
        testCityName2,
        testStateAcronym2,
        testZipCode2,
        testCountryName2
    );
    testStreetNumber3 = "123456";
    testStreetName3 = "John St.";
    testCityName3 = "Seattle";
    testStateAcronym3 = "WA";
    testZipCode3 = 98100;
    testCountryName3 = "US";
    this.address3 = new Address(
        testStreetNumber3,
        testStreetName3,
        testCityName3,
        testStateAcronym3,
        testZipCode3,
        testCountryName3
    );
  }

  @Test
  public void getStreetNumber() {
    assertEquals("12345", address.getStreetNumber());
  }
  @Test
  public void getStreetName() {
    assertEquals("John St.", address.getStreetName());
  }

  @Test
  public void getCityName() {
    assertEquals("Seattle", address.getCityName());
  }

  @Test
  public void getStateAcronym() {
    assertEquals("WA", address.getStateAcronym());
  }

  @Test
  public void getZipCode() {
    assertEquals(98100, address.getZipCode());
  }

  @Test
  public void getCountryName() {
    assertEquals("US", address.getCountryName());
  }

  @Test
  public void hashCodeTest() {
    assertEquals(address, address2);
    assertNotEquals(address, address3);
  }

  @Test
  public void equalsTest() {
    assertEquals(address.hashCode(), address2.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals(address.toString(), address2.toString());
  }
}