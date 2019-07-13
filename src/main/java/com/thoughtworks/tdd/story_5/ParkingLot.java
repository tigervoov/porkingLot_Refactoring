package com.thoughtworks.tdd.story_5;


import java.util.List;

public class ParkingLot {
    private List<String> carNumList;
    private int capacity;
    private int emptyCapacity;
    private int parkingLotNumber;
    public List<String> getCarNumList() {
        return carNumList;
    }

    public ParkingLot(List<String> carNumList,int capacity,int parkingLotNumber) {
        this.carNumList = carNumList;
        this.capacity=capacity;
        this.parkingLotNumber=parkingLotNumber;
        this.emptyCapacity=capacity;
    }

    public void setCarNumList(List<String> carNumList) {
        this.carNumList = carNumList;
    }
    public Ticket addTheCarToParkingLot(String carNum){
        if(emptyCapacity!=0){
            carNumList.add(carNum);
            return new Ticket(carNum,this.parkingLotNumber);
        }else {
            return null;
        }

    }

    public int getEmptyCapacity() {
        return emptyCapacity;
    }

    public void setEmptyCapacity(int emptyCapacity) {
        this.emptyCapacity = emptyCapacity;
    }

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(int parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
