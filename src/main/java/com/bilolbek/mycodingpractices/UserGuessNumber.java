package com.bilolbek.mycodingpractices;

import jakarta.persistence.*;

@Entity
@Table(name = "guessNumberData")
public class UserGuessNumber {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private int firstGuess;
    private int secondGuess;
    private int thirdGuess;

    private int randomNumber;

    public int getFirstGuess() {
        return firstGuess;
    }

    public void setFirstGuess(int firstGuess) {
        this.firstGuess = firstGuess;
    }

    public int getSecondGuess() {
        return secondGuess;
    }

    public void setSecondGuess(int secondGuess) {
        this.secondGuess = secondGuess;
    }

    public int getThirdGuess() {
        return thirdGuess;
    }

    public void setThirdGuess(int thirdGuess) {
        this.thirdGuess = thirdGuess;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserGuessNumber{" +
                "id=" + id +
                ", firstGuess=" + firstGuess +
                ", secondGuess=" + secondGuess +
                ", thirdGuess=" + thirdGuess +
                ", randomNumber=" + randomNumber +
                '}';
    }
}
