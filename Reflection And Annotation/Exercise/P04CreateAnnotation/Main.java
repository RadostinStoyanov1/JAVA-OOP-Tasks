package P15ReflectionAndAnnotation.P04CreateAnnotation;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<MyAnnotationExample> clazz = MyAnnotationExample.class;

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        Subject annotation = clazz.getAnnotation(Subject.class);
        String[] categories = annotation.categories();
    }
}
