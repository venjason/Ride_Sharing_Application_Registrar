package collection.driver;

import java.util.Objects;

/**
 * Class Model represents a Vehicle's model with its String representation.
 */
public class Model {

  private String modelString;

  /**
   * Creates a new Model instance given the String representation.
   *
   * @param modelString the plate's number.
   */
  public Model(String modelString) {
    this.modelString = modelString;
  }

  /**
   * Get the model as a string.
   *
   * @return the String representation of a vehicle's make(brand)
   */
  public String getModel() {
    return this.modelString;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Model)) {
      return false;
    }
    Model model1 = (Model) obj;
    return Objects.equals(getModel(), model1.getModel());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getModel());
  }

  @Override
  public String toString() {
    return "Model{" + "model='" + modelString + '\'' + '}';
  }
}
