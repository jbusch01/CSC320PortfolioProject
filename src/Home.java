public class Home {
    
    private static int homeCounter = 0;
    private String homeID;
    private String homeModel;
    private String homeStreetAddress;
    private String homeCity;
    private String homeState;
    private int homeZipCode;
    private int squareFeet;
    private String salesStatus;
    
    // Constructor
    public Home(String id, String model, String street, String city, String state, int zip, int sqft, String status) {
        
        homeCounter ++;
        this.homeID = String.format("HID-%04d", homeCounter);
        this.homeModel = model;
        this.homeStreetAddress = street;
        this.homeCity = city;
        this.homeState = state;
        this.homeZipCode = zip;
        this.squareFeet = sqft;
        this.salesStatus = status;
    }

    public void displayHome() {
        System.out.println("Home Information:");
        System.out.println("Home ID: " + homeID);
        System.out.println("Model: " + homeModel);
        System.out.println("Street Address: " + homeStreetAddress);
        System.out.println("City: " + homeCity);
        System.out.println("State: " + homeState);
        System.out.println("Zip Code: " + homeZipCode);
        System.out.println("Square Feet: " + squareFeet);
        System.out.println("Sales Status: " + salesStatus);
    }

    public String getHomeID() {
        return homeID;
    }

    public String getHomeStreetAddress() {
        return homeStreetAddress;
    }
}