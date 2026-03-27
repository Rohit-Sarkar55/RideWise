package com.airtribe.ridewise.model;

public class Rider {

    private static long idGenerator=0;
    private long id;
    private String name;
    private Location currentLocation;

    public Rider(String name, Location currentLocation) {
        this.id = ++idGenerator;
        this.name = name;
        this.currentLocation = currentLocation;
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
}
