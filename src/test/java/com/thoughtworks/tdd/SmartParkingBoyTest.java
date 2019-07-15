package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    public void SmartParkingBoy_should_park_a_car_into_the_biggest_empty_position_parkingLot() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>(),10,1);

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>(),10,2);
        secondParkingLot.setEmptyCapacity(7);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("小张");
        //when
        String returnInfo = smartParkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 1 parkingLot.", returnInfo);
    }
    @Test
    public void SmartParkingBoy_should_park_a_car_into_the_second_parkingLot_when_the_first_parkingLot_is_full() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>(),10,1);
        firstParkingLot.setEmptyCapacity(0);

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>(),10,2);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("小张");
        //when
        String returnInfo = smartParkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 2 parkingLot.", returnInfo);
    }
}
