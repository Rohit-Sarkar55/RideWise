package com.airtribe.ridewise.strategy;

public interface FareCalculationStrategy {
    public static final double baseFare = 25;
    double calculateFare(double distance);
}