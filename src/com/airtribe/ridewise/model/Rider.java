package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.util.IdGenerator;

public class Rider {

    private long id;
    private String name;
    private LocationEnum currentLocation;

    public Rider(String name, LocationEnum currentLocation) {
        this.id = IdGenerator.getNextRiderId();
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

    public LocationEnum getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LocationEnum currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
