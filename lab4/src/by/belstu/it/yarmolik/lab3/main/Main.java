package by.belstu.it.yarmolik.lab3.main;

//region import
import by.belstu.it.yarmolik.lab3.json.Json;
import by.belstu.it.yarmolik.lab3.stax.StaxStreamProcessor;
import by.belstu.it.yarmolik.lab3.сontrol.Admin;
import by.belstu.it.yarmolik.lab3.сontrol.Client;

import java.util.logging.Logger;
import java.util.stream.Collectors;
//endregion

public class Main {
    public static void main(String[] args) throws Exception {
        Admin admin = new Admin();

        // TODO XMLParse
        StaxStreamProcessor.xmlParse(admin);

        Client bob = new Client(admin.findAccount(1), "Bob");
        Client eva = new Client(admin.findAccount(2), "Eva");

        // TODO JSON serialization
        Json.serialize(new Client[] {bob, eva}, "files/clients.json");
        //Client[] clients = Json.deserialize("files/clients.json");

        // TODO Stream API
        admin.getAccounts().values().stream().filter(x -> x.getBalance() == 0).collect(Collectors.toList()).forEach(System.out::println);

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
