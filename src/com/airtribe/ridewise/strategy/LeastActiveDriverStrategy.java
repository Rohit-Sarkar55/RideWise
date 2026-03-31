package com.airtribe.ridewise.strategy;


import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {
    @Override
    public Driver matchDriver(Rider rider, List<Driver> availableDrivers, VehicleType vehicleType) {
        return availableDrivers.stream()
                .min((d1, d2) -> Integer.compare(d1.getRidesCompletedToday(), d2.getRidesCompletedToday()))
                .orElse(null);
    }
}
