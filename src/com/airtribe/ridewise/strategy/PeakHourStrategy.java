package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.util.CommonHelper;

public class PeakHourStrategy implements FareCalculationStrategy {

    @Override
    public double calculateFare(double distance, VehicleType vehicleType)
    {
        return 1.5 * (baseFare + CommonHelper.vehicleSpecificRate(distance, vehicleType));
    }
}