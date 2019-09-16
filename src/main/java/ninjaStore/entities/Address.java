/*
 * @(#) Address.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.entities;

import java.util.Map;

/**
 * Address class is used to save relevant attributes of an address.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Address {
    private String firstName;
    private String lastName;
    private String address1;
    private String city;
    private String postCode;
    private String country;
    private String regionState;

    /**
     * Sets address' attributes according to given map.
     *
     * @param inputFields - Map with minimum required data.
     */
    public void setAddress(final Map<String, String> inputFields) {
        this.firstName = inputFields.get("First Name");
        this.lastName = inputFields.get("Last Name");
        this.address1 = inputFields.get("Address 1");
        this.city = inputFields.get("City");
        this.postCode = inputFields.get("Post Code");
        this.country = inputFields.get("Country");
        this.regionState = inputFields.get("Region/State");
    }

    /**
     * Allows to get address' first name.
     *
     * @return - Address' first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Allows to get address' last name.
     *
     * @return - Address' last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Allows to get address' address 1.
     *
     * @return - Address' first name.
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Allows to get address' city.
     *
     * @return - Address' city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Allows to get address' post code.
     *
     * @return - Address' post code.
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Allows to get address' country.
     *
     * @return - Address' country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Allows to get address' region/state.
     *
     * @return - Address' region/state.
     */
    public String getRegionState() {
        return regionState;
    }

    /**
     * Allows to get the address in one string.
     *
     * @return - Concatenated address.
     */
    public String getAddressString() {
        String concatenatedAddress = firstName + " " + lastName + "\n"
                + address1 + "\n"
                + city + " " + postCode + "\n"
                + regionState + "\n"
                + country;
        return concatenatedAddress;
    }
}
