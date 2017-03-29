package pr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine().trim();
        Class targetClass = RichSoilLand.class;
        Field[] fields;
        StringBuilder output = new StringBuilder();

        while (!command.equals("HARVEST")) {
            fields = targetClass.getDeclaredFields();

            switch (command) {
                case "public":
                    fields = Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .toArray(Field[]::new);
                    break;
                case "private":
                    fields = Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .toArray(Field[]::new);
                    break;
                case "protected":
                    fields = Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .toArray(Field[]::new);
                    break;
            }

            getFieldsInfo(fields, output);
            command = reader.readLine().trim();
        }

        System.out.println(output);
    }

    private static void getFieldsInfo(Field[] fields, StringBuilder output) {

        for (Field field : fields) {
            output.append(String.format("%s %s %s%n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()));
        }
    }
}
