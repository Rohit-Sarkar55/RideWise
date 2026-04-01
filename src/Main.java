import java.util.Scanner;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideMatchingService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.ui.DriverMenu;
import com.airtribe.ridewise.ui.RideMenu;
import com.airtribe.ridewise.ui.RiderMenu;



public class Main {
    public static void main(String[] args) {
        // Create a DriverService instance
        DriverService driverService = new DriverService();
        RiderService riderService = new RiderService();

        driverService.addDriver(new Driver("Rohit", LocationEnum.ELECTRONIC_CITY, VehicleType.BIKE));
        driverService.addDriver(new Driver("Rahul", LocationEnum.KORAMANGALA, VehicleType.AUTO));
        driverService.addDriver(new Driver("Sam", LocationEnum.WHITEFIELD, VehicleType.CAR));
        riderService.addRider(new Rider("Virat", LocationEnum.MG_ROAD));

        Scanner scanner = new Scanner(System.in);
        RiderMenu riderMenu = new RiderMenu(riderService);
        DriverMenu driverMenu = new DriverMenu(driverService);
        RideMatchingService rideMatchingService = new RideMatchingService(new NearestDriverStrategy(), new DefaultFareStrategy(), driverService);
        RideMenu rideMenu = new RideMenu(rideMatchingService,riderService);

        while (true) {
            System.out.println("\n--- RideWise Service ---");
            System.out.println("1. Rider Menu");
            System.out.println("2. Driver Menu");
            System.out.println("3. Ride Menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    riderMenu.displayMenu();
                    break;

                case 2:
                    driverMenu.displayMenu();
                    break;

                case 3:
                    rideMenu.displayMenu();
                    break;

                case 4:
                    System.out.println("Exiting RideWise Service. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}