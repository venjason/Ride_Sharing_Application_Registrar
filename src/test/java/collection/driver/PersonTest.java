package collection.driver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

  private Person person;
  private String testFirstName;
  private String testLastName;

  @Before
  public void setUp() {
    testFirstName = "Harry";
    testLastName = "Potter";
    this.person = new Person(testFirstName, testLastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(testFirstName, this.person.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(testLastName, this.person.getLastName());
  }
}