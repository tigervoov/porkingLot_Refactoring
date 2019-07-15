package com.thoughtworks.tdd;


import java.util.List;
import java.util.stream.Collectors;

public class NormalParkingBoy extends ParkingBoy {

    public NormalParkingBoy(String name) {
        super(name);
    }

    public String park(List<ParkingLot> parkingLotList, Car car) {
        if (car == null) {
            return "No car to park";
        } else {
            List<ParkingLot> usefulParkingLotList = parkingLotList.stream().filter(parkingLot -> parkingLot.getCapacity() != 0).collect(Collectors.toList());
            if (usefulParkingLotList.size() == 0) {
                return "Not enough position.";
            }
            if (car.getPark() == true) {
                return "The car is parked.";
            } else {
                car.setPark(true);
                Ticket ticket = usefulParkingLotList.get(0).addTheCarToParkingLot(car.getCarNumber());
                return ticket != null ?
                        String.format("Park success in %d parkingLot.", ticket.getParkingLot().getParkingLotNumber())
                        : "Park failed.";
            }
        }
    }

//    public String fetchCar(Ticket ticket) {
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
}
