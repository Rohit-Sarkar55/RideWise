package com.airtribe.ridewise.enums;

public enum LocationEnum {
    MG_ROAD(12.9716, 77.5946),
    KORAMANGALA(12.9352, 77.6245),
    WHITEFIELD(12.9698, 77.7499),
    INDIRANAGAR(12.9784, 77.6408),
    ELECTRONIC_CITY(12.8452, 77.6600);

    private final double latitude;
    private final double longitude;

    LocationEnum(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    } 
}