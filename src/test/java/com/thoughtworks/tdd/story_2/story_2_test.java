//60min/50min
package com.thoughtworks.tdd.story_2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class story_2_test {

    @Test
    public void should_get_a_error_message_when_give_wrong_ticket_to_parkingBoy() {
        //given
        Ticket ticket=new Ticket("888");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when
        String returnInfo=parkingBoy.fetchCar(parkingLot,ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.",returnInfo);
    }

    @Test
    public void should_get_a_error_message_when_give_null_ticket_to_parkingBoy() {
        //given
        Ticket ticket=null;
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when
        String returnInfo=parkingBoy.fetchCar(parkingLot,ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.",returnInfo);

    }
    @Test
    public void should_get_a_success_message_when_give_right_ticket_to_parkingBoy() {
        //given
        Ticket ticket=new Ticket("888");
        ParkingBoy parkingBoy=new ParkingBoy();
        List<String> carNumList=new ArrayList<>();
        carNumList.add("888");//向停车场添加这辆车
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());

        //when
        String returnInfo=parkingBoy.fetchCar(parkingLot,ticket);

        //then

        Assertions.assertEquals("Unrecognized parking ticket.",returnInfo);
    }
    @Test
    public void should_get_a_error_message_when_parkingBoy_park_a_car_into_a_no_position_parkingLot(){
        //given
        Car car=new Car("888");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        parkingLot.setCapacity(0);
        //when
        String returnInfo=parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertEquals("Not enough position.",returnInfo);

    }
    @Test
    public void should_get_a_error_message_when_parkingBoy_park_a_car_into_a_have_position_parkingLot(){
        //given
        Car car=new Car("888");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        parkingLot.setCapacity(1);
        //when
        String returnInfo=parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertEquals("Park success.",returnInfo);

    }


}
