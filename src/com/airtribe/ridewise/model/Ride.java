package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.util.CommonHelper;

public class Ride {
    private static long idGenerator = 0;
    private long id;
    private Rider rider;
    private Driver driver;
    private LocationEnum source;
    private LocationEnum destination;
    private double distance;
    private RideStatus status;
    private VehicleType vehicleType;
    private boolean isCompleted;
    private FareReceipt fareReceipt;

    public Ride(Rider rider, LocationEnum destination) {
        this.id = ++idGenerator;
        this.rider = rider;
        this.source = rider.getCurrentLocation();
        this.destination = destination;
        this.distance = CommonHelper.calculateDistance(source, destination);
        this.status = RideStatus.REQUESTED;
        this.isCompleted = false;
    }

    public Ride(Rider rider, LocationEnum destination,
                VehicleType vehicleType) {
        this.id = ++idGenerator;
        this.rider = rider;
        this.source = rider.getCurrentLocation();
        this.destination = destination;
        this.distance = CommonHelper.calculateDistance(source, destination);
        this.status = RideStatus.REQUESTED;
        this.vehicleType = vehicleType;
        this.isCompleted = false;
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
        if(null != driver) {
            this.driver = driver;
            this.status = RideStatus.ASSIGNED;
            this.driver.setAvailable(false);
        }
    }

    public LocationEnum getSource() {
        return source;
    }

    public void setSource(LocationEnum source) {
        this.source = source;
    }

    public LocationEnum getDestination() {
        return destination;
    }

    public void setDestination(LocationEnum destination) {
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public FareReceipt getFareReceipt() {
        return fareReceipt;
    }

    public void setFareReceipt(FareReceipt fareReceipt) {
        this.fareReceipt = fareReceipt;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rider=" + rider +
                ", driver=" + driver +
                ", source=" + source +
                ", destination=" + destination +
                ", distance=" + distance +
                ", status=" + status +
                ", vehicleType=" + vehicleType +
                ", isCompleted=" + isCompleted +
                ", fareReceipt=" + fareReceipt +
                '}';
    }
}
