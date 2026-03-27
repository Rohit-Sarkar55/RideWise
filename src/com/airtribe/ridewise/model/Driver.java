package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.VehicleType;

public class Driver {

    private static long idGenerator = 0;

    private long id;
    private String name;
    private Location currentLocation;
    private boolean available;
    private VehicleType vehicleType;


    public Driver() {
        this.id = ++idGenerator;
    }

    public Driver(String name, Location currentLocation, VehicleType type) {
        this.id = ++idGenerator;
        this.name = name;
        this.currentLocation = currentLocation;
        this.vehicleType = type;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
