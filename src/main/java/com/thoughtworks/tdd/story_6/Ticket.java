package com.thoughtworks.tdd.story_6;

public class Ticket {
    private String ticketNum;
    private Boolean isValid;
    private ParkingLot parkingLot;

    public Ticket(String carNum, ParkingLot parkingLot) {
        this.ticketNum = carNum;
        this.parkingLot=parkingLot;
        this.setValid(true);
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
