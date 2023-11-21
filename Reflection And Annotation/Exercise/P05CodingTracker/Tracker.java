package P15ReflectionAndAnnotation.P05CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> entry : methodsByAuthor.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(0));
        }
    }
}
