package com.thoughtworks.tdd.story_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class story_1_test {
    @Test
    public void should_get_a_ticket_when_park_a_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_a_car_when_give_a_ticket() {
        //given
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Car car = parkingBoy.fetchCar(ticket);

        //then
        Assertions.assertNotNull(car);
    }
    @Test
    public void should_failed_when_pass_null_car_to_parking_boy() {
        //given
        Car car = null;
        ParkingBoy parkingBoy=new ParkingBoy();
        //when+then
        Assertions.assertThrows(RuntimeException.class,()->parkingBoy.park(car));


    }

}
