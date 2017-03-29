package pr01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws
            IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {

        Class<?> reflectionClass = Class.forName("pr01.Reflection");
        Field[] fields = reflectionClass.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        Method[] methods = reflectionClass.getDeclaredMethods();

        List<Method> allGetters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .collect(Collectors.toList());

        List<Method> allSetters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .collect(Collectors.toList());

        allGetters.sort(Comparator.comparing(Method::getName));

        for (Method getter : allGetters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.printf("%s have to be public!%n", getter.getName());
            }
        }

        allSetters.sort(Comparator.comparing(Method::getName));

        for (Method setter : allSetters) {
            if (void.class.equals(setter.getReturnType())) {
                if (!Modifier.isPrivate(setter.getModifiers())) {
                    System.out.printf("%s have to be private!%n", setter.getName());
                }
            }
        }
    }
}
