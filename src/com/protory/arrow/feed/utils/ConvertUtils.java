package com.protory.arrow.feed.utils;

import java.text.DateFormat;
import java.util.Date;

public class ConvertUtils {

    public static long asLong(Object value) {
        return asLong(value, 0);
    }

    public static long asLong(Object value, long defaultValue) {
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof Integer) {
            return ((Integer) value).longValue();
        } else if (value instanceof String) {
            return Long.valueOf((String) value);
        }
        return defaultValue;
    }

    public static String toString(Date date, int style) {
        return DateFormat.getDateInstance(style).format(date);
    }
}
