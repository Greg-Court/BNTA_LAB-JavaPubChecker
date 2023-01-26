import java.util.ArrayList;
import java.util.HashMap;

public class Guest {

    // Properties
    private String name;
    private int age;
    private HashMap<Character,Integer> fiatAccounts;
    private int sobrietyLevel;
    private boolean isBanned;
    private ArrayList<String> favouriteDrinks;

    // Class Constructor
    public Guest(String name, int age){
        this.name = name;
        this.age = age;
        this.fiatAccounts = new HashMap<>();
        this.sobrietyLevel = 100;
        this.isBanned = false;
        this.favouriteDrinks = new ArrayList<>();
    }

    // Methods

    public void addBankAccount(char currency,int moneyAmount) {
        fiatAccounts.put(currency,moneyAmount);
    }
    public void closeBankAccount(char currency) {
        fiatAccounts.remove(currency);
    }
    public void addFavouriteDrink(String favouriteDrink) {
        favouriteDrinks.add(favouriteDrink);
    }
    public void removeFavouriteDrink(String favouriteDrink) {
        favouriteDrinks.remove(favouriteDrink);
    }

    // Getters & Setters
    public int getAge() {
        return this.age;
    }

    public HashMap<Character,Integer> getFiatAccounts() {
        return this.fiatAccounts;
    }

    public int getSobrietyLevel() {
        return this.sobrietyLevel;
    }

    public void setSobrietyLevel(int sobrietyLevel) {
        this.sobrietyLevel = sobrietyLevel;
    }

    public boolean getBanStatus() {
        return this.isBanned;
    }

    public void setBanStatus(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public ArrayList<String> getFavouriteDrinks() {
        return this.favouriteDrinks;
    }


}
