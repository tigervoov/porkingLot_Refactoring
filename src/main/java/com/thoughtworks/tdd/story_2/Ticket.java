package com.thoughtworks.tdd.story_2;

public class Ticket {
    private String ticketNum;
    private Boolean isVaild;

    public Ticket(String carNum) {
        this.ticketNum = carNum;
        this.setVaild(true);
    }

    public Boolean getVaild() {
        return isVaild;
    }

    public void setVaild(Boolean vaild) {
        isVaild = vaild;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }


}
