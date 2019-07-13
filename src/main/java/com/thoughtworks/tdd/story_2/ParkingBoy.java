package com.thoughtworks.tdd.story_2;




import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    public String park(ParkingLot parkingLot,Car car) {
        if (car == null) {
            return "No car to park";
        } else {
            if (parkingLot.getCapacity() == 0) {
                return "Not enough position.";
            }
            if (car.getPark() == true) {
                return "The car is parked.";
            } else {
                car.setPark(true);
                Ticket ticket = parkingLot.addTheCarToPakingLot(car.getCarNum());
                if (ticket != null) {
                    return "Park success.";
                }else {
                    return "Park failed.";
                }

            }
        }
    }
    public String fetchCar(ParkingLot parkingLot,Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        } else {
            if (ticket.getVaild()) {
                String carNum = ticket.getTicketNum();
                List<String> carNumList = parkingLot.getCarNumList();
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
}
