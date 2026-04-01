package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareCalculationStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

import java.util.List;

public class RideMatchingService {
    private RideMatchingStrategy rideMatchingStrategy;
    private FareCalculationStrategy fareCalculationStrategy;

    public RideMatchingService(RideMatchingStrategy rideMatchingStrategy, FareCalculationStrategy fareCalculationStrategy) {
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }
    public RideMatchingService(){
        this.rideMatchingStrategy = new NearestDriverStrategy();
        this.fareCalculationStrategy = new DefaultFareStrategy();
    }


    public Driver findDriver(Rider rider, List<Driver> availableDrivers, VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = availableDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
        return rideMatchingStrategy.matchDriver(rider, availableMatchedDrivers, vehicleType);
    }

    public Driver findDriver(Rider rider, List<Driver> availableDrivers,RideMatchingStrategy rideMatchingStrategy, VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = availableDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
        return rideMatchingStrategy.matchDriver(rider, availableMatchedDrivers, vehicleType);
    }


    public void setFareCalculationStrategy(FareCalculationStrategy fareCalculationStrategy) {
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    public void setRideMatchingStrategy(RideMatchingStrategy rideMatchingStrategy) {
        this.rideMatchingStrategy = rideMatchingStrategy;
    }

    public void assignDriver(Ride ride, Driver driver){
        ride.setDriver(driver);
    }

    public double calculateFare(double distance) {
        return fareCalculationStrategy.calculateFare(distance);
    }

    public double calculateFare(double distance , FareCalculationStrategy fareCalculationStrategy){
        return fareCalculationStrategy.calculateFare(distance);
    }

    public void findAndAssignDriver(Ride ride, List<Driver> availableDrivers){
        Driver driver = findDriver(ride.getRider(), availableDrivers, ride.getVehicleType());
        assignDriver(ride, driver);
    }

    public void findAndAssignDriver(RideMatchingStrategy rideMatchingStrategy,Ride ride, List<Driver> availableDrivers){
        Driver driver = findDriver(ride.getRider(), availableDrivers, rideMatchingStrategy,ride.getVehicleType());
        assignDriver(ride, driver);
    }
}
