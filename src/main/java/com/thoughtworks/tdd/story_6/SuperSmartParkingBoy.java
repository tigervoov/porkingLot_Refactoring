package com.thoughtworks.tdd.story_6;



import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends Boy{


    public SuperSmartParkingBoy(String name) {
        super(name);
    }

    public String park(List<ParkingLot> parkingLotList, Car car){
        if (car == null) {
            return "No car to park";
        } if(car.getPark() == true){
            return "The car is parked.";
        }else{
            ParkingLot largerAvailableRateParkingLot = getLargerAvailableRateParkingLot(parkingLotList);

            if (largerAvailableRateParkingLot == null) {
                return "Not enough position.";
            }
            else {
                car.setPark(true);
                Ticket ticket = largerAvailableRateParkingLot.addTheCarToParkingLot(car.getCarNum());
                if (ticket != null) {
                    return String.format("Park success in %d parkingLot.",ticket.getParkingLot().getParkingLotNumber());
                } else {
                    return "Park failed.";
                }

            }
        }
    }
    public String fetchCar(Ticket ticket) {
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


    public ParkingLot getLargerAvailableRateParkingLot(List<ParkingLot> parkingLotList) {
        List<ParkingLot> usefulParkingLotList = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0).collect(Collectors.toList());
        if (usefulParkingLotList.size() != 0) {
            List<Double> availableRateList = usefulParkingLotList.stream()
                    .map(item -> (double) item.getEmptyCapacity() / (double) item.getCapacity()).collect(Collectors.toList());
            int LargerAvailableRateParkingLotIndex = availableRateList.indexOf(Collections.max(availableRateList));//找到最大使用率的停车场下标
            return usefulParkingLotList.get(LargerAvailableRateParkingLotIndex);
        } else {
            return null;
        }

    }

}
