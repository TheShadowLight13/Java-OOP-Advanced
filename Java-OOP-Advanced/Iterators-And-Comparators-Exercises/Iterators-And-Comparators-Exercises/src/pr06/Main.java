package pr06;

import pr06.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> personSet1 = new TreeSet<>();
        HashSet<Person> personSet2 = new HashSet<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            Person person = new Person(data[0], Integer.valueOf(data[1]));
            personSet1.add(person);
            personSet2.add(person);
        }

        System.out.println(personSet1.size());
        System.out.println(personSet2.size());
    }
}
