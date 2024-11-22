import java.util.Scanner;

public class CalculatePrice {
    private VehicleManager vehicleManager;

    public CalculatePrice(VehicleManager vehicleManager) {
        this.vehicleManager = vehicleManager;
    }

    public void calculatePrice() {
        Scanner scanner = new Scanner(System.in);

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
    }
}
