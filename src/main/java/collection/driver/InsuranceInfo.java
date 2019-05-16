package collection.driver;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Class IInsuranceInfo represents a insurance on a Vehicle.
 */
public class InsuranceInfo implements IInsuranceInfo {

  private List<IPerson> othersCovered;
  private Person owner;
  private LocalDate expirationDate;

  /**
   * Construct a new InsuranceInfo with input information.
   *
   * @param othersCovered list of persons that are under cover.
   * @param owner the owner of the vehicle of this vehicle insurance.
   * @param expirationDate the expiration date of this insurance.
   */
  public InsuranceInfo(
      List<IPerson> othersCovered,
      Person owner,
      LocalDate expirationDate) {
    this.othersCovered = othersCovered;
    this.owner = owner;
    this.expirationDate = expirationDate;
  }

  public List<IPerson> getOthersCovered() {
    return othersCovered;
  }

  public Person getOwner() {
    return owner;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof InsuranceInfo)) {
      return false;
    }
    InsuranceInfo that = (InsuranceInfo) obj;
    return Objects.equals(getOthersCovered(), that.getOthersCovered())
        && Objects.equals(getOwner(), that.getOwner())
        && Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOthersCovered(), getOwner(), getExpirationDate());
  }

  @Override
  public String toString() {
    return "InsuranceInfo{"
        + "othersCovered=" + othersCovered
        + ", owner=" + owner
        + ", expirationDate="
        + expirationDate
        + '}';
  }
}
