package com.bilolbek.mycodingpractices;

public class palindromeNumber {

    private int id;
    private int checkNumber;

    private int checkNumberSet;

    public int getId() {
        return id;
    }

    public palindromeNumber(){
        this.checkNumber=0;
        this.checkNumberSet=0;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public int getCheckNumberSet() {
        return checkNumberSet;
    }

    public void setCheckNumberSet(int checkNumberSet) {
        this.checkNumberSet = checkNumberSet;
    }

    @Override
    public String toString() {
        return "palindromeNumber{" +
                "id=" + id +
                ", checkNumber=" + checkNumber +
                ", checkNumberSet=" + checkNumberSet +
                '}';
    }

    public boolean isPalindrome(){
        int result=0, temp=checkNumber;
        while (temp%10!=temp) {
            result=(result*10)+(temp%10);
            temp/=10;
        }
        result=(result*10)+temp;
        return result == checkNumber;
    }

    public boolean isPalindromeRead(int number){
        int result=0, temp=number;
        while (temp%10!=temp) {
            result=(result*10)+(temp%10);
            temp/=10;
        }
        result=(result*10)+temp;
        return result == number;
    }
    public int[] allPalindrome(){
        DynamicArray da=new DynamicArray();
        int i=10;
        for (;i<=checkNumberSet;i++){
            if(isPalindromeRead(i))
                da.addElement(i);
        }
        return da.getArray();
    }
}
