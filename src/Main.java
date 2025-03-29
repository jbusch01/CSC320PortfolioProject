import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HomeManager manager = new HomeManager();

        while (true) {
            System.out.println("Please choose from one of the following options:");
            System.out.println("1. Add a Home");
            System.out.println("2. View Current Inventory");
            System.out.println("3. Update a Home");
            System.out.println("4. Delete a Home");
            System.out.println("5. Export Inventory List to Desktop");
            System.out.println("6. Exit Program");
            
            int menuOption = scnr.nextInt();
            scnr.nextLine(); // To consume newline

            
            switch (menuOption) {

                case 1:
                    try {
						manager.addHome();
					} catch (Exception e) {
						System.out.println("Error adding home: " + e.getMessage());
					}
                    break;
                case 2:
					manager.listHomes();
                    break;
                case 3:
					manager.updateHome(scnr);
                    break;
                case 4:
                    try {
						manager.deleteHome(scnr);
					} catch (Exception e) {
						System.out.println("Error deleting home: " + e.getMessage());
					}
                    break;
                case 5:
                    manager.exportFile();
                    break;
                case 6:
                    scnr.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;

            }
        }

    }    
}
