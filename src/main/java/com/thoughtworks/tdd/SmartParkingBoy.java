package com.thoughtworks.tdd;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends Boy {

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
                if (ticket != null) {
                    return  String.format("Park success in %d parkingLot.",ticket.getParkingLot().getParkingLotNumber());
                } else {
                    return "Park failed.";
                }

            }
        }
    }

    public String fetchCar( Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        } else {
            if (ticket.getValid()) {
                String carNum = ticket.getTicketNum();
                List<String> carNumList = ticket.getParkingLot().getCarNumList();
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

    public ParkingLot getMaxCapacityParkingLot(List<ParkingLot> parkingLotList) {
        List<ParkingLot> usefulParkingLotList = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getEmptyCapacity() != 0).collect(Collectors.toList());
        if(usefulParkingLotList.size()!=0){
            List<Integer> capacityList = usefulParkingLotList.stream()
                    .map(item -> item.getEmptyCapacity()).collect(Collectors.toList());
            int maxCapacityParkLot = Collections.max(capacityList);
            int maxCapacityParkLotIndex =capacityList.indexOf(maxCapacityParkLot);
            ParkingLot maxCapacityParkingLot = usefulParkingLotList.get(maxCapacityParkLotIndex);
            return maxCapacityParkingLot;
        }
        else {
            return null;
        }
    }

}
