package pr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("END")) {

            String[] data = input.trim().split("\\s+");
            Person person = new Person(data[0], Integer.valueOf(data[1]), data[2]);
            persons.add(person);

            input = reader.readLine();
        }

        int nPersonIndex = Integer.valueOf(reader.readLine()) - 1;
        boolean isPersonExist = isPersonExist(persons, nPersonIndex);

        if (isPersonExist) {
            Person targetPerson = persons.get(nPersonIndex);
            printResult(persons, targetPerson);
        }else {
            System.out.println("No matches");
        }
    }

    private static void printResult(List<Person> persons, Person targetPerson) {
        int equalsPeople = 0;
        int notEqualsPeople = 0;

        for (Person person : persons) {
            if (targetPerson.compareTo(person) == 0) {
                equalsPeople++;
            } else {
                notEqualsPeople++;
            }
        }

        if (equalsPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equalsPeople);
            System.out.println(notEqualsPeople);
            System.out.println(persons.size());
        }
    }

    private static boolean isPersonExist(List<Person> persons, int index) {
        return index >= 0 && index < persons.size();
    }
}
