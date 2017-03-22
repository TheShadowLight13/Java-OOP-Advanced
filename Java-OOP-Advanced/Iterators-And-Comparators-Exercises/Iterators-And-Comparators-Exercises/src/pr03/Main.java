package pr03;

import pr03.interfaces.IStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        IStack<Integer> stack = new Stack<>();

        String input = reader.readLine();
        while (!input.equals("END")) {

            String[] data = input.split("[,\\s+]");
            String command = data[0];

            try {
                switch (command) {
                    case "Push":
                        List<Integer> elements = Arrays.stream(data).skip(1)
                                .filter(e -> !e.equals(""))
                                .map(Integer::valueOf)
                                .collect(Collectors.toList());
                        pushElements(stack, elements);
                        break;
                    case "Pop":
                        stack.pop();
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            input = reader.readLine();
        }

        print(stack);
    }

    private static void print(IStack<Integer> stack) {
        final int ITERATE_COUNT = 2;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < ITERATE_COUNT; i++) {
            for (Integer element : stack) {
                output.append(element).append("\n");
            }
        }

        System.out.println(output);
    }

    private static void pushElements(IStack<Integer> stack, List<Integer> elements) {
        for (Integer element : elements) {
            stack.push(element);
        }
    }
}
