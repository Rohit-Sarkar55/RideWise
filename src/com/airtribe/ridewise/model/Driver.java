package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;

public class Driver {

    private static long idGenerator = 0;

    private long id;
    private String name;
    private LocationEnum currentLocation;
    private boolean available;
    private VehicleType vehicleType;
    private int ridesCompletedToday;


    public Driver() {
        this.id = ++idGenerator;
    }

    public Driver(String name, LocationEnum currentLocation, VehicleType type) {
        this.id = ++idGenerator;
        this.name = name;
        this.currentLocation = currentLocation;
        this.vehicleType = type;
        this.ridesCompletedToday = 0;
        this.available = true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEnum getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LocationEnum currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRidesCompletedToday() {
        return ridesCompletedToday;
    }

    public void setRidesCompletedToday(int ridesCompletedToday) {
        this.ridesCompletedToday = ridesCompletedToday;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentLocation=" + currentLocation +

                ", vehicleType=" + vehicleType +
                ", ridesCompletedToday=" + ridesCompletedToday +
                '}';
    }
}
