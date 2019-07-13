package com.thoughtworks.tdd.story_1;



public class ParkingBoy {
    public Ticket park(Car car){
        if(car==null){
            throw new RuntimeException("Error:car is null");
        }
        return new Ticket();
    }
    public Car fetchCar(Ticket ticket){
        return new Car();
    }
}
