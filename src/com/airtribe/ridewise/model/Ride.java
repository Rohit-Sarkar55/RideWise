package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.enums.VehicleType;

public class Ride {
    private static long idGenerator = 0;
    private long id;
    private Rider rider;
    private Driver driver;
    private Location source;
    private Location destination;
    private double distance;
    private RideStatus status;
    private VehicleType vehicleType;

    public Ride(Rider rider, Location source, Location destination,
                double distance, RideStatus status, VehicleType vehicleType) {
        this.id = ++idGenerator;
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        this.distance = Location.calculateDistance(source, destination);
        this.status = RideStatus.REQUESTED;
        this.vehicleType = vehicleType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        this.status = RideStatus.ASSIGNED;
        this.driver.setAvailable(false);
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
