# RideWise

RideWise is a ride-sharing application designed to connect riders with drivers efficiently. The system is built with modularity, scalability, and maintainability in mind, adhering to SOLID principles and leveraging design patterns for flexibility.

## Features
- **Rider and Driver Management**: Manage riders and drivers with ease.
- **Ride Matching**: Match riders with the nearest or least active drivers using customizable strategies.
- **Fare Calculation**: Calculate fares dynamically based on distance, time, and other factors.
- **Ride History**: View ride history for both riders and drivers.
- **Extensibility**: Add new ride matching and fare calculation strategies without modifying existing code.

## Project Structure
```
RideWise/
├── src/
│   ├── Main.java
│   ├── com/
│   │   ├── airtribe/
│   │   │   ├── ridewise/
│   │   │   │   ├── enums/          # Enums for locations, ride status, etc.
│   │   │   │   ├── exceptions/     # Custom exception classes
│   │   │   │   ├── model/          # Core models like Rider, Driver, Ride
│   │   │   │   ├── service/        # Business logic services
│   │   │   │   ├── strategy/       # Strategy pattern implementations
│   │   │   │   ├── ui/             # User interface classes
│   │   │   │   ├── util/           # Utility classes
│   │   │   │   ├── docs/           # Documentation files
├── README.md
```

## Technologies Used
- **Language**: Java
- **Design Principles**: SOLID
- **Design Patterns**: Strategy Pattern

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in your preferred IDE.
3. Build the project to resolve dependencies.

### Running the Application
1. Navigate to the `src` directory.
2. Run the `Main.java` file to start the application.

### Testing
- Unit tests can be added to ensure the correctness of services and strategies.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any inquiries or support, please contact:
- **Email**: support@ridewise.com
- **GitHub Issues**: Open an issue in the repository.