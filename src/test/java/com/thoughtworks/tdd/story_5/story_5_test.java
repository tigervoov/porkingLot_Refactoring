//  50min/60min
package com.thoughtworks.tdd.story_5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class story_5_test {
    @Test
    public void should_get_a_error_message_when_give_wrong_ticket_to_parkingBoy() {
        //given
        Ticket ticket = new Ticket("888",1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        //when
        String returnInfo = superSmartParkingBoy.fetchCar(parkingLot, ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_give_null_ticket_to_parkingBoy() {
        //given
        Ticket ticket = null;
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        //when
        String returnInfo = superSmartParkingBoy.fetchCar(parkingLot, ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.", returnInfo);

    }

    @Test
    public void should_get_a_success_message_when_give_right_ticket_to_parkingBoy() {
        //given
        Ticket ticket = new Ticket("888",1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<String> carNumList = new ArrayList<>();
        carNumList.add("888");//向停车场添加这辆车
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);

        //when
        String returnInfo = superSmartParkingBoy.fetchCar(parkingLot, ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_parkingBoy_park_a_car_into_a_no_position_parkingLot() {
        //given
        Car car = new Car("888");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始化停车场列表
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        parkingLot.setCapacity(0);
        parkingLotList.add(parkingLot);
        //when
        String returnInfo = superSmartParkingBoy.superSmartPark(parkingLotList, car);
        //then
        Assertions.assertEquals("Not enough position.", returnInfo);

    }

    @Test
    public void should_get_a_success_message_when_parkingBoy_park_a_car_into_a_have_position_parkingLot() {
        //given
        Car car = new Car("888");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始化停车场列表
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        parkingLotList.add(parkingLot);
        //when
        String returnInfo = superSmartParkingBoy.superSmartPark(parkingLotList, car);
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

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        //when
        String returnInfo = superSmartParkingBoy.superSmartPark(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 2 parkingLot.", returnInfo);
    }
    @Test
    public void SmartParkingBoy_should_park_a_car_into_the_larger_Rate_ParkingLot() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>(),10,1);
        firstParkingLot.setEmptyCapacity(5);//设置第一个停车场空位置只有5个

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>(),12,2);//初始的停车场容量为10
        secondParkingLot.setEmptyCapacity(7);//设置第一个停车场空位置只有7个
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        //when
        String returnInfo = superSmartParkingBoy.superSmartPark(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 2 parkingLot.", returnInfo);
    }



}
