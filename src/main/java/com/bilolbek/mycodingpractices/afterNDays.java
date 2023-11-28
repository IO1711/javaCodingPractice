package com.bilolbek.mycodingpractices;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class afterNDays {

    private int id;
    private int nDays;

    private int nDays2;
    private String weekDay;

    private String result;

    public afterNDays() {
        this.nDays = 0;
        this.nDays2 = 0;
        this.weekDay = "NotSet";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnDays() {
        return nDays;
    }

    public void setnDays(int nDays) {
        this.nDays = nDays;
    }

    public int getnDays2() {
        return nDays2;
    }

    public void setnDays2(int nDays2) {
        this.nDays2 = nDays2;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "afterNDays{" +
                "id=" + id +
                ", nDays=" + nDays +
                ", nDays2=" + nDays2 +
                ", weekDay='" + weekDay + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String includingToday(){
        int remainingDay;
        String[] allWeekDays=new String[7];
        allWeekDays[0]="Monday"; allWeekDays[1]="Tuesday"; allWeekDays[2]="Wednesday"; allWeekDays[3]="Thursday"; allWeekDays[4]="Friday"; allWeekDays[5]="Saturday"; allWeekDays[6]="Sunday";
        int i;
        for(i=0; !Objects.equals(allWeekDays[i], weekDay); i++){
        }
        remainingDay=7-(i+1);
        if(remainingDay>=nDays){
            return allWeekDays[((i+1)+nDays)-1];
        }
        return allWeekDays[((nDays-remainingDay)%7)-1];
    }

    public String notIncludingToday(){
        int remainingDay;
        String[] allWeekDays=new String[7];
        allWeekDays[0]="Monday"; allWeekDays[1]="Tuesday"; allWeekDays[2]="Wednesday"; allWeekDays[3]="Thursday"; allWeekDays[4]="Friday"; allWeekDays[5]="Saturday"; allWeekDays[6]="Sunday";
        int i;
        for(i=0; !Objects.equals(allWeekDays[i], weekDay); i++){
        }
        remainingDay=7-(i+1);
        if(remainingDay>nDays){
            return allWeekDays[(i+1)+nDays];
        }
        return allWeekDays[(nDays-remainingDay)%7];
    }

    public String fromToday(){
        LocalDate today=LocalDate.now();
        DayOfWeek dayOfWeek=today.getDayOfWeek();
        int dayOfWeekValue=dayOfWeek.getValue();
        int remainingDay;
        String[] allWeekDays=new String[7];
        allWeekDays[0]="MONDAY"; allWeekDays[1]="TUESDAY"; allWeekDays[2]="WEDNESDAY"; allWeekDays[3]="THURSDAY"; allWeekDays[4]="FRIDAY"; allWeekDays[5]="SATURDAY"; allWeekDays[6]="SUNDAY";
        int i;
        for(i=0; !Objects.equals(i+1,dayOfWeekValue ); i++){
        }
        remainingDay=7-(i+1);
        if(remainingDay>nDays2){
            return allWeekDays[(i+1)+nDays2];
        }
        return allWeekDays[(nDays2-remainingDay)%7];

    }


}
