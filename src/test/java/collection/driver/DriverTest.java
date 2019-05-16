package collection.driver;

import static org.junit.Assert.*;

import static collection.TestObjectBuilder.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
  @Before
  public void setUp() throws Exception {
    initialize();
  }

  @Test
  public void getFirstName() {
    assertEquals("Chenxi", chenxi.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Zhou", chenxi.getLastName());
  }

  @Test
  public void getName() {
    assertEquals(chenxi.getName(),
        chenxiLicense.getDriverFirstName() + " " + chenxiLicense.getDriverLastName()
    );
  }

  @Test
  public void getBirthDate() {
    assertEquals(chenxiBirthday, chenxi.getBirthDate());
  }

  @Test
  public void getLicense() {
    assertEquals(chenxiLicense, chenxi.getLicense());
  }

  @Test
  public void getVehicle() {
    assertEquals(chenxiVehicle, chenxi.getVehicle());
  }

  @Test
  public void getViolations() {
    assertEquals(chenxiViolations, chenxi.getViolations());
  }

  @Test
  public void register() {
    assertTrue(chenxi.register());
    assertFalse(jason.register());
    assertFalse(fernando.register());
  }

  @Test
  public void name() {
    assertEquals("Chenxi Zhou", chenxi.getName());
  }

  @Test
  public void equalsTest() {
    assertTrue(chenxi.equals(newChenxi));
    assertFalse(chenxi.equals(jason));
    assertFalse(chenxi.equals(fernando));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(newChenxi.hashCode(), chenxi.hashCode());
    assertNotEquals(newChenxi.hashCode(), jason.hashCode());
    assertNotEquals(newChenxi.hashCode(), fernando.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals(
        "Driver{" +
            "firstName='" + chenxi.getFirstName() + '\'' +
            ", lastName='" + chenxi.getLastName() + '\'' +
            ", birthDate=" + chenxi.getBirthDate() +
            ", license=" + chenxi.getLicense() +
            ", vehicle=" + chenxi.getVehicle() +
            ", violations=" + chenxi.getViolations() +
            '}',
        chenxi.toString()
    );
  }
}