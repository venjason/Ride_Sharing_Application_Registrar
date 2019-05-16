package collection.driver;

import static collection.TestObjectBuilder.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class InsuranceInfoTest {

  @Before
  public void setUp() throws Exception {
    initialize();
  }

  @Test
  public void getOthersCovered() {
    assertEquals(chenxiOthersCovered, chenxiInsurance.getOthersCovered());
  }

  @Test
  public void getOwner() {
    assertEquals(chenxiPerson, chenxiInsurance.getOwner());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(LocalDate.of(2020, 1, 1), chenxiInsurance.getExpirationDate());
  }


  @Test
  public void equalsTest() {
    assertEquals(newChenxiInsurance, chenxiInsurance);
    assertNotEquals(fernandoInsurance, chenxiInsurance);
    assertNotEquals(jasonInsurance, chenxiInsurance);
  }

  @Test
  public void hashCodeTest() {
    assertEquals(newChenxiInsurance, chenxiInsurance);
    assertEquals(fernandoInsurance, fernandoInsurance);
    assertEquals(jasonInsurance, jasonInsurance);
  }

  @Test
  public void toStringTest() {
    assertEquals(newChenxiInsurance.toString(), chenxiInsurance.toString());
  }
}