package com.airtribe.ridewise.model;


import java.sql.Timestamp;

public class FareReceipt {
    private long rideId;
    private double amount;
    private Timestamp generatedAt;

    public FareReceipt(long rideId, double amount, Timestamp generatedAt) {
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAt = generatedAt;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Timestamp generatedAt) {
        this.generatedAt = generatedAt;
    }
}
