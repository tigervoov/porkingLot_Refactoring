package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingParkingBoyTest {
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

        SmartParkingParkingBoy smartParkingBoy = new SmartParkingParkingBoy("小张");
        //when
        String returnInfo = smartParkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 2 parkingLot.", returnInfo);
    }
}
