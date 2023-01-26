import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ServerTest {
    Server server;
    Guest guest;
    @BeforeEach
    public void setUp(){
        server = new Server();
        guest = new Guest("Bob", 19);
        guest.addBankAccount('£',1000);
        server.addAvailableDrink("Mojito");
        guest.addFavouriteDrink("Mojito");
    }

    // TODO: test that guest can only get served if over 18

    @Test
    void serverChecksAge() {
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
        guest = new Guest("Billy", 15);
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)

    @Test
    void hasBankAccountInLocalCurrency() {
        guest.addBankAccount('£',1000);
        assertThat(guest.getFiatAccounts().containsKey('£')).isEqualTo(true);
        guest.closeBankAccount('£');
        assertThat(guest.getFiatAccounts().containsKey('£')).isEqualTo(false);
    }

    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)
    @Test
    void bankAccountHasEnoughMoneyToBuyADrink() {
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
        guest.closeBankAccount('£');
        guest.addBankAccount('£',4);
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)
    @Test
    void passesSobrietyTest() {
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
        guest.setSobrietyLevel(13);
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest is not banned from the pub

    @Test
    void serverChecksBan() {
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
        guest.setBanStatus(true);
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)

    @Test
    void serverOnlyServesIfHaveCommonDrinks() {
        assertThat(server.canMakeGuestAcceptableDrink(guest)).isEqualTo(true);
        guest.removeFavouriteDrink("Mojito");
        assertThat(server.canMakeGuestAcceptableDrink(guest)).isEqualTo(false);
    }
}
