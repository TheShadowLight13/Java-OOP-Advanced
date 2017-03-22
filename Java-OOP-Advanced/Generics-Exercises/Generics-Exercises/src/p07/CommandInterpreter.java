package p07;

import java.util.Collections;

public class CommandInterpreter {

    public static void interpretCommand(
            String command, String[] data, ICustomList<String> customList) {
        switch (command.toLowerCase()) {
            case "add":
                customList.add(data[1]);
                break;
            case "remove":
                customList.remove(Integer.valueOf(data[1]));
                break;
            case "contains":
                System.out.println(customList.contains(data[1]));
                break;
            case "swap":
                customList.swap(Integer.valueOf(data[1]), Integer.valueOf(data[2]));
                break;
            case "greater":
                System.out.println(customList.countGreaterThat(data[1]));
                break;
            case "max":
                System.out.println(customList.getMax());
                break;
            case "min":
                System.out.println(customList.getMin());
                break;
            case "print":
                print(customList);
                break;
            case "sort":
                //TODO
                break;
        }
    }

    private static void print(ICustomList<?> customListImpl) {
        for (Object element : customListImpl) {
            System.out.println(element);
        }
    }
}
