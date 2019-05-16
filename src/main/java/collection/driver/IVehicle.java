package collection.driver;

import collection.violation.IViolation;
import collection.crash.ICrash;

import java.util.List;

/**
 * Interface IVehicle represents a vehicle of the system.
 */
public interface IVehicle {

  /**
   * Get the owner of the Vehicle.
   *
   * @return - the date of crash.
   */
  IPerson getOwner();

  /**
   * Get number of years the Vehicle is used.
   *
   * @return the number of years the Vehicle is used.
   */
  Integer getYearsUsed();

  /**
   * Get the make of the Vehicle.
   *
   * @return the make of the Vehicle.
   */
  Make getMake();

  /**
   * Get the model of the Vehicle.
   *
   * @return the model of the Vehicle.
   */
  Model getModel();

  /**
   * Get the list of past crashes of the Vehicle.
   *
   * @return the list of past crashes of the Vehicle.
   */
  List<ICrash> getCrashes();

  /**
   * Get the list of past violations of the Vehicle.
   *
   * @return the list of past violations of the Vehicle.
   */
  List<IViolation> getViolations();

  /**
   * Get the insurance information of the Vehicle.
   *
   * @return the insurance information of the Vehicle.
   */
  IInsuranceInfo getInsuranceInfo();
}