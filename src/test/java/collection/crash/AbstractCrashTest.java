package collection.crash;

import static collection.TestObjectBuilder.*;
import static org.junit.Assert.*;

import collection.driver.Name;
import collection.TestObjectBuilder;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class AbstractCrashTest {

  private InjuryCrash firstCrash;
  private InjuryCrash secondCrash;
  private InjuryCrash thirdCrash;

  @Before
  public void setUp() throws Exception {
    TestObjectBuilder.initialize();
    firstCrash = new InjuryCrash(LocalDate.of(2019, 1, 1),
        jason);
    secondCrash = new InjuryCrash(LocalDate.of(2018, 1, 1),
        fernando);
    thirdCrash = new InjuryCrash(LocalDate.of(2019, 1, 1),
        jason);
    fourthCrash = new NoInjuryCrash(LocalDate.of(2019, 4, 1),
        chenxi);
  }

  @Test
  public void getDate() {
    LocalDate firstDate = LocalDate.of(2018, 1, 1);
    LocalDate secondDate = LocalDate.of(2019, 1, 1);
    assertEquals(firstDate, secondCrash.getDate());
    assertEquals(secondDate, firstCrash.getDate());

  }

  @Test
  public void getDriver() {
    assertEquals(jason, firstCrash.getDriver());
    assertEquals(fernando, secondCrash.getDriver());

  }

  @Test
  public void isAfterSixMonths() {
    assertTrue(secondCrash.isAfterSixMonths());
    assertFalse(firstCrash.isAfterSixMonths());
  }

  @Test
  public void testHashCode() {
    assertEquals(firstCrash.hashCode(), firstCrash.hashCode());
    assertNotEquals(firstCrash.hashCode(), secondCrash.hashCode());
  }

  @Test
  public void equals() {
    assertEquals(firstCrash, firstCrash);
    assertEquals(new InjuryCrash(LocalDate.of(2019, 1, 1),
        jason), firstCrash);
    assertNotEquals(firstCrash, secondCrash);
    assertNotEquals(firstCrash, new Name("Blake", "Griffin"));
    assertNotEquals(firstCrash, null);
  }

  @Test
  public void testToString() {
    assertEquals("Driver involved in crash: Jason Ven. Date of accident: 1/1/2019.",
        firstCrash.toString());
    assertEquals("Driver involved in crash: Fernando Winfield. Date of accident: "
        + "1/1/2018.", secondCrash.toString());
  }

  @Test
  public void compareTo() {
    assertEquals(-1, secondCrash.compareTo(firstCrash));
    assertEquals(0, firstCrash.compareTo(thirdCrash));
    assertEquals(1, firstCrash.compareTo(secondCrash));
  }
}
