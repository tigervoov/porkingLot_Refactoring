package com.thoughtworks.tdd.story_3;


import java.util.List;

public class ParkingLot {
    private List<String> carNumList;
    private int capacity;
    public List<String> getCarNumList() {
        return carNumList;
    }

    public ParkingLot(List<String> carNumList) {
        this.carNumList = carNumList;
        this.capacity=10;
    }

    public void setCarNumList(List<String> carNumList) {
        this.carNumList = carNumList;
    }
    public Ticket addTheCarToPakingLot(String carNum){
        carNumList.add(carNum);
        return new Ticket(carNum);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
