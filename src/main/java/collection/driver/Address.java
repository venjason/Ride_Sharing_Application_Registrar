package collection.driver;

import java.util.Objects;

/**
 * Address is a class representing standard address with its details: street number, street name,
 * city name, state acronym, zip code and country name.
 */
public class Address {

  private String streetNumber;
  private String streetName;
  private String cityName;
  private String stateAcronym;
  private int zipCode;
  private String countryName;

  /**
   * Creates a new Address Object representing an address.
   *
   * @param streetNumber the street number of the address
   * @param streetName the street name of the address
   * @param cityName the name of the city of the address
   * @param stateAcronym the state acronym of the address
   * @param zipCode the zip code of the address
   * @param countryName the country name of the address
   */
  public Address(String streetNumber,
      String streetName,
      String cityName,
      String stateAcronym,
      int zipCode,
      String countryName
  ) {
    this.streetNumber = streetNumber;
    this.streetName = streetName;
    this.cityName = cityName;
    this.stateAcronym = stateAcronym;
    this.zipCode = zipCode;
    this.countryName = countryName;
  }

  /**
   * Get the street number of the address.
   *
   * @return the street number of the address
   */
  public String getStreetNumber() {
    return this.streetNumber;
  }

  /**
   * Get the street name of the address.
   *
   * @return the street name of the address
   */
  public String getStreetName() {
    return this.streetName;
  }

  /**
   * Get the city name  of the address.
   *
   * @return the city name of the address
   */
  public String getCityName() {
    return this.cityName;
  }

  /**
   * Get the state acronym of the address.
   *
   * @return the state acronym of the address
   */
  public String getStateAcronym() {
    return this.stateAcronym;
  }

  /**
   * Get the zip code of the address.
   *
   * @return the zip code of the address
   */
  public int getZipCode() {
    return this.zipCode;
  }

  /**
   * Get the country name of the address.
   *
   * @return the country name of the address
   */
  public String getCountryName() {
    return this.countryName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Address)) {
      return false;
    }
    Address address = (Address) obj;
    return getZipCode() == address.getZipCode()
        && Objects.equals(getStreetNumber(), address.getStreetNumber())
        && Objects.equals(getStreetName(), address.getStreetName())
        && Objects.equals(getCityName(), address.getCityName())
        && Objects.equals(getStateAcronym(), address.getStateAcronym())
        && Objects.equals(getCountryName(), address.getCountryName());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getStreetNumber(), getStreetName(), getCityName(), getStateAcronym(), getZipCode(),
            getCountryName());
  }

  @Override
  public String toString() {
    return "Address{"
        + "streetNumber='" + streetNumber + '\''
        + ", streetName='" + streetName + '\''
        + ", cityName='" + cityName + '\''
        + ", stateAcronym='" + stateAcronym + '\''
        + ", zipCode=" + zipCode
        + ", countryName='" + countryName + '\''
        + '}';
  }
}
