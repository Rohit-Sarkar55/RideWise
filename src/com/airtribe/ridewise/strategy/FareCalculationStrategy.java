package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;

public interface FareCalculationStrategy {
    public static final double baseFare = 25;
    double calculateFare(double distance, VehicleType vehicleType);
}