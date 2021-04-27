package task1.shower;

import task1.person.Gender;
import task1.person.Person;
import java.util.Random;

public class ShowerVisitor implements Runnable{
    private Shower shower;

    public ShowerVisitor(Shower shower) {
        this.shower = shower;
    }

    @Override
    public void run() {
        try {

            //region Generation task1.person.Person
            Gender[] genders = new Gender[] {Gender.MAN, Gender.WOMAN};

            int durationInShower = new Random().nextInt(2000) + 3000;
            Gender gender = genders[new Random().nextInt(2)];
            Person person = new Person(gender);
            System.out.println("\nСгенирирован следующий посетитель душа: " + person + "; Время в душе: " + durationInShower);
            //endregion

            shower.personGoInShower(person);
            Thread.sleep(durationInShower);
            shower.personCameOutOfShower(person);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
