package com.protory.arrow.feed.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String format(Date value, String pattern) {
        return new SimpleDateFormat(pattern).format(value);
    }
}
