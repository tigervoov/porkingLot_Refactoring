package com.thoughtworks.tdd.story_5;

public class Ticket {
    private String ticketNum;
    private Boolean isValid;
    private int parkingLotNumber;

    public Ticket(String carNum,int parkingLotNumber) {
        this.ticketNum = carNum;
        this.parkingLotNumber=parkingLotNumber;
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

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(int parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }
}
