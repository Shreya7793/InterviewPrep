package LLD.ParkingLot;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketID;
    private LocalDateTime entryTime;
    private String entryPoint;// this would make sense if there are mutiple ticket IDs
    private ParkingSpotType parkingSpotType;

    ParkingTicket(String ticketID, LocalDateTime entryTime, String entryPoint, ParkingSpotType parkingSpotType){
        this.ticketID=ticketID;
        this.entryTime=entryTime;
        this.entryPoint=entryPoint;
        this.parkingSpotType=parkingSpotType;
    }
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }
}
