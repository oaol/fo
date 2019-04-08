package com.fo.test.common;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class ThisDateTest {

    public static void main(String[] args) {
        Date date2 = new Date(1L);
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(Calendar.ERA);
        System.out.println(i);
        boolean sameDay = DateUtils.isSameDay(new Date(), date2);
        System.out.println(sameDay);
    }
}
