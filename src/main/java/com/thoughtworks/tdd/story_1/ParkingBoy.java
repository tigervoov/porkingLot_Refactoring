package com.thoughtworks.tdd.story_1;


import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    public Ticket park(ParkingLot parkingLot,Car car){
        if(car==null){
            throw new RuntimeException("Error:car is null");
        }else {
            Ticket ticket=parkingLot.addTheCarToPakingLot(car.getCarNum());
            if(ticket!=null){
                return ticket;
            }
            else {
                return null;
            }
        }
    }
    public Car fetchCar(ParkingLot parkingLot,Ticket ticket){
        String carNum=ticket.getTicketNum();
        List<String> carNumList=parkingLot.getCarNumList();
        long existCarNum=carNumList.stream().filter(item->item==carNum).collect(Collectors.counting());
        if(existCarNum>0){
            return new Car(carNum);
        }
        return null;
    }
}
