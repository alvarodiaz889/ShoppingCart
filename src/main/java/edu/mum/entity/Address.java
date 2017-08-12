package edu.mum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String city;
    private String zipcode;
    private String country;
    private String state;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
