package com.trucante.sample.annotation;

import java.lang.reflect.Field;

public class TruncateRunner {

    public static void execute(Object object) {
        ReflectionAnnotatedClasses.findAnnotateInClass(object);
    }
}

class ReflectionAnnotatedClasses {

    static void findAnnotateInClass(Object object) {

        try {
            Class<?> cl = Class.forName(object.getClass().getName());

            for (Field field : cl.getDeclaredFields()) {

                Truncate truncate = field.getAnnotation(Truncate.class);

                if (!field.isAnnotationPresent(Truncate.class)) {
                    return;
                }

                field.setAccessible(true);
                Object value = field.get(object);

                if (value == null || !(value instanceof String)) {
                    return;
                }

                if (value.toString().length() > truncate.size()) {
                    field.set(object, value.toString().substring(0, truncate.size()));
                    field.setAccessible(false);
                }
            }

        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());
        }

    }
}
