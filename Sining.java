import java.util.Scanner;

public class Sining {
    
        private static Scanner sc = new Scanner(System.in);
        private static UserManager userManager = new UserManager();
        private static VehicleManager vManager = new VehicleManager();

        // private static Admin admin = new Admin();
        private static int admin_Pin = 1234;
        private static String admin_username = "admin";
               
                public static void main(String[] args) {
                    while(true){
                        System.out.println("*************************************");
                        System.out.println("Welcome to SINNIG Car Rental");
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Delete Account");
                        System.out.println("4. Exit");
                        System.out.println("Choose an option: ");
                        int option = sc.nextInt();
                        System.out.println("*************************************");
                        sc.nextLine();
                        switch(option){
                            case 1:
                               register();
                                break;
                            case 2:
                                login();
                                break;
                            case 3:
                                deleteAccount();
                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
             
            }
        }

        private static void deleteAccount() {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
       
            System.out.print("Enter your Membership Pin: ");
            int memberID = sc.nextInt();
            sc.nextLine();


            if (!userManager.CheckUser(name, memberID)) {
                System.out.println("No account found with the provided Name and Membership Pin.");
                return;
            }
       
       
            System.out.println("Are you sure you want to DELETE your account? [1] Yes [2] No");
            int option = sc.nextInt();
            sc.nextLine();
       
            if (option == 1) {
                userManager.deleteUser(name, memberID);
                System.out.println("Account deleted successfully.");
            } else {
                System.out.println("From SINNIG Car Rental");
            }
        }
       

        private static void register() {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
       
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            if (age < 18) {
                System.out.println("Sorry, but you need to be at least 18 years old to register.");
                return;
            }
            sc.nextLine();
       
            String email;
            do {
                System.out.print("Enter your email: ");
                email = sc.nextLine();
                if (!email.endsWith("@gmail.com")) {
                    System.out.println("Invalid email address. ONLY @gmail.com addresses are allowed.");
                }
            } while (!email.endsWith("@gmail.com"));
       
            userManager.registerUser(name, age, email);
        }
       
   
        private static void login() {
            
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your membership Pin: ");
            int memberID = sc.nextInt();
            sc.nextLine();
            menuUser();

            if(admin_username.equals(name) && admin_Pin == memberID) {
                System.out.println("Admin login successful.");
                adminMenu();
            }

            userManager.LoginUser(name, memberID);
    
    }

        private static void adminMenu() {
            while(true) {
            System.out.println("**************Admin Menu**************");
            System.out.println("1. View Vehicle Inventory");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Update Vehicle Information");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: vManager.viewInventory();
                break;
                case 2: vManager.addVehicle();
                break;
                case 3: vManager.removeVehicle();
                break;
                case 4: vManager.updateVehicles();
                break;
                case 5: main(null);
                break;
            }
         }
     }

     private static void menuUser() {
        System.out.println("*************User Menu*************");
        System.out.println("1. Rent Car");
        System.out.println("2. Return Car");
        System.out.println("3. View Available Cars");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        int userChoice = sc.nextInt();
        switch(userChoice) {
            case 1: 
                userManager.rent(vManager);
            break;

            case 2:
                break;

            case 3:
            break;

            case 4:
                main(null);
            break;

        }
    }

}
