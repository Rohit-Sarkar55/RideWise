package com.airtribe.ridewise.util;

import com.airtribe.ridewise.enums.LocationEnum;

public class CommonHelper {

    public static double calculateDistance(LocationEnum loc1, LocationEnum loc2) {
        double latDiff = Math.toRadians(loc2.getLatitude() - loc1.getLatitude());
        double lonDiff = Math.toRadians(loc2.getLongitude() - loc1.getLongitude());
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(Math.toRadians(loc1.getLatitude())) * Math.cos(Math.toRadians(loc2.getLatitude()))
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double earthRadius = 6371; // Radius of the Earth in kilometers
        return earthRadius * c;
    }
}
