package com.airtribe.ridewise.strategy;

public class DefaultFareStrategy implements FareCalculationStrategy {
    
    @Override
    public double calculateFare( double distance) {
        return baseFare + (distance * 10);
    }
}