package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {

    @Test
    public void SuperSmartParkingBoy_should_park_a_car_into_the_max_capacity_parkingLot() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>(),10,1);
        firstParkingLot.setEmptyCapacity(5);//设置第一个停车场空位置只有5个

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>(),12,2);//初始的停车场容量为10
        secondParkingLot.setEmptyCapacity(7);//设置第一个停车场空位置只有7个
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SuperSmartParkingParkingBoy superSmartParkingBoy = new SuperSmartParkingParkingBoy("小李");
        //when
        String returnInfo = superSmartParkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success in 2 parkingLot.", returnInfo);
    }
    @Test
    public void should_get_a_error_message_when_give_wrong_ticket_to_SuperSmartParkingBoy() {
        //given
        ParkingBoy superSmartParkingParkingBoy = new SuperSmartParkingParkingBoy("小明");
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        Ticket ticket = new Ticket("888",parkingLot);
        //when
        String returnInfo = superSmartParkingParkingBoy.fetchCar(ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_give_null_ticket_to_SuperSmartParkingBoy() {
        //given
        Ticket ticket = null;
        ParkingBoy superSmartParkingParkingBoy = new SuperSmartParkingParkingBoy("小明");
        //when
        String returnInfo = superSmartParkingParkingBoy.fetchCar( ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.", returnInfo);

    }

    @Test
    public void should_get_a_success_message_when_give_right_ticket_to_SuperSmartParkingBoy() {
        //given
        ParkingBoy superSmartParkingParkingBoy = new SuperSmartParkingParkingBoy("小明");
        List<String> carNumList = new ArrayList<>();
        carNumList.add("888");//向停车场添加这辆车
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),10,1);
        Ticket ticket = new Ticket("888",parkingLot);
        //when
        String returnInfo = superSmartParkingParkingBoy.fetchCar(ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }
}
