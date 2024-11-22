import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class UserManager {

    private ArrayList<User> userList = new ArrayList<>();
    private Random random = new Random();
    private static VehicleManager vmanager = new VehicleManager();

    public void registerUser(String name, int age, String email) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                System.out.println(name + ", you already have an account.");
                return;
            }
        }

        User newUser = new User(name, email, age);
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setEmail(email);
        newUser.setMemberID(random.nextInt(9000) + 10000);

        userList.add(newUser);

        System.out.println("Welcome " + newUser.getName() + "! You are now registered with SINNIG Car Rental.");
        System.out.println("Here is your Membership Pin: " + newUser.getMemberID());
    }

    public void LoginUser(String name, int memberID) {
        for (User user : userList) {
            if (user.getName().equals(name) && user.getMemberID() == memberID) {
                System.out.println("Welcome, " + name + "!");
            } 
            else{
                System.out.println("Invalid name or Membership Pin.");
            }
        } 
        
    }

    public boolean CheckUser(String name, int memberID) {
        for (User user : userList) {
            if (user.getName().equals(name) && user.getMemberID() == memberID) {
                return true;
            }
        }
        return false;
    }


    public void deleteUser(String name, int memberID) {
        for (User user : userList) {
            if (user.getName().equals(name) && user.getMemberID() == memberID) {
                userList.remove(user);
                System.out.println("Sad to see you go, " + name + ".");
                return;
            }
        }

        System.out.println("Didn't find any account with the name or Member Pin.");
    }

    public void rent(VehicleManager vehicleManager) {
        Scanner scanner = new Scanner(System.in);

        if (vehicleManager.getVehicleList().isEmpty()) {
            System.out.println("No vehicles available for rent at the moment. Please try again later.");
            return;  
        }
    
        System.out.println("Available Vehicles:");
        vehicleManager.viewInventory();
        
        System.out.println("Enter the ID of the car you wish to rent: ");
        int vehicleId = scanner.nextInt();
    
        Vehicle selectedVehicle = vehicleManager.findVehicleById(vehicleId);
    
        if (selectedVehicle == null) {
            System.out.println("Invalid vehicle ID. Please try again.");
            return;
        }
    
        System.out.println("Enter the number of days you want to rent the car: ");
        int rentalDays = scanner.nextInt();
    
        double totalPrice = selectedVehicle.getRentRate() * rentalDays;
        System.out.printf("The estimated total cost for renting a %s (%s) for %d days is: $%.2f%n", 
                          selectedVehicle.getCarModel(), 
                          selectedVehicle.getCarType(), 
                          rentalDays, 
                          totalPrice);
    
        System.out.println("Do you want to proceed with the rental? [1] Yes [2] No");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Rental canceled.");
        }
    }    
    
}