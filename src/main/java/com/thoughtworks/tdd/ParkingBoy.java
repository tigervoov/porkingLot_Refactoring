package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;


public abstract class ParkingBoy {
    private String name;
    private List<ParkingLot> belongToParkingLotList;

    public abstract String park(List<ParkingLot> parkingLotList, Car car);
    public abstract String fetchCar(Ticket ticket);

    public ParkingBoy(String name) {
        this.name = name;
        this.belongToParkingLotList=new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingBoy parkingBoy = (ParkingBoy) o;
        return name.equals(parkingBoy.name);
    }


    public List<ParkingLot> getBelongToParkingLotList() {
        return belongToParkingLotList;
    }

    public void setBelongToParkingLotList(List<ParkingLot> belongToParkingLotList) {
        this.belongToParkingLotList = belongToParkingLotList;
    }
}
