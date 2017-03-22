package pr01;

import pr01.interfaces.IListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(e -> !e.equals("Create")).toArray(String[]::new);
        IListyIterator<String> listyIterator = new ListyIterator<>(elements);

        String input = reader.readLine();
        while (!input.equals("END")) {

            String command = input;

            try {
                switch (command) {
                    case "HasNext":
                        System.out.println(listyIterator.hasNextIndex());
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                    case "PrintAll":
                        printAll(listyIterator);
                        break;
                }
            }catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            input = reader.readLine();
        }
    }

    private static <T> void printAll(IListyIterator<T> listyIterator) {
        for (T element : listyIterator) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
