# Object Relationships

## Overview
This document outlines the relationships between the key objects in the RideWise application. Understanding these relationships is crucial for maintaining and extending the system.

## Relationships

### 1. Rider and Ride
- **Relationship**: One-to-Many
- **Description**: A `Rider` can have multiple `Ride` objects associated with them, representing their ride history.
- **Implementation**:
  - The `Rider` class contains a list of `Ride` objects.

### 2. Driver and Ride
- **Relationship**: One-to-Many
- **Description**: A `Driver` can have multiple `Ride` objects associated with them, representing the rides they have completed.
- **Implementation**:
  - The `Driver` class contains a list of `Ride` objects.

### 3. Ride and RideStatus
- **Relationship**: One-to-One
- **Description**: Each `Ride` has a single `RideStatus` that represents its current state (e.g., REQUESTED, ONGOING, COMPLETED).
- **Implementation**:
  - The `Ride` class has a `RideStatus` attribute.

### 4. Ride and FareReceipt
- **Relationship**: One-to-One
- **Description**: Each `Ride` generates a single `FareReceipt` upon completion.
- **Implementation**:
  - The `Ride` class has a `FareReceipt` attribute.

### 5. RideMatchingService and RideMatchingStrategy
- **Relationship**: One-to-Many (via abstraction)
- **Description**: The `RideMatchingService` uses different implementations of the `RideMatchingStrategy` interface to match riders with drivers.
- **Implementation**:
  - The `RideMatchingService` depends on the `RideMatchingStrategy` abstraction.

### 6. Ride and LocationEnum
- **Relationship**: One-to-Two
- **Description**: Each `Ride` has a pickup and drop-off location, represented by `LocationEnum` values.
- **Implementation**:
  - The `Ride` class has two attributes: `pickupLocation` and `dropoffLocation`.

### 7. Ride and FareCalculationStrategy
- **Relationship**: One-to-Many (via abstraction)
- **Description**: The `Ride` uses different implementations of the `FareCalculationStrategy` interface to calculate the fare.
- **Implementation**:
  - The `Ride` class depends on the `FareCalculationStrategy` abstraction.

## Diagram
Below is a high-level representation of the object relationships:

```
Rider --< Ride >-- Driver
   |                |
   v                v
RideStatus      FareReceipt

RideMatchingService --< RideMatchingStrategy
Ride --< FareCalculationStrategy
Ride -- LocationEnum (pickup/dropoff)
```

## Conclusion
The RideWise application is designed with clear and modular object relationships, ensuring that the system is easy to understand, maintain, and extend.