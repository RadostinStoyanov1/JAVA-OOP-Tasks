package P15ReflectionAndAnnotation.P01Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class<?>[] clazzes = clazz.getInterfaces();

        for (Class<?> aClass : clazzes) {
            System.out.println(aClass);
        }

        Object reflectionObject = clazz.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
