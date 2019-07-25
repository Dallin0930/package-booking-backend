package com.oocl.packagebooking.modle;

import javax.persistence.*;

@Entity
public class Luggage {
    @Id
    @GeneratedValue
    long orderId;

    String name;
    long phoneNumber;
    String status;
    long time;

    @ManyToOne(cascade= CascadeType.ALL)
    private LuggageStroe luggageStroe;

    public Luggage() {
    }

    public Luggage(String name, long phoneNumber, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Luggage(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public LuggageStroe getLuggageStroe() {
        return luggageStroe;
    }

    public void setLuggageStroe(LuggageStroe luggageStroe) {
        this.luggageStroe = luggageStroe;
    }

    public Luggage(String name, long phoneNumber, String status, long time) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.time = time;
    }

    public long getOrderId(long l) {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
