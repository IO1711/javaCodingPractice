package com.bilolbek.mycodingpractices;

public class GuessBirthday {

    private int set1Result;
    private int set2Result;
    private int set3Result;
    private int set4Result;
    private int set5Result;

    public GuessBirthday(){

    }

    public int getSet1Result() {
        return set1Result;
    }

    public void setSet1Result(int set1Result) {
        this.set1Result = set1Result;
    }

    public int getSet2Result() {
        return set2Result;
    }

    public void setSet2Result(int set2Result) {
        this.set2Result = set2Result;
    }

    public int getSet3Result() {
        return set3Result;
    }

    public void setSet3Result(int set3Result) {
        this.set3Result = set3Result;
    }

    public int getSet4Result() {
        return set4Result;
    }

    public void setSet4Result(int set4Result) {
        this.set4Result = set4Result;
    }

    public int getSet5Result() {
        return set5Result;
    }

    public void setSet5Result(int set5Result) {
        this.set5Result = set5Result;
    }

    @Override
    public String toString() {
        return "GuessBirthday{" +
                "set1Result=" + set1Result +
                ", set2Result=" + set2Result +
                ", set3Result=" + set3Result +
                ", set4Result=" + set4Result +
                ", set5Result=" + set5Result +
                '}';
    }

    public String getSet1() {
        String set1 =
                " 1 3 5 7\n" +
                        " 9 11 13 15\n" +
                        "17 19 21 23\n" +
                        "25 27 29 ";
        return set1;
    }

    public String getSet2() {
        String set2 =
                " 2 3 6 7\n" +

                        "10 11 14 15\n" +
                        "18 19 22 23\n" +
                        "26 27 30 31";
        return set2;
    }

    public String getSet3() {
        String set3 =
                " 4 5 6 7\n" +
                        "12 13 14 15\n" +
                        "20 21 22 23\n" +
                        "28 29 30 31";
        return set3;
    }

    public String getSet4() {
        String set4 =
                " 8 9 10 11\n" +
                        "12 13 14 15\n" +
                        "24 25 26 27\n" +
                        "28 29 30 31";
        return set4;
    }

    public String getSet5() {
        String set5 =
                "16 17 18 19\n" +
                        "20 21 22 23\n" +
                        "24 25 26 27\n" +
                        "28 29 30 31";
        return set5;
    }

    public int showResult(){
        int day=0;

        if(set1Result==1)
            day+=1;

        if(set2Result==1)
            day+=2;

        if(set3Result==1)
            day+=4;

        if(set4Result==1)
            day+=8;

        if(set5Result==1)
            day+=16;

        return day;
    }
}
