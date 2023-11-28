package com.bilolbek.mycodingpractices;

public class LeapYear {
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "LeapYear{" +
                "year=" + year +
                '}';
    }

    public boolean isLeapYear(){
        return (year%4==0&&year%100!=0)||(year%400==0);
    }
}
