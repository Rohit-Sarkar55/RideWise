package com.airtribe.ridewise.util;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;

public class CommonHelper {

    public static double calculateDistance(LocationEnum loc1, LocationEnum loc2) {
        double latDiff = Math.toRadians(loc2.getLatitude() - loc1.getLatitude());
        double lonDiff = Math.toRadians(loc2.getLongitude() - loc1.getLongitude());
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(Math.toRadians(loc1.getLatitude())) * Math.cos(Math.toRadians(loc2.getLatitude()))
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double earthRadius = 6371; // Radius of the Earth in kilometers
        double distance = earthRadius * c;
        return Math.round( distance * 100.0)/100.0;
    }

    public static double vehicleSpecificRate(double distance, VehicleType vehicleType){
        switch (vehicleType) {
            case BIKE:
                return distance * 8.0;
            case AUTO:
                return distance * 15.0;
            default:
                return distance * 20.0;
        }
    }
}
