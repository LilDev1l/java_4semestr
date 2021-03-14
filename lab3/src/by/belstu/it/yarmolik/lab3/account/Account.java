package by.belstu.it.yarmolik.lab3.account;

import java.util.HashMap;

public class Account implements Blocking {
    private int number;
    private int balance;
    private HashMap<Integer, Card> cards;

    //region Constructor
    public Account(int number) {
        this.number = number;
        cards = new HashMap<>();
    }
    //endregion
    //region Getter and Setter
    public HashMap<Integer, Card> getCards() {
        return cards;
    }
    public int getNumber() {
        return number;
    }
    //endregion

    //region Methods
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

        //region Constructor
        public Card(int number, TypeCard typeCard) {
            this.number = number;
            this.type = typeCard;
        }
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
