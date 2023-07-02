package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private Ticket ticket;
    private Date exitTime;
    private Gate exitGate;
    private Operator billIssuer;
    private Long amount;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getBillIssuer() {
        return billIssuer;
    }

    public void setBillIssuer(Operator billIssuer) {
        this.billIssuer = billIssuer;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
