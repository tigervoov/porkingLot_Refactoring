package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public abstract class ParkingBoy {
    private String name;
    private List<ParkingLot> belongToParkingLotList;

    public abstract String park(List<ParkingLot> parkingLotList, Car car);


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
    public String fetchCar( Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        } else {
            if (ticket.getValid()) {
                String carNum = ticket.getTicketNum();
                List<String> carNumList = ticket.getParkingLot().getCarNumList();
                long existCarNum = carNumList.stream().filter(item -> item == carNum).collect(Collectors.counting());
                return existCarNum > 0 ? "Return your car." : "Unrecognized parking ticket.";
            }
            return "Unrecognized parking ticket.";
        }
    }
}
