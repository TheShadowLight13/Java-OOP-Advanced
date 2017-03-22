package pr06.models;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
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

    @Override
    public boolean equals(Object obj) {
        Person person = (Person)obj;
        return this.getName().equals(person.getName())
                && this.getAge() == person.getAge();
    }

    @Override
    public int hashCode() {
        return this.getAge() + + this.getName().hashCode();
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().compareTo(other.getName()) == 0) {
            return Integer.compare(this.getAge(), other.getAge());
        }

        return this.getName().compareTo(other.getName());
    }
}
