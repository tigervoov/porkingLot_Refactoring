//  50min/60min
package com.thoughtworks.tdd.story_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class story_4_test {
    @Test
    public void should_get_a_error_message_when_give_wrong_ticket_to_parkingBoy() {
        //given
        Ticket ticket = new Ticket("888");
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>());
        //when
        String returnInfo = parkingBoy.fetchCar(parkingLot, ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_give_null_ticket_to_parkingBoy() {
        //given
        Ticket ticket = null;
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>());
        //when
        String returnInfo = parkingBoy.fetchCar(parkingLot, ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.", returnInfo);

    }

    @Test
    public void should_get_a_success_message_when_give_right_ticket_to_parkingBoy() {
        //given
        Ticket ticket = new Ticket("888");
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        List<String> carNumList = new ArrayList<>();
        carNumList.add("888");//向停车场添加这辆车
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>());

        //when
        String returnInfo = parkingBoy.fetchCar(parkingLot, ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.", returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_parkingBoy_park_a_car_into_a_no_position_parkingLot() {
        //given
        Car car = new Car("888");
        SmartParkingBoy parkingBoy = new SmartParkingBoy();

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始化停车场列表
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>());
        parkingLot.setCapacity(0);
        parkingLotList.add(parkingLot);
        //when
        String returnInfo = parkingBoy.park(parkingLotList, car);
        //then
        Assertions.assertEquals("Not enough position.", returnInfo);

    }

    @Test
    public void should_get_a_success_message_when_parkingBoy_park_a_car_into_a_have_position_parkingLot() {
        //given
        Car car = new Car("888");
        SmartParkingBoy parkingBoy = new SmartParkingBoy();

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始化停车场列表
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>());
        parkingLotList.add(parkingLot);
        //when
        String returnInfo = parkingBoy.park(parkingLotList, car);
        //then
        Assertions.assertEquals("Park success.", returnInfo);

    }

    @Test
    public void parkingBoy_should_park_a_car_into_the_second_parkingLot_when_the_first_parkingLot_is_full() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>());
        firstParkingLot.setCapacity(0);//设置第一个停车场没有容量了

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>());
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        //when
        String returnInfo = parkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success.", returnInfo);
    }
    @Test
    public void parkingBoy_should_park_a_car_into_the_max_capacity_parkingLot() {
        //given
        Car car = new Car("888");

        List<ParkingLot> parkingLotList = new ArrayList<>();//初始停车场列表

        ParkingLot firstParkingLot = new ParkingLot(new ArrayList<>());
        firstParkingLot.setCapacity(1);//设置第一个停车场容量只有1

        ParkingLot secondParkingLot = new ParkingLot(new ArrayList<>());//初始的停车场容量为10
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);

        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        //when
        String returnInfo = parkingBoy.park(parkingLotList, car);

        //then
        Assertions.assertEquals("Park success.", returnInfo);
    }


}
