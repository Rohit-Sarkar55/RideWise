package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.util.CommonHelper;

public class DefaultFareStrategy implements FareCalculationStrategy {
    
    @Override
    public double calculateFare( double distance, VehicleType vehicleType) {
        double fare =  baseFare + CommonHelper.vehicleSpecificRate(distance, vehicleType);
        return Math.round(fare*100.0)/100.0;
    }
}