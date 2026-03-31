import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.RideMatchingService;
import com.airtribe.ridewise.strategy.LeastActiveDriverStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.util.CommonHelper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Rohit", LocationEnum.ELECTRONIC_CITY, VehicleType.AUTO));
        drivers.add(new Driver("Rahul", LocationEnum.KORAMANGALA, VehicleType.AUTO));
        drivers.add(new Driver("Sam", LocationEnum.WHITEFIELD, VehicleType.AUTO));

        // Create a rider
        Rider rider = new Rider("Virat", LocationEnum.MG_ROAD);

        // Use NearestDriverStrategy
        RideMatchingService rideMatchingService = new RideMatchingService(new NearestDriverStrategy());
        Ride ride = new Ride(rider, rider.getCurrentLocation(), LocationEnum.INDIRANAGAR,  VehicleType.AUTO);
        Driver nearestDriver = rideMatchingService.findDriver(rider, drivers, ride.getVehicleType());

        ride.setDriver(nearestDriver);

        System.out.println("Nearest Driver: " + ride.getDriver().getName()+" at dist: "+ CommonHelper.calculateDistance(rider.getCurrentLocation(), nearestDriver.getCurrentLocation()) + "Km \ndestination dist: "+ride.getDistance() + " KM");


        // Use LeastActiveDriverStrategy

    }
}