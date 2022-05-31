package com.example.androiddemoapp.model;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoLocation geo;
    private String phone;
    private String website;
    private Company company;

    public Address() {
    }

    public Address(String street, String suite, String city, String zipcode, GeoLocation geo, String phone, String website, Company company) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
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

    public GeoLocation getGeo() {
        return geo;
    }

    public void setGeo(GeoLocation geo) {
        this.geo = geo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
