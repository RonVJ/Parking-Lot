package models;

import java.util.Date;

public class Ticket extends BaseModel{
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private Vehicle vehicle;
    private Date entryTime;
    private Operator ticketIssuer;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Operator getTicketIssuer() {
        return ticketIssuer;
    }

    public void setTicketIssuer(Operator ticketIssuer) {
        this.ticketIssuer = ticketIssuer;
    }
}
