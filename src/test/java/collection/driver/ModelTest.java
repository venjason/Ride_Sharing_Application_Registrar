package collection.driver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

  private Model testModel;
  private String testModelName;

  @Before
  public void setUp() {
    this.testModelName = "A4 Sedan";
    this.testModel = new Model(this.testModelName);
  }

  @Test
  public void getModel() {
    assertEquals(this.testModelName, testModel.getModel());
  }
}