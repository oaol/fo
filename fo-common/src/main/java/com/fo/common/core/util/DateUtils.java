package com.fo.common.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fo.common.core.constant.WeekEnum;

/**
 * 
 * date utils
 * @author bryce
 * @Date Mar 10, 2019
 */
public class DateUtils {

    /**
     * 
     * get week
     * @param date
     * @return
     */
    public static WeekEnum getWeek(Date date) {
        WeekEnum week = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (weekNumber) {
        case 0:
            week = WeekEnum.SUNDAY;
            break;
        case 1:
            week = WeekEnum.MONDAY;
            break;
        case 2:
            week = WeekEnum.TUESDAY;
            break;
        case 3:
            week = WeekEnum.WEDNESDAY;
            break;
        case 4:
            week = WeekEnum.THURSDAY;
            break;
        case 5:
            week = WeekEnum.FRIDAY;
            break;
        case 6:
            week = WeekEnum.SATURDAY;
            break;
        }
        return week;
    }

    public static void main(String[] args) {
//        WeekEnum week = DateUtils.getWeek(new Date());
//        System.out.println(week.getNameCn());
       List<String> newArrayList = CollectionUtils.newArrayList();
       System.out.println(newArrayList.toString());
    }

    private DateUtils() {
    }
}
