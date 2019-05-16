package collection.driver;

import static collection.TestObjectBuilder.*;

import static org.junit.Assert.*;

import collection.TestObjectBuilder;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

  @Before
  public void setUp() throws Exception {
    TestObjectBuilder.initialize();
  }

  @Test
  public void getOwner() {
    assertEquals(chenxiPerson, chenxiVehicle.getOwner());
    assertEquals(jasonPerson, jasonVehicle.getOwner());
  }

  @Test
  public void getYearsUsed() {
    assertTrue(1 == chenxiVehicle.getYearsUsed());
    assertTrue(10 == jasonVehicle.getYearsUsed());
    assertFalse(1 == jasonVehicle.getYearsUsed());
  }

  @Test
  public void getMake() {
    assertEquals(chenxiMake, chenxiVehicle.getMake());
    assertEquals(jasonMake, jasonVehicle.getMake());
  }

  @Test
  public void getModel() {
    assertEquals(chenxiModel, chenxiVehicle.getModel());
    assertEquals(jasonModel, jasonVehicle.getModel());
  }

  @Test
  public void getCrashes() {
    assertEquals(jasonCrashes, jasonVehicle.getCrashes());
  }

  @Test
  public void getViolations() {
    assertEquals(chenxiViolations, chenxiVehicle.getViolations());
    assertEquals(jasonViolations, jasonVehicle.getViolations());
  }

  @Test
  public void getInsuranceInfo() {
    assertEquals(chenxiInsurance, chenxiVehicle.getInsuranceInfo());
    assertEquals(jasonInsurance, jasonVehicle.getInsuranceInfo());
  }

  @Test
  public void equalsTest() {
    assertEquals(jasonVehicle, new Vehicle(10, jasonMake, jasonModel,
        jasonPerson, jasonCrashes, jasonViolations, jasonInsurance));
    assertEquals(jasonVehicle, jasonVehicle);
    assertNotEquals(jasonVehicle, chenxiVehicle);
    assertNotEquals(jasonVehicle, new Name("Blake", "Griffin"));
    assertNotEquals(jasonVehicle, null);
    assertNotEquals(jasonVehicle, new Vehicle(10, jasonMake, jasonModel,
        jasonPerson, jasonCrashes, jasonViolations, chenxiInsurance));
    assertNotEquals(jasonVehicle, new Vehicle(10, jasonMake, jasonModel,
        chenxiPerson, jasonCrashes, jasonViolations, jasonInsurance));
    assertNotEquals(jasonVehicle, new Vehicle(10, jasonMake, chenxiModel,
        jasonPerson, jasonCrashes, jasonViolations, jasonInsurance));
    assertNotEquals(jasonVehicle, new Vehicle(10, chenxiMake, jasonModel,
        jasonPerson, jasonCrashes, jasonViolations, jasonInsurance));
    assertNotEquals(jasonVehicle, new Vehicle(1, jasonMake, jasonModel,
        jasonPerson, jasonCrashes, jasonViolations, jasonInsurance));
  }
}
