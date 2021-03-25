package task1.shower;

import task1.person.Person;
import java.util.ArrayList;

public class Shower {
    private ArrayList<Person> personsInShower = new ArrayList<>();

    synchronized public void personGoInShower(Person person) throws InterruptedException {
        while(personsInShower.size() > 2 || (!personsInShower.isEmpty() ? personsInShower.get(0).getGender() != person.getGender() : false)) {
            System.out.println(person + " ждет");
            this.wait();
        }

        personsInShower.add(person);
        System.out.println(person + " зашел\nчеловек в душе: " + personsInShower.size());
    }

    synchronized public void personCameOutOfShower(Person person) throws InterruptedException {
        personsInShower.remove(person);
        System.out.println(person + " вышел\nчеловек в душе: " + personsInShower.size());
        this.notifyAll();
    }
}
