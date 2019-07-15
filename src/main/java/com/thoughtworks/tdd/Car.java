package com.thoughtworks.tdd;

public class Car {
    private String carNum;
    private Boolean isPark;
    public Car(String carNum) {
        this.carNum = carNum;
        this.isPark=false;
    }

    public String getCarNum() {
        return carNum;
    }

    public Boolean getPark() {
        return isPark;
    }

    public void setPark(Boolean park) {
        isPark = park;
    }
}
