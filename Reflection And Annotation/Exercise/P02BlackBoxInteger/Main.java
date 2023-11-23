package P16ReflectionAndAnnotation.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBox = constructor.newInstance();

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String methodName = line.split("_")[0];
            int methodValue = Integer.parseInt(line.split("_")[1]);

            Method method = blackBoxClass.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBox, methodValue);

            Field innerValue = blackBoxClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBox));

            line = scanner.nextLine();
        }
    }
}
