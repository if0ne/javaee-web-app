package ru.rsreu.javaeewebapp.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapClassConverter {

    private MapClassConverter() {

    }

    public static <T> T getObjectFromMap(Map<String, Object> row, Class<T> tclass) {
        List<Field> fields = Arrays.asList(tclass.getDeclaredFields());
        T object = null;
        try {
            object = tclass.newInstance();
            for (Field field : fields) {
                ColumnLink annotation = field.getAnnotation(ColumnLink.class);
                if (annotation != null) {
                    String columnName = annotation.value();
                    try {
                        Field objectField = object.getClass().getDeclaredField(field.getName());
                        objectField.setAccessible(true);
                        objectField.set(object, row.get(columnName));
                    } catch (Exception exception) {

                    }
                }
            }
        } catch (Exception exception) {

        }

        return object;
    }
}
