package by.belstu.it.yarmolik.lab3.сontrol;

import by.belstu.it.yarmolik.lab3.account.Account;
import by.belstu.it.yarmolik.lab3.account.TypeCard;

import java.util.HashMap;

public class Admin {
    HashMap<Integer, Account> accounts = new HashMap<>();

    //region Methods
    public void addAccount(Account account) {
        accounts.put(account.getNumber(), account);
    }
    public void addCard(Account acc, int numberCard, TypeCard typeCard) {
        acc.addCard(acc.new Card(numberCard, typeCard));
    }
    public void blockAccount(int numberAcc) {
        accounts.get(numberAcc).block();
    }
    public Account findAccount(int numberAcc) {
        return accounts.get(numberAcc);
    }
    //endregion
}
