package P15ReflectionAndAnnotation.P03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(f -> System.out.printf("%s must be private!\n", f.getName()));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(Main::filterByType)
                .forEach(m -> System.out.println(formatPrint(m)));

    }

    private static String formatPrint(Method m) {
        String postFix = m.getName().startsWith("get") ? "public!" : "private!";
        return String.format("%s have to be %s", m.getName(), postFix);
    }

    private static boolean filterByType(Method method) {
        return method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()) ||
                method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers());
    }

}
