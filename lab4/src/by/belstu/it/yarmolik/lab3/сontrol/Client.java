package by.belstu.it.yarmolik.lab3.сontrol;

import by.belstu.it.yarmolik.lab3.account.Account;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Client {
    private String name;
    private Account account;

    //region Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    //endregion
    //region Constructor
    public Client(Account account, String name) {
        this.name = name;
        this.account = account;
    }
    public Client() { }
    //endregion

    //region Methods
    public int viewBalance(int numberCard) {
        return account.getCards().get(numberCard).viewBalance();
    }
    public void blockCard(int numberCard) {
        account.getCards().get(numberCard).block();
    }
    public void deposit(int numberCard, int sum) {
        account.getCards().get(numberCard).deposit(sum);
    }
    public void payment(int numberCard, int sum) throws Exception {
        account.getCards().get(numberCard).payment(sum);
    }
    //endregion
}
