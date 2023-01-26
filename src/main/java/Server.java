import java.util.ArrayList;

public class Server {
    // Properties
    private ArrayList<String> availableDrinks;

    // Class Constructor
    public Server() {
        this.availableDrinks = new ArrayList<>();
    }
    // Methods

    public boolean canMakeGuestAcceptableDrink(Guest guest) {
        var guestFavDrinks = guest.getFavouriteDrinks();
        ArrayList<String> commonDrinks = new ArrayList<>();
        for (String drink : guestFavDrinks) {
            if (guestFavDrinks.contains(drink)) {
                commonDrinks.add(drink);
            }
        }
        if (commonDrinks.size() > 0) {
            return true;
        } else return false;
    }

    public void addAvailableDrink(String drink) {
        this.availableDrinks.add(drink);
    }

    public boolean canServeGuest(Guest guest) {
        if (guest.getAge() >= 18
                && guest.getFiatAccounts().get('£') >= 5
                && guest.getSobrietyLevel() > 50
                && guest.getBanStatus() == false
                && canMakeGuestAcceptableDrink(guest) == true) {
            return true;
        } else if (guest.getAge() < 18
                || guest.getFiatAccounts().get('£') < 5
                || guest.getSobrietyLevel() <= 50
                || guest.getBanStatus() == true
                || canMakeGuestAcceptableDrink(guest) == false) {
            return false;
        } else return false;
    }


    // testing -- ignore
    public static void main(String[] args) {
        Guest guestmus;
        Server servermus;
        guestmus = new Guest("Billy", 19);
        servermus = new Server();
        System.out.println(servermus.canServeGuest(guestmus));
    }
}
