package com.thoughtworks.tdd;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(String name) {
        super(name);
    }

    public String park(List<ParkingLot> parkingLotList, Car car) {
        if (car == null) {
            return "No car to park";
        } else {
            ParkingLot maxCapacityParkingLot = getMaxCapacityParkingLot(parkingLotList);

            if (maxCapacityParkingLot==null) {
                return "Not enough position.";
            }
            if (car.getPark() == true) {
                return "The car is parked.";
            } else {
                car.setPark(true);
                Ticket ticket = maxCapacityParkingLot.addTheCarToParkingLot(car.getCarNumber());
                return ticket != null ?
                        String.format("Park success in %d parkingLot.", ticket.getParkingLot().getParkingLotNumber())
                        : "Park failed.";

            }
        }
    }

//    public String fetchCar( Ticket ticket) {
//        if (ticket == null) {
//            return "Please provide your parking ticket.";
//        } else {
//            if (ticket.getValid()) {
//                String carNum = ticket.getTicketNum();
//                List<String> carNumList = ticket.getParkingLot().getCarNumList();
//                long existCarNum = carNumList.stream().filter(item -> item == carNum).collect(Collectors.counting());
//                return existCarNum > 0 ? "Return your car." : "Unrecognized parking ticket.";
//            }
//            return "Unrecognized parking ticket.";
//        }
//    }

    public ParkingLot getMaxCapacityParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().max(Comparator.comparingInt(ParkingLot::getEmptyCapacity)).get();

    }

}
