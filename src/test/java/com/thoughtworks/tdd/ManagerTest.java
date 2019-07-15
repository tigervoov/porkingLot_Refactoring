package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ManagerTest {
    @Test
    public void Manager_add_a_ParkingBoy_and_order_him_to_park_a_car_into_the_parkingLot() {
        //given
        Car car = new Car("888");

        ParkingBoy parkingBoy =new ParkingBoy("小朱");
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        Manager manager=new Manager(parkingLot);
        manager.addABoyToParkingLot(parkingBoy);
        //when
        String returnInfo=manager.orderBoyToParkACar(parkingBoy,car);
        //then
        Assertions.assertEquals("Park success in 1 parkingLot.", returnInfo);
    }
    @Test
    public void Manager__park_a_car_into_the_parkingLot() {
        //given
        Car car = new Car("888");

        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        Manager manager=new Manager(parkingLot);

        //when
        String returnInfo=manager.park(car);
        //then
        Assertions.assertEquals("Park success.", returnInfo);
    }
    @Test
    public void Manager_fetch_a_car_from_his_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        Manager manager=new Manager(parkingLot);
        Car car=new Car("888");
        manager.park(car);//先存入该车

        Ticket ticket=new Ticket("888",parkingLot);

        //when
        String returnInfo=manager.fetchCar(ticket);
        //then
        Assertions.assertEquals("Return your car.", returnInfo);
    }
}
