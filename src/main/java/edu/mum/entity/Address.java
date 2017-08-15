package edu.mum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int addressId;
    private String city;
    private String zipcode;
    private String country;
    private String state;

    public Address(){}

    public Address(int id,String city,String zipcode,String country,String state)
    {
        this.addressId = id;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int id) {
        this.addressId = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }






}
