package com.fo.common.core.enums;

/**
 * 
 * Week enum
 * @author bryce
 * @Date Mar 10, 2019
 */
public enum WeekEnum {

    MONDAY("星期一", "Monday", "Mon.", 1),
    TUESDAY("星期二", "Tuesday", "Tues.", 2),
    WEDNESDAY("星期三", "Wednesday", "Wed.", 3),
    THURSDAY("星期四", "Thursday", "Thur.", 4),
    FRIDAY("星期五", "Friday", "Fri.", 5),
    SATURDAY("星期六", "Saturday", "Sat.", 6),
    SUNDAY("星期日", "Sunday", "Sun.", 7);

    private String nameCn;
    private String nameEn;
    private String nameEnShort;
    private int number;
    
    WeekEnum(String name_cn, String name_en, String name_enShort, int number) {
        this.nameCn = name_cn;
        this.nameEn = name_en;
        this.nameEnShort = name_enShort;
        this.number = number;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameEnShort() {
        return nameEnShort;
    }

    public void setNameEnShort(String nameEnShort) {
        this.nameEnShort = nameEnShort;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
