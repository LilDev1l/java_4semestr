package by.belstu.it.yarmolik.lab3.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.HashMap;

@JsonAutoDetect
public class Account implements Blocking {
    private int number;
    private int balance;
    private HashMap<Integer, Card> cards;

    //region Constructor
    public Account(int number) {
        this.number = number;
        cards = new HashMap<>();
    }
    public Account() {    }
    //endregion
    //region Getter and Setter

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCards(HashMap<Integer, Card> cards) {
        this.cards = cards;
    }

    public HashMap<Integer, Card> getCards() {
        return cards;
    }
    public int getNumber() {
        return number;
    }
    //endregion

    //region Methods
    @Override
    public String toString() {
        return "Счет [номер : " + number + "; " + "баланс : " + balance + "]";
    }
    public void addCard(Card card) {
        cards.put(card.number, card);
    }
    @Override
    public void block() {
        System.out.printf("Счет(%d) заблокирован\n", number);
    }
    //endregion

    public class Card implements Blocking {
        private int number;
        private TypeCard type;

        //region Getter and Setter
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public TypeCard getType() {
            return type;
        }

        public void setType(TypeCard type) {
            this.type = type;
        }
        //endregion

        //region Constructor
        public Card(int number, TypeCard typeCard) {
            this.number = number;
            this.type = typeCard;
        }
        public Card() {   }
        //endregion

        //region Methods
        public int viewBalance()
        {
            return balance;
        }
        public void deposit(int sum) {
            balance += sum;
        }
        public void payment(int sum) throws Exception {
            if (balance < sum)
                throw new Exception("Недостаточно средств");
            balance -= sum;
        }
        @Override
        public void block() {
            System.out.printf("Карта(%d) заблокирована\n", number);
        }
        //endregion
    }
}
