package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.util.CommonHelper;

public class DefaultFareStrategy implements FareCalculationStrategy {
    
    @Override
    public double calculateFare( double distance, VehicleType vehicleType) {
        return baseFare + CommonHelper.vehicleSpecificRate(distance, vehicleType);
    }
}