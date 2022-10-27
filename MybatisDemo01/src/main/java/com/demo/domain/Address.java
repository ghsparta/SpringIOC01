package com.demo.domain;

public class Address {
    private int aid;
    private int pid;
    private String street;
    private String city;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", pid=" + pid +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
