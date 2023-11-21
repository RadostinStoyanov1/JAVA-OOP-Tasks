package P15ReflectionAndAnnotation.P02GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> !method.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(m -> System.out.println(formatMethodInfo(m)));

    }

    public static String formatMethodInfo(Method m) {
        if (m.getName().startsWith("get")) {
            return String.format("%s will return class %s", m.getName(), m.getReturnType().getName());
        }

        return String.format("%s and will set field of class %s", m.getName(), m.getParameterTypes()[0].getName());
    }
}
