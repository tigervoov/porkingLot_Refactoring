package com.thoughtworks.tdd.story_6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {

    private ParkingLot manageParkingLot;
    private List<Boy> manageBoyList;

    public Manager(ParkingLot manageParkingLot) {
        this.manageParkingLot = manageParkingLot;
        this.manageBoyList = new ArrayList<>();

    }

    public ParkingLot getManageParkingLot() {
        return manageParkingLot;
    }

    public void setManageParkingLot(ParkingLot manageParkingLot) {
        this.manageParkingLot = manageParkingLot;
    }

    public String park(Car car) {
        if (car == null) {
            return "No car to park";
        } else if (car.getPark() == true) {
            return "The car is parked.";
        } else if (this.manageParkingLot.getEmptyCapacity() == 0) {
            return "Not enough position.";
        } else {
            car.setPark(true);
            Ticket ticket = this.manageParkingLot.addTheCarToParkingLot(car.getCarNum());
            if (ticket != null) {
                return "Park success.";
            } else {
                return "Park failed.";
            }
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
                if (existCarNum > 0) {
                    return "Return your car.";
                } else {
                    return "Unrecognized parking ticket.";
                }
            }
            return "Unrecognized parking ticket.";
        }
    }


    //管理停车男孩
    public void addABoyToParkingLot(Boy boy) {
        if(boy!=null){
            manageBoyList.add(boy);
            boy.getBelongToParkingLotList().add(this.manageParkingLot);
        }

    }

    public void deleteABoyToParkingLot(Boy boy) {
        manageBoyList.remove(boy);
    }

    public String orderBoyToParkACar(Boy boy, Car car) {
        if (manageBoyList.indexOf(boy) != -1) {
            List<ParkingLot> parkingLots = boy.getBelongToParkingLotList();
            return boy.park(parkingLots, car);
        }
        return "The Boy is not belong to you,you can't oder him";
    }

    public String orderBoyToFetchACar(Boy boy, Ticket ticket) {
        if (manageBoyList.indexOf(boy) != 0) {
            List<ParkingLot> parkingLots = boy.getBelongToParkingLotList();
            return boy.fetchCar(ticket);
        }
        return "The Boy is not belong to you,you can't oder him";
    }


}
