import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideMatchingService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.PeakHourStrategy;
import com.airtribe.ridewise.util.CommonHelper;



public class Main {
    public static void main(String[] args) {
        // Create a DriverService instance
        DriverService driverService = new DriverService();
         
        driverService.addDriver(new Driver("Rohit", LocationEnum.ELECTRONIC_CITY, VehicleType.AUTO));
        driverService.addDriver(new Driver("Rahul", LocationEnum.KORAMANGALA, VehicleType.AUTO));
        driverService.addDriver(new Driver("Sam", LocationEnum.WHITEFIELD, VehicleType.AUTO));
            
        

        // Create a rider
        Rider rider = new Rider("Virat", LocationEnum.MG_ROAD);

        // Use NearestDriverStrategy
        NearestDriverStrategy nearestDriverStrategy = new NearestDriverStrategy();
        PeakHourStrategy peakHourStrategy = new PeakHourStrategy();
        DefaultFareStrategy defaultFareStrategy = new DefaultFareStrategy();

        // Pass DriverService to RideMatchingService
        RideMatchingService rideMatchingService = new RideMatchingService(nearestDriverStrategy, peakHourStrategy, driverService);

        // Create a ride
        Ride ride = new Ride(rider, rider.getCurrentLocation(), LocationEnum.INDIRANAGAR, VehicleType.AUTO);

        // Find and assign driver
        rideMatchingService.findAndAssignDriver(ride);

        // Complete the ride
        rideMatchingService.completeRide(ride);

        System.out.println("Nearest Driver: " + ride.getDriver().getName() + " at dist: " +
                CommonHelper.calculateDistance(rider.getCurrentLocation(), ride.getDriver().getCurrentLocation()) +
                "Km \ndestination dist: " + ride.getDistance() + " KM");

        System.out.println("Fare: " + rideMatchingService.calculateFare(ride));
    }
}