package org.example.utility.common;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateUtil o = new DateUtil();

    public DateUtil() {
    }

    public static DateUtil get() {
        return o;
    }

    public String localDateToStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String localTimeToStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("HHmmss"));
    }

    public String localDateTimeToStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public LocalTime strToLocalTime(String strTime){
        return LocalTime.parse(strTime,DateTimeFormatter.ofPattern("HHmmss"));
    }

    public LocalDateTime strToLocalDateTime(String strDate) {
        return LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
