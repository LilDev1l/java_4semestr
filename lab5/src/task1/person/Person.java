package task1.person;

public class Person {
    private int id;
    private Gender gender;

    private static int count;

    //region Constructor and Getter
    public Person(Gender gender) {
        this.gender = gender;
        this.id = count;
        count++;
    }
    public Gender getGender() {
        return gender;
    }
    //endregion

    @Override
    public String toString() {
        return gender.name() + " " + id;
    }
}



