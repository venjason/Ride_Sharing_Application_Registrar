package collection.driver;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface IInsuranceInfo represents a insurance on a Vehicle.
 */
public interface IInsuranceInfo {

  /**
   * Get the list of persons (except the vehicle owner) under cover of this insurance.
   *
   * @return the list of persons (except the vehicle owner) under cover of this insurance.
   */
  List<IPerson> getOthersCovered();

  /**
   * Get the vehicle owner.
   *
   * @return the vehicle owner.
   */
  Person getOwner();

  /**
   * Get the expiration date of this insurance.
   *
   * @return the expiration date of this insurance.
   */
  LocalDate getExpirationDate();
}
