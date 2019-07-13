package com.thoughtworks.tdd.story_1;

public class Ticket {
    private String ticketNum;

    public Ticket(String carNum) {
        this.ticketNum = carNum;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }


}
