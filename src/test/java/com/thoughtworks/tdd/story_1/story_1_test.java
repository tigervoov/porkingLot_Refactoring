//60min/120min
package com.thoughtworks.tdd.story_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class story_1_test {
    @Test
    public void should_get_a_ticket_when_park_a_car() {
        //given
        Car car = new Car("123");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);

        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_a_car_when_give_a_ticket() {
        //given
        Ticket ticket = new Ticket("1234");
        ParkingBoy parkingBoy=new ParkingBoy();
        List<String> carNumList=new ArrayList<>();
        carNumList.add("1234");
        ParkingLot parkingLot=new ParkingLot(carNumList);

        //when
        Car car = parkingBoy.fetchCar(parkingLot,ticket);

        //then
        Assertions.assertNotNull(car);
    }
    @Test
    public void should_failed_when_pass_null_car_to_parking_boy() {
        //given
        Car car = null;
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when+then
        Assertions.assertThrows(RuntimeException.class,()->parkingBoy.park(parkingLot,car));


    }
    @Test
    public void should_fetch_failed_when_give_a_wrong_ticket_to_parking_boy() {
        //given

        Ticket falseTicket=new Ticket("2222");
        Car car=new Car("1111");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        Ticket correctTicket=parkingBoy.park(parkingLot,car);
        //when
        Car fetchCar=parkingBoy.fetchCar(parkingLot,falseTicket);
        //then
        Assertions.assertNull(fetchCar);
    }
    @Test
    public void should_fetch_failed_when_give_a_invalid_ticket_to_parking_boy() {
        //given
        Ticket ticket=new Ticket("2222");
        ticket.setVaild(false);
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        //when
        Car fetchCar =parkingBoy.fetchCar(parkingLot,ticket);
        //then
        Assertions.assertNull(fetchCar);
    }
    @Test
    public void should_park_failed_when_parking_lot_is_no_position() {
        //given
        Car car=new Car("888");
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());
        parkingLot.setCapacity(0);
        //when
        Ticket ticket =parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNull(ticket);
    }
    @Test
    public void should_park_failed_when_car_is_parked() {
        //given
        Car car=new Car("888");
        car.setPark(true);
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot parkingLot=new ParkingLot(new ArrayList<>());

        //when
        Ticket ticket =parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNull(ticket);
    }

}
