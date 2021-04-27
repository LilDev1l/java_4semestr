package by.belstu.it.yarmolik.lab3.main;

//region import
import by.belstu.it.yarmolik.lab3.account.Account;
import by.belstu.it.yarmolik.lab3.account.TypeCard;
import by.belstu.it.yarmolik.lab3.сontrol.Admin;
import by.belstu.it.yarmolik.lab3.сontrol.Client;
import java.util.logging.Logger;
//endregion

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        LOG.info("Created Administrator");
        Admin admin = new Admin();

        LOG.info("Added 2 accounts");
        admin.addAccount(new Account(1));
        admin.addAccount(new Account(2));
        Client bob = new Client(admin.findAccount(1), "Bob");
        Client eva = new Client(admin.findAccount(2), "Eva");

        LOG.info("Cards added to accounts");
        admin.addCard(admin.findAccount(1), 42550, TypeCard.CREDIT);
        admin.addCard(admin.findAccount(1), 42551, TypeCard.DEBIT);
        admin.addCard(admin.findAccount(2), 42552, TypeCard.DEBIT);

        LOG.info("Bob operations");
        bob.viewBalance(42550);
        bob.deposit(42550, 100);
        bob.blockCard(42550);
        bob.payment(42551, 50);
        try {
            bob.payment(42551, 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
