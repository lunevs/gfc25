package ru.ichtus.gfc.backend.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class BeanUtils {

    @SneakyThrows
    public void copyNotNullProperties(Object source, Object destination) {
        Class<?> sourceClass = source.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        for(Field f : sourceFields) {
            f.setAccessible(true);
            Object value = f.get(source);
            if (value != null) {
                f.set(destination, value);
            }
        }
    }
}
