 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

// // User class to represent a user of the cab booking application
// class User {
//     private String name;
//     private String gender;
//     private int age;
//     private String username;
//     private int[] location; // [X, Y]

//     public User(String name, String gender, int age, String username) {
//         this.name = name;
//         this.gender = gender;
//         this.age = age;
//         this.username = username;
//         this.location = new int[2]; // Initialize to [0, 0]
//     }

//     public void updateLocation(int x, int y) {
//         this.location[0] = x;
//         this.location[1] = y;
//     }

//     public int[] getLocation() {
//         return location;
//     }

//     public String getUsername() {
//         return username;
//     }
// }

// // Driver class to represent a driver in the cab booking application
// class Driver {
//     private String name;
//     private String gender;
//     private int age;
//     private String vehicleDetails;
//     private int[] currentLocation; // [X, Y]
//     private boolean available;
//     private double totalEarnings;

//     public Driver(String name, String gender, int age, String vehicleDetails, int x, int y) {
//         this.name = name;
//         this.gender = gender;
//         this.age = age;
//         this.vehicleDetails = vehicleDetails;
//         this.currentLocation = new int[]{x, y};
//         this.available = true; // Driver is initially available
//         this.totalEarnings = 0.0;
//     }

//     public void updateLocation(int x, int y) {
//         this.currentLocation[0] = x;
//         this.currentLocation[1] = y;
//     }

//     public double calculateFare(int[] source, int[] destination) {
//         // Calculate distance using Manhattan distance
//         double distance = Math.abs(destination[0] - source[0]) + Math.abs(destination[1] - source[1]);
//         double fare = distance * 2; // Assume $2 per unit distance
//         return fare;
//     }

//     public void addEarnings(double amount) {
//         this.totalEarnings += amount;
//     }

//     public double getTotalEarnings() {
//         return totalEarnings;
//     }

//     public boolean isAvailable() {
//         return available;
//     }

//     public void changeStatus(boolean status) {
//         this.available = status;
//     }

//     public int[] getCurrentLocation() {
//         return currentLocation;
//     }

//     public String getName() {
//         return name;
//     }
// }

// // CabBookingApplication class to manage users and drivers
// class CabBookingApplication {
//     private Map<String, User> users; // Key: username
//     private Map<String, Driver> drivers; // Key: driver name

//     public CabBookingApplication() {
//         this.users = new HashMap<>();
//         this.drivers = new HashMap<>();
//     }

//     public void addUser(String name, String gender, int age, String username) {
//         users.put(username, new User(name, gender, age, username));
//     }

//     public void updateUserLocation(String username, int x, int y) {
//         User user = users.get(username);
//         if (user != null) {
//             user.updateLocation(x, y);
//         }
//     }

//     public void addDriver(String name, String gender, int age, String vehicleDetails, int x, int y) {
//         drivers.put(name, new Driver(name, gender, age, vehicleDetails, x, y));
//     }

//     public void updateDriverLocation(String driverName, int x, int y) {
//         Driver driver = drivers.get(driverName);
//         if (driver != null) {
//             driver.updateLocation(x, y);
//         }
//     }

//     public void changeDriverStatus(String driverName, boolean status) {
//         Driver driver = drivers.get(driverName);
//         if (driver != null) {
//             driver.changeStatus(status);
//         }
//     }

//     public List<String> findRide(String username, int[] source, int[] destination) {
//         List<String> availableRides = new ArrayList<>();
//         for (Driver driver : drivers.values()) {
//             if (driver.isAvailable()) {
//                 double distance = Math.abs(driver.getCurrentLocation()[0] - source[0]) +
//                                   Math.abs(driver.getCurrentLocation()[1] - source[1]);
//                 if (distance <= 5) { // Within 5 units
//                     availableRides.add(driver.getName() + " [Available]");
//                 }
//             }
//         }
//         return availableRides;
//     }

//     public String chooseRide(String username, String driverName) {
//         Driver driver = drivers.get(driverName);
//         User user = users.get(username);
//         if (driver != null && user != null && driver.isAvailable()) {
//             double fare = driver.calculateFare(user.getLocation(), driver.getCurrentLocation());
//             driver.addEarnings(fare);
//             return "Ride Started. Bill amount: $" + fare;
//         }
//         return "Ride cannot be booked.";
//     }

//     public void findTotalEarnings() {
//         for (Driver driver : drivers.values()) {
//             System.out.println(driver.getName() + " earns $" + driver.getTotalEarnings());
//         }
//     }
// }

// // Demo class for testing the cab booking application
// public class cabBooking {
//     public static void main(String[] args) {
//         CabBookingApplication cabApp = new CabBookingApplication();

//         // Onboard 3 users
//         cabApp.addUser("Abhishek", "M", 23, "Abhishek");
//         cabApp.updateUserLocation("Abhishek", 0, 0);
//         cabApp.addUser("Rahul", "M", 29, "Rahul");
//         cabApp.updateUserLocation("Rahul", 10, 0);
//         cabApp.addUser("Nandini", "F", 22, "Nandini");
//         cabApp.updateUserLocation("Nandini", 15, 6);

//         // Onboard 3 drivers
//         cabApp.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", 10, 1);
//         cabApp.addDriver("Driver2", "M", 29, "Swift, KA-01-12346", 11, 10);
//         cabApp.addDriver("Driver3", "M", 24, "Swift, KA-01-12347", 5, 3);

//         // User trying to get a ride
//         System.out.println("Finding ride for Abhishek:");
//         System.out.println(cabApp.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1})); // No ride found

