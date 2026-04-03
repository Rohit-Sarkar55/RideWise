package com.airtribe.ridewise.util;

public class IdGenerator {
    private static long RideId = 0;
    private static long DriverId = 0;
    private static long RiderId =0;


    public static long getNextRideId(){
        RideId++;
        return RideId;
    }

    public static long getNextDriverId(){
        DriverId++;
        return DriverId;
    }

    public static long getNextRiderId(){
        RiderId++;
        return RiderId;
    }

}
