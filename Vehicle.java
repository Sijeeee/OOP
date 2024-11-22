public class Vehicle {
    private int id; 
   private String carModel; 
   private String carType; 
   private int quantity; 
   private double rentRate;
   
   public Vehicle(int id, String carModel, String carType, int quantity, double rentRate) {
    this.id = id;
    this.carModel = carModel;
    this.carType = carType;
    this.quantity = quantity;
    this.rentRate = rentRate;
   }

   public int getId() {
    return id;
   }
   public String getCarModel() {
    return carModel;
   }
   public String getCarType() {
    return carType;
   }
   public int getQuantity() {
    return quantity;
   }
   public double getRentRate() {
    return rentRate;
   }

   public void setId(int id) {
    this.id = id;
   } 
   public void setCarModel(String carModel) {
    this.carModel = carModel;
   } 
   public void setCarType(String carType) {
    this.carType = carType;
   } 
   public void setQuantity(int quantity) {
    this.quantity = quantity;
   } 
   public void setRentRate(double rentRate) {
    this.rentRate = rentRate;
   } 
   
   @Override
   public String toString() {
    return "ID: " + String.format("%04d", id) + "\n" + "Car Model: " + carModel + "\n" + "Car Type: " + carType
    + "\n" + "Quantity: " + quantity + "\n" + "Rental Rate: $" +rentRate + "\n";
   }
}
