package pr04;

import pr04.interfaces.ILake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> elements = Arrays.stream(reader.readLine().trim().split("[,\\s+]"))
                .filter(e -> !e.equals(""))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        String terminateCommand = reader.readLine();

        ILake<Long> lake = new Lake<>();
        List<Long> numbers = getDistributedNumbers(elements);
        addElements(lake, numbers);

        print(lake);
    }

    private static <T> void print(ILake<T> lake) {
        StringBuilder output = new StringBuilder();

        for (T element : lake) {
            output.append(element).append(", ");
        }

        output.setLength(output.length() - 2);
        System.out.println(output);
    }

    private static <T> void addElements(ILake<T> lake, List<T> elements) {
        for (T element : elements) {
            lake.add(element);
        }
    }

    private static List<Long> getDistributedNumbers(List<Long> elements) {
        List<Long> numbersAtEvenIndex = new ArrayList<>();
        List<Long> numbersAtOddIndex = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            long element = elements.get(i);

            if (i % 2 == 0) {
                numbersAtEvenIndex.add(element);
            } else {
                numbersAtOddIndex.add(element);
            }
        }

        List<Long> numbers = new ArrayList<>();
        numbers.addAll(numbersAtEvenIndex);
        numbers.addAll(numbersAtOddIndex);
        return numbers;
    }
}
