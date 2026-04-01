import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.RideMatchingService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.PeakHourStrategy;
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
        NearestDriverStrategy nearestDriverStrategy = new NearestDriverStrategy();
        PeakHourStrategy peakHourStrategy = new PeakHourStrategy();
        DefaultFareStrategy defaultFareStrategy = new DefaultFareStrategy();
        RideMatchingService rideMatchingService = new RideMatchingService(nearestDriverStrategy, peakHourStrategy);
        Ride ride = new Ride(rider, rider.getCurrentLocation(), LocationEnum.INDIRANAGAR,  VehicleType.AUTO);
        rideMatchingService.findAndAssignDriver(ride,drivers);


        System.out.println("Nearest Driver: " + ride.getDriver().getName()+" at dist: "+ CommonHelper.calculateDistance(rider.getCurrentLocation(),
                ride.getDriver().getCurrentLocation()) + "Km \ndestination dist: "+ride.getDistance() + " KM");

        System.out.println("Fare: "+ rideMatchingService.calculateFare(ride.getDistance(),defaultFareStrategy));


        // Use LeastActiveDriverStrategy

    }
}