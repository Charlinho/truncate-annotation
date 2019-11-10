package com.trucante.sample.annotation;

import java.lang.reflect.Field;
import java.util.List;

public class TruncateRunner {

    public static void execute(Object object) {
        ReflectionAnnotatedClasses.processAnnotations(object);
    }
}

class ReflectionAnnotatedClasses {

    static void processAnnotations(Object object) {
        try {
            Class<?> cl = Class.forName(object.getClass().getName());

            for (Field field : cl.getDeclaredFields()) {
                if (field.isAnnotationPresent(Truncable.class)) {
                    field.setAccessible(true);

                    if (field.get(object) instanceof List) {
                        List<Object> objects = (List<Object>) field.get(object);

                        for (Object o : objects) {
                            for (Field f : o.getClass().getDeclaredFields()) {
                                truncateField(f, o);
                            }
                        }
                    } else {
                        for (Field f : field.get(object).getClass().getDeclaredFields()) {
                            truncateField(f, field.get(object));
                        }
                    }

                } else {
                    truncateField(field, object);
                }
            }

        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());
        }
    }

    private static void truncateField(Field field, Object object) {
        try {

            Truncate truncate = field.getAnnotation(Truncate.class);

            if (field.isAnnotationPresent(Truncate.class)) {

                field.setAccessible(true);
                Object value = field.get(object);

                if (value == null || !(value instanceof String)) {
                    return;
                }

                if (value.toString().length() > truncate.size()) {
                    field.set(object, value.toString().substring(0, truncate.size()));
                }
            }

        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());
        }
    }
}
