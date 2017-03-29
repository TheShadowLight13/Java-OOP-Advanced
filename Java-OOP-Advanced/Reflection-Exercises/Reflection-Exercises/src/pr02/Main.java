package pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException,
            InvocationTargetException,
            InstantiationException, IOException, NoSuchFieldException {

        Class<?> cl = Class.forName("pr02.BlackBoxInteger");
        Constructor constructor = cl.getConstructor();
        BlackBoxInteger blackBoxInteger = (BlackBoxInteger) constructor.newInstance();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        while (!input.equals("END")) {

            String[] data = input.split("_");
            String command = data[0];
            int value = Integer.valueOf(data[1]);

            Method method = null;

            switch (command) {
                case "add":
                    method = cl.getDeclaredMethod("add", int.class);
                    break;
                case "subtract":
                    method = cl.getDeclaredMethod("subtract", int.class);
                    break;
                case "divide":
                    method = cl.getDeclaredMethod("divide", int.class);
                    break;
                case "multiply":
                    method = cl.getDeclaredMethod("multiply", int.class);
                    break;
                case "leftShift":
                    method = cl.getDeclaredMethod("leftShift", int.class);
                    break;
                case "rightShift":
                    method = cl.getDeclaredMethod("rightShift", int.class);
                    break;
            }

            method.setAccessible(true);
            method.invoke(blackBoxInteger, value);
            Field field = cl.getDeclaredField("innerValue");
            field.setAccessible(true);
            Object fieldValue = field.get(blackBoxInteger);
            System.out.println(fieldValue);

            input = reader.readLine();
        }
    }
}
