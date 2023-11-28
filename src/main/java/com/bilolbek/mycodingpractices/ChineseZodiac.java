package com.bilolbek.mycodingpractices;

import java.time.Year;

public class ChineseZodiac {

    private int zodiacYear;

    public ChineseZodiac(){
        this.zodiacYear= Year.now().getValue();
    }

    public int getZodiacYear() {
        return zodiacYear;
    }

    public void setZodiacYear(int zodiacYear) {
        this.zodiacYear = zodiacYear;
    }

    @Override
    public String toString() {
        return "ChineseZodiac{" +
                "zodiacYear=" + zodiacYear +
                '}';
    }

    public String showZodiac(){
        return switch (zodiacYear % 12) {
            case 0 -> "monkey";
            case 1 -> "rooster";
            case 3 -> "pig";
            case 2 -> "dog";
            case 4 -> "rat";
            case 5 -> "ox";
            case 6 -> "tiger";
            case 7 -> "rabbit";
            case 8 -> "dragon";
            case 9 -> "snake";
            case 10 -> "horse";
            case 11 -> "sheep";
            default -> "";
        };
    }
}
