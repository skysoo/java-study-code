package org.example.codingtest.oneLevel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TwoThousandSixteen {
    public static void main(String[] args) throws ParseException {
        int a = 5;
        int b = 24;
        solution(a,b);
    }

    public static String solution(int a, int b) throws ParseException {
        String month = String.valueOf(a);
        String date = String.valueOf(b);

        if (month.length()!=2) month = "0"+month;
        if (date.length()!=2) date = "0"+date;

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date data = dateFormat.parse(2016+month+date);

        String s = String.valueOf(data);
        String substring = s.substring(0, s.indexOf(" "));

        return substring.toUpperCase();
    }
}
