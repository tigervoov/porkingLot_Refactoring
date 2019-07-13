package com.thoughtworks.tdd.story_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ac1_test_cases  {
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
}
