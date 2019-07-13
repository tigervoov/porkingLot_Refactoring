package com.thoughtworks.tdd.story_1;

import java.util.List;

public class ParkingLot {
    private List<String> carNumList;

    public List<String> getCarNumList() {
        return carNumList;
    }

    public ParkingLot(List<String> carNumList) {
        this.carNumList = carNumList;
    }

    public void setCarNumList(List<String> carNumList) {
        this.carNumList = carNumList;
    }
    public Ticket addTheCarToPakingLot(String carNum){
        carNumList.add(carNum);
        return new Ticket(carNum);
    }
}
