package collection.driver;

/**
 * Address is a class representing standard address with its details:
 * street number, street name, city name, state acronym, zip code and
 * country name.
 */
public interface IAddress {
  /**
   * Get the street number of the address.
   *
   *  @return the street number of the address
   */
  String getStreetNumber();

  /**
   * Get the street name of the address.
   *
   * @return the street name of the address
   */
  String getStreetName();

  /**
   * Get the city name of the address.
   *
   * @return the city name of the address
   */
  String getCityName();

  /**
   * Get the state acronym of the address.
   *
   * @return the state acronym of the address
   */
  String getStateAcronym();

  /**
   * Get the zip code of the address.
   *
   * @return the zip code of the address
   */
  int getZipCode();

  /**
   * Get the country name of the address.
   *
   * @return the country name of the address
   */
  String getCountryName();
}
