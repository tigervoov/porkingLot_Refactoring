package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {

    private ParkingLot manageParkingLot;
    private List<ParkingBoy> manageParkingBoyList;

    public Manager(ParkingLot manageParkingLot) {
        this.manageParkingLot = manageParkingLot;
        this.manageParkingBoyList = new ArrayList<>();

    }


    public String park(Car car) {
        if (car == null) {
            return "No car to park";
        } else if (car.getPark()) {
            return "The car is parked.";
        } else if (this.manageParkingLot.getEmptyCapacity() == 0) {
            return "Not enough position.";
        } else {
            car.setPark(true);
            Ticket ticket = this.manageParkingLot.addTheCarToParkingLot(car.getCarNumber());
            return ticket != null ? "Park success." : "Park failed.";
        }


    }

    public String fetchCar(Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        } else {
            if (ticket.getValid()) {
                String carNum = ticket.getTicketNum();
                List<String> carNumList = this.manageParkingLot.getCarNumList();
                long existCarNum = carNumList.stream().filter(item -> item == carNum).collect(Collectors.counting());

                return existCarNum > 0 ? "Return your car." : "Unrecognized parking ticket.";
            }
            return "Unrecognized parking ticket.";
        }
    }


    //管理停车男孩
    public void addABoyToParkingLot(ParkingBoy parkingBoy) {
        if (parkingBoy != null) {
            this.manageParkingBoyList.add(parkingBoy);
            parkingBoy.getBelongToParkingLotList().add(this.manageParkingLot);
        }

    }

    public void deleteABoyToParkingLot(ParkingBoy parkingBoy) {
        manageParkingBoyList.remove(parkingBoy);
    }

    public String orderBoyToParkACar(ParkingBoy parkingBoy, Car car) {
        if (manageParkingBoyList.indexOf(parkingBoy) != -1) {
            List<ParkingLot> parkingLots = parkingBoy.getBelongToParkingLotList();
            return parkingBoy.park(parkingLots, car);
        }
        return "The Boy is not belong to you,you can't oder him";
    }

    public String orderBoyToFetchACar(ParkingBoy parkingBoy, Ticket ticket) {
        if (manageParkingBoyList.indexOf(parkingBoy) != 0) {
            List<ParkingLot> parkingLots = parkingBoy.getBelongToParkingLotList();
            return parkingBoy.fetchCar(ticket);
        }
        return "The Boy is not belong to you,you can't oder him";
    }


}
