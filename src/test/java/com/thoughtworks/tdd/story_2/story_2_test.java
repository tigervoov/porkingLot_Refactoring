//60min/
package com.thoughtworks.tdd.story_2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;




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
    public void should_failed_when_pass_null_car_to_parking_boy() {
        //given
        Ticket ticket=null;
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when
        String returnInfo=parkingBoy.fetchCar(parkingLot,ticket);

        //then

        Assertions.assertEquals("Please provide your parking ticket.",returnInfo);


    }


}
