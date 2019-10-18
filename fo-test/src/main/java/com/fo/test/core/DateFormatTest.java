package com.fo.test.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

    public static void main(String[] args) {
        String dateStr = "2019-01-01 11:12:13.010";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/dd HH-SSS");
        try {
            Date parse = simpleDateFormat.parse(dateStr);
            String format = simpleDateFormat2.format(parse);
            System.out.println(format);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
