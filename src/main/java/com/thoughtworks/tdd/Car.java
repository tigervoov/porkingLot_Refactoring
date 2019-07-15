package com.thoughtworks.tdd;

public class Car {
    private String carNumber;
    private Boolean isPark;
    public Car(String carNumber) {
        this.carNumber = carNumber;
        this.isPark=false;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Boolean getPark() {
        return isPark;
    }

    public void setPark(Boolean park) {
        isPark = park;
    }
}
