package collection.driver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MakeTest {

  private Make testMake;
  private String testMakeName;

  @Before
  public void setUp() {
    this.testMakeName = "Audi";
    this.testMake = new Make(this.testMakeName);
  }

  @Test
  public void getMake() {
    assertEquals(this.testMakeName, this.testMake.getMake());
  }
}