package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.exceptions.RideNotFoundException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareCalculationStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideMatchingService {
    List<Ride> allRides ;
    private RideMatchingStrategy rideMatchingStrategy;
    private FareCalculationStrategy fareCalculationStrategy;
    private DriverService driverService;

    public DriverService getDriverService() {
        return driverService;
    }

    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }
    public void addRide(Ride ride){
        this.allRides.add(ride);
    }

    public List<Ride> getAllRides(){
        return this.allRides;
    }
    public RideMatchingService(RideMatchingStrategy rideMatchingStrategy, FareCalculationStrategy fareCalculationStrategy, DriverService driverService) {
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
        this.driverService = driverService;
        this.allRides = new ArrayList<>();
    }
    public RideMatchingService(){
        this.rideMatchingStrategy = new NearestDriverStrategy();
        this.fareCalculationStrategy = new DefaultFareStrategy();
    }


    public Driver findDriver(Rider rider,VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = driverService.getAllAvailableDriversBasedOnType(vehicleType);
        return rideMatchingStrategy.matchDriver(rider, availableMatchedDrivers, vehicleType);
    }

    public Driver findDriver(Rider rider, List<Driver> availableDrivers,RideMatchingStrategy rideMatchingStrategy, VehicleType vehicleType) {
        List<Driver> availableMatchedDrivers = driverService.getAllAvailableDriversBasedOnType(vehicleType);
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

    public double calculateFare(double distance, VehicleType vehicleType) {
        return fareCalculationStrategy.calculateFare(distance, vehicleType);
    }

    public double calculateFare(Ride ride) {
        return fareCalculationStrategy.calculateFare(ride.getDistance(), ride.getVehicleType());
    }

    public double calculateFare(double distance ,VehicleType vehicleType, FareCalculationStrategy fareCalculationStrategy){
        return fareCalculationStrategy.calculateFare(distance, vehicleType);
    }

    public void findAndAssignDriver(Ride ride){
        Driver driver = findDriver(ride.getRider(), ride.getVehicleType());
        assignDriver(ride, driver);
    }
    public void findAndAssignDriver(Ride ride, VehicleType vehicleType){
        ride.setVehicleType(vehicleType);
        findAndAssignDriver(ride);
    }

    public void findAndAssignDriver(RideMatchingStrategy rideMatchingStrategy,Ride ride, List<Driver> availableDrivers){
        Driver driver = findDriver(ride.getRider(), availableDrivers, rideMatchingStrategy,ride.getVehicleType());
        assignDriver(ride, driver);
    }
    public Ride completeRideWithId(long rideId) throws RideNotFoundException{
        Ride ride = getRideById(rideId);
        completeRide(ride);
        return ride;
    }
    private void completeRide(Ride ride) {
    // Mark the ride as completed
        ride.setCompleted(true);
        ride.setStatus(RideStatus.COMPLETED);
        // Calculate the fare
        double fare = fareCalculationStrategy.calculateFare(ride.getDistance(), ride.getVehicleType());

        // Generate a receipt (assuming FareReceipt exists)
        FareReceipt receipt = new FareReceipt(ride.getId(), fare);
        ride.setFareReceipt(receipt);
        ride.getRider().setCurrentLocation(ride.getDestination());
    // Update the driver's availability
        Driver driver = ride.getDriver();
        if (driver != null) {
            driver.setAvailable(true);
            driver.setRidesCompletedToday(driver.getRidesCompletedToday() + 1);
            driver.setCurrentLocation(ride.getDestination());
        }
    }

    public Map<VehicleType, Double> calculateFareForAllVehicleTypes(Ride ride){
        Map<VehicleType, Double> map = new HashMap<>();
        for(VehicleType vehicle: VehicleType.values()){
            double fare = fareCalculationStrategy.calculateFare(ride.getDistance(),vehicle);
            map.put(vehicle, fare);
        }
        return map;
    }

    private Ride getRideById(long rideId){
        Ride result = allRides.stream()
                .filter(driver -> driver.getId() == rideId)
                .findFirst()
                .orElse(null);
        if(null == result){
            throw new RideNotFoundException("Ride not found with the id: "+rideId);
        }
        return result;
    }

    private void cancelRide(Ride ride){
        ride.setCompleted(true);
        ride.setStatus(RideStatus.CANCELLED);

        // Update the driver's availability
        Driver driver = ride.getDriver();
        if (driver != null) {
            driver.setAvailable(true);
        }
    }
    public Ride cancelRideWithId(long rideId) throws RideNotFoundException{
        Ride ride = getRideById(rideId);
        cancelRide(ride);
        return ride;
    }
}
