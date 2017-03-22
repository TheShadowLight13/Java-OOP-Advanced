package pr06.comparators;

import pr06.models.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>{

    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            return Character.compare(
                    first.getName().toLowerCase().charAt(0),
                    second.getName().toLowerCase().charAt(0));
        }

        return Integer.compare(first.getName().length(), second.getName().length());
    }
}
