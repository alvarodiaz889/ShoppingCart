package edu.mum.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Sushan on 8/15/2017.
 */
@Entity
public class Shipping {

    //shipping address
    @Id @GeneratedValue
    private int id;
   @NotEmpty(message = "fullname cant be empty")
    private String fullname;
    //@NotEmpty(message = "enter your city")
    private String city;
    //@NotEmpty(message = "enter your zipcode")
    private int zipcode;
    //@NotEmpty(message = "enter your state")
    private String state;
    //@NotEmpty(message = "enter your country")
    private String country;

    //credit card info
    //@NotEmpty
    //@Pattern(regexp = "\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b")
    private long cardNumber;
    //@NotEmpty(message = "enter credit cardname")
    private String name;
    //@NotEmpty(message = "enter credit date")
    private String expiryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