//         System.out.println("\nFinding ride for Rahul:");
//         List<String> ridesForRahul = cabApp.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3});
//         System.out.println(ridesForRahul); // Should show available drivers
//         System.out.println(cabApp.chooseRide("Rahul", "Driver1")); // Choose Driver1

//         // Update user and driver locations
//         cabApp.updateUserLocation("Rahul", 15, 3);
//         cabApp.updateDriverLocation("Driver1", 15, 3);
//         cabApp.changeDriverStatus("Driver1", false); // Driver1 goes unavailable

//         // Try to find ride for Nandini
//         System.out.println("\nFinding ride for Nandini:");
//         System.out.println(cabApp.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4})); // No ride found

//         // Total earnings by drivers
//         System.out.println("\nTotal earnings by drivers:");
//         cabApp.findTotalEarnings();
//     }
// }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





// Interface for fare calculation strategy
interface FareStrategy {
    double calculateFare(int[] source, int[] destination);
}

// Default fare calculation (Strategy Pattern)
class DefaultFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(int[] source, int[] destination) {
        double distance = Math.abs(destination[0] - source[0]) + Math.abs(destination[1] - source[1]);
        return distance * 2; // Assume $2 per unit distance
    }
}

// User class - Single Responsibility Principle
class User {
    private String name;
    private String gender;
    private int age;
    private String username;
    private int[] location; // [X, Y]

    public User(String name, String gender, int age, String username) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.username = username;
        this.location = new int[2]; // Initialize to [0, 0]
    }

    public void updateLocation(int x, int y) {
        this.location[0] = x;
        this.location[1] = y;
    }

    public int[] getLocation() {
        return location;
    }

    public String getUsername() {
        return username;
    }
}

// Driver class - Separate responsibilities, Open/Closed Principle
class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private int[] currentLocation;
    private boolean available;
    private double totalEarnings;
    private FareStrategy fareStrategy;

    public Driver(String name, String gender, int age, String vehicleDetails, int x, int y, FareStrategy fareStrategy) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = new int[]{x, y};
        this.available = true;
        this.totalEarnings = 0.0;
        this.fareStrategy = fareStrategy; // Injecting a strategy for fare calculation
    }

    public void updateLocation(int x, int y) {
        this.currentLocation[0] = x;
        this.currentLocation[1] = y;
    }

    public double calculateFare(int[] source, int[] destination) {
        return fareStrategy.calculateFare(source, destination);
    }

    public void addEarnings(double amount) {
        this.totalEarnings += amount;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public boolean isAvailable() {
        return available;
    }

    public void changeStatus(boolean status) {
        this.available = status;
    }

    public int[] getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }
}

// Factory Pattern for User and Driver creation
class UserFactory {
    public static User createUser(String name, String gender, int age, String username) {
        return new User(name, gender, age, username);
    }
}

class DriverFactory {
    public static Driver createDriver(String name, String gender, int age, String vehicleDetails, int x, int y, FareStrategy fareStrategy) {
        return new Driver(name, gender, age, vehicleDetails, x, y, fareStrategy);
    }
}

// CabBookingApplication class - High-level class, Dependency Inversion Principle
class CabBookingApplication {
    private Map<String, User> users;
    private Map<String, Driver> drivers;

    public CabBookingApplication() {
        this.users = new HashMap<>();
        this.drivers = new HashMap<>();
    }

    public void addUser(String name, String gender, int age, String username) {
        users.put(username, UserFactory.createUser(name, gender, age, username)); // Use Factory Pattern
    }

    public void updateUserLocation(String username, int x, int y) {
        User user = users.get(username);
        if (user != null) {
            user.updateLocation(x, y);
        }
    }

    public void addDriver(String name, String gender, int age, String vehicleDetails, int x, int y) {
        drivers.put(name, DriverFactory.createDriver(name, gender, age, vehicleDetails, x, y, new DefaultFareStrategy())); // Inject Strategy
    }

    public void updateDriverLocation(String driverName, int x, int y) {
        Driver driver = drivers.get(driverName);
        if (driver != null) {
            driver.updateLocation(x, y);
        }
    }

    public void changeDriverStatus(String driverName, boolean status) {
        Driver driver = drivers.get(driverName);
        if (driver != null) {
            driver.changeStatus(status);
        }
    }

    public List<String> findRide(String username, int[] source, int[] destination) {
        List<String> availableRides = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                double distance = Math.abs(driver.getCurrentLocation()[0] - source[0]) +
                                  Math.abs(driver.getCurrentLocation()[1] - source[1]);
                if (distance <= 5) {
                    availableRides.add(driver.getName() + " [Available]");
                }
            }
        }
        return availableRides;
    }

    public String chooseRide(String username, String driverName) {
        Driver driver = drivers.get(driverName);
        User user = users.get(username);
        if (driver != null && user != null && driver.isAvailable()) {
            double fare = driver.calculateFare(user.getLocation(), driver.getCurrentLocation());
            driver.addEarnings(fare);
            return "Ride Started. Bill amount: $" + fare;
        }
        return "Ride cannot be booked.";
    }

    public void findTotalEarnings() {
        for (Driver driver : drivers.values()) {
            System.out.println(driver.getName() + " earns $" + driver.getTotalEarnings());
        }
    }
}

// Demo class for testing the refactored cab booking application
public class CabBookingDemo {
    public static void main(String[] args) {
        CabBookingApplication cabApp = new CabBookingApplication();

        // Onboard users
        cabApp.addUser("Abhishek", "M", 23, "Abhishek");
        cabApp.updateUserLocation("Abhishek", 0, 0);

        // Onboard drivers
        cabApp.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", 10, 1);

        // Find a ride
        System.out.println(cabApp.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}));

        // Total earnings
        cabApp.findTotalEarnings();
    }
}
