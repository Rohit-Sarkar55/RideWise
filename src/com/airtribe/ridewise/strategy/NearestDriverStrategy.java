package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.util.CommonHelper;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver matchDriver(Rider rider, List<Driver> availableDrivers, VehicleType vehicleType) {
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : availableDrivers) {
            double distance = CommonHelper.calculateDistance(rider.getCurrentLocation(), driver.getCurrentLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }
        return nearestDriver;
    }
}
