public class Home {
    
    private String homeID;
    private String homeModel;
    private String homeStreetAddress;
    private String homeCity;
    private String homeState;
    private int homeZipCode;
    
    // Constructor
    public Home(String id, String model, String street, String city, String state, int zip) {
        this.homeID = id;
        this.homeModel = model;
        this.homeStreetAddress = street;
        this.homeCity = city;
        this.homeState = state;
        this.homeZipCode = zip;
    }

    public void displayHome() {
        System.out.println("Home Information:");
        System.out.println("Home ID: " + homeID);
        System.out.println("Model: " + homeModel);
        System.out.println("Street Address: " + homeStreetAddress);
        System.out.println("City: " + homeCity);
        System.out.println("State: " + homeState);
        System.out.println("Zip Code: " + homeZipCode);
    }

    public String getHomeID() {
        return homeID;
    }

    public String getHomeStreetAddress() {
        return homeStreetAddress;
    }
}