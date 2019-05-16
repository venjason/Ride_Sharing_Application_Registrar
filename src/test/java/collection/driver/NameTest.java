package collection.driver;

import static org.junit.Assert.*;

import java.time.Year;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;
  private Name name2;

  @Before
  public void setUp() {
    name = new Name("Rob", "Lippset");
    name2 = new Name("Maxx", "Chewning");
  }

  @Test
  public void equalsTest() {
    assertEquals(name, name);
    assertEquals(new Name("Rob", "Lippset"), name);
    assertNotEquals(name, name2);
    assertNotEquals(name, Year.of(2000));
    assertNotEquals(name, null);
  }

  @Test
  public void hashCodeTest() {
    assertEquals(name.hashCode(), name.hashCode());
    assertNotEquals(name.hashCode(), name2.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals("Rob Lippset", name.toString());
  }

  @Test
  public void getFirst() {
    assertEquals("Maxx", name2.getFirst());
  }

  @Test
  public void getLast() {
    assertEquals("Chewning", name2.getLast());
  }
}