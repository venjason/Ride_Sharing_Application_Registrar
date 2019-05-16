package collection.driver;

import collection.violation.IViolation;
import collection.crash.ICrash;

import java.util.List;
import java.util.Objects;

/**
 * Class Vehicle represents a vehicle of the system.
 */
public class Vehicle implements IVehicle {

  private Integer yearsUsed;
  private Make make;
  private Model model;
  private IPerson owner;
  private List<ICrash> crashes;
  private List<IViolation> violations;
  private IInsuranceInfo insuranceInfo;

  /**
   * Construct a new Vehicle instance with input information.
   *
   * @param yearsUsed the number of years the Vehicle is used.
   * @param make the make of the Vehicle.
   * @param model the model of the Vehicle.
   * @param owner the owner of the Vehicle.
   * @param crashes the list of past crashes of the Vehicle.
   * @param violations the list of past violations of the Vehicle.
   * @param insuranceInfo the insurance information of the Vehicle.
   */
  public Vehicle(
      Integer yearsUsed,
      Make make,
      Model model,
      IPerson owner,
      List<ICrash> crashes,
      List<IViolation> violations,
      IInsuranceInfo insuranceInfo) {
    this.yearsUsed = yearsUsed;
    this.make = make;
    this.model = model;
    this.owner = owner;
    this.crashes = crashes;
    this.violations = violations;
    this.insuranceInfo = insuranceInfo;
  }

  @Override
  public IPerson getOwner() {
    return this.owner;
  }

  @Override
  public Integer getYearsUsed() {
    return yearsUsed;
  }

  @Override
  public Make getMake() {
    return make;
  }

  @Override
  public Model getModel() {
    return model;
  }

  @Override
  public List<ICrash> getCrashes() {
    return crashes;
  }

  @Override
  public List<IViolation> getViolations() {
    return violations;
  }

  @Override
  public IInsuranceInfo getInsuranceInfo() {
    return insuranceInfo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Vehicle)) {
      return false;
    }
    Vehicle vehicle = (Vehicle) obj;
    return Objects.equals(getYearsUsed(), vehicle.getYearsUsed())
        && Objects.equals(getMake(), vehicle.getMake())
        && Objects.equals(getModel(), vehicle.getModel())
        && Objects.equals(getOwner(), vehicle.getOwner())
        && Objects.equals(getInsuranceInfo(), vehicle.getInsuranceInfo());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getYearsUsed(),
        getMake(),
        getModel(),
        getOwner(),
        getInsuranceInfo());
  }

  @Override
  public String toString() {
    return "Vehicle{"
        + "yearsUsed=" + yearsUsed
        + ", make=" + make
        + ", model=" + model
        + ", owner=" + owner
        + ", crashes=" + crashes
        + ", violations=" + violations
        + ", insuranceInfo=" + insuranceInfo
        + '}';
  }
}