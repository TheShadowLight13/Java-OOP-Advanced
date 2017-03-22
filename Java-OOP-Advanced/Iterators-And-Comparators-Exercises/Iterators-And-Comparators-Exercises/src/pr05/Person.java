package pr05;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return this.town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().compareTo(other.getName()) == 0) {
            if (this.getAge() > other.getAge()) {
                return 1;
            } else if (this.getAge() < other.getAge()) {
                return -1;
            }

            if (this.getTown().compareTo(other.getTown()) > 0) {
                return 1;
            } else if (this.getTown().compareTo(other.getTown()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        return this.getName().compareTo(other.getName());
    }
}
