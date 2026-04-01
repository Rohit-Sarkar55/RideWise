package com.airtribe.ridewise.strategy;

public class PeakHourStrategy implements FareCalculationStrategy {

    @Override
    public double calculateFare( double distance) {
        return 1.5 * (baseFare + (distance * 10));
    }
}