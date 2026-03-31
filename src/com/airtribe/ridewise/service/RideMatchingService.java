package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RideMatchingService {
    private RideMatchingStrategy strategy;

    public RideMatchingService(RideMatchingStrategy strategy) {
        this.strategy = strategy;
    }
    public RideMatchingService(){
        this.strategy = new NearestDriverStrategy();
    }
    public void setStrategy(RideMatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public Driver findDriver(Rider rider, List<Driver> availableDrivers, VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = availableDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
        return strategy.matchDriver(rider, availableMatchedDrivers, vehicleType);
    }

    public Driver findDriver(Rider rider, List<Driver> availableDrivers,RideMatchingStrategy strategy, VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = availableDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
        return strategy.matchDriver(rider, availableDrivers, vehicleType);
    }
}
