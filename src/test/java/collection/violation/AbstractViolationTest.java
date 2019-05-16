package collection.violation;

import static collection.TestObjectBuilder.*;
import static org.junit.Assert.*;

import collection.driver.Name;
import collection.TestObjectBuilder;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class AbstractViolationTest {

  private DrivingUnderInfluence firstViolation;
  private DrivingUnderInfluence secondViolation;
  private DrivingUnderInfluence thirdViolation;
  private Speeding fourthViolation;

  @Before
  public void setUp() {
    TestObjectBuilder.initialize();
    firstViolation = new DrivingUnderInfluence(LocalDate.of(2019, 1, 1),
        jason);
    secondViolation = new DrivingUnderInfluence(LocalDate.of(2018, 1, 1),
        fernando);
    thirdViolation = new DrivingUnderInfluence(LocalDate.of(2019, 1, 1),
        jason);
    fourthViolation = new Speeding(LocalDate.of(2019, 4, 1),
        chenxi);
  }

  @Test
  public void getDate() {
    LocalDate firstDate = LocalDate.of(2019, 1, 1);
    LocalDate secondDate = LocalDate.of(2018, 1, 1);
    assertEquals(firstDate, firstViolation.getDate());
    assertEquals(secondDate, secondViolation.getDate());
  }

  @Test
  public void getDriver() {
    assertEquals(jason, firstViolation.getDriver());
    assertEquals(fernando, secondViolation.getDriver());
    assertEquals(chenxi, fourthViolation.getDriver());
  }

  @Test
  public void isAfterSixMonths() {
    assertFalse(firstViolation.isAfterSixMonths());
    assertTrue(secondViolation.isAfterSixMonths());
  }

  @Test
  public void equals() {
    assertEquals(firstViolation, firstViolation);
    assertEquals(new DrivingUnderInfluence(LocalDate.of(2019, 1, 1),
        jason), firstViolation);
    assertNotEquals(firstViolation, secondViolation);
    assertNotEquals(firstViolation, new Name("Blake", "Griffin"));
    assertNotEquals(firstViolation, null);
  }

  @Test
  public void testHashCode() {
    assertEquals(firstViolation.hashCode(), firstViolation.hashCode());
    assertEquals(secondViolation.hashCode(), secondViolation.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Driver involved in violation: Jason Ven. Date of violation: 1/1/2019.",
        firstViolation.toString());
    assertEquals("Driver involved in violation: Fernando Winfield. Date of violation: "
        + "1/1/2018.", secondViolation.toString());
  }

  @Test
  public void compareTo() {
    assertEquals(1, firstViolation.compareTo(secondViolation));
    assertEquals(0, firstViolation.compareTo(thirdViolation));
    assertEquals(-1, firstViolation.compareTo(fourthViolation));
  }
}