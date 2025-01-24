package com.ciptadana.bareksaapi.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class ReflectionUtil {

    public void assignDefaultValues(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The provided object is null.");
        }

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (field.get(obj) == null) {
                    assignDefaultValue(field, obj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void assignDefaultValue(Field field, Object obj) throws IllegalAccessException {
        Class<?> type = field.getType();

        if (type.isPrimitive()) {
            if (type == boolean.class) {
                field.setBoolean(obj, false);
            } else if (type == char.class) {
                field.setChar(obj, '\u0000');
            } else if (type == byte.class) {
                field.setByte(obj, (byte) 0);
            } else if (type == short.class) {
                field.setShort(obj, (short) 0);
            } else if (type == int.class) {
                field.setInt(obj, 0);
            } else if (type == long.class) {
                field.setLong(obj, 0L);
            } else if (type == float.class) {
                field.setFloat(obj, 0.0f);
            } else if (type == double.class) {
                field.setDouble(obj, 0.0d);
            }
        } else if (type == String.class) {
            // Default value for String
            field.set(obj, "");
        } else if (type == BigInteger.class) {
            field.set(obj, BigInteger.ZERO);
        } else if (type == BigDecimal.class) {
            field.set(obj, BigDecimal.ZERO);
        }
    }
}
