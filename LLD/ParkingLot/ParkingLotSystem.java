package LLD.ParkingLot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotSystem {
    private static ParkingLotSystem parkingLotSystem;
    private List<ParkingFloor> floors;
    int currentOccupancy;

    // Private constructor to prevent instantiation from outside
    private ParkingLotSystem(){
        this.currentOccupancy=0;
        this.floors=new ArrayList<>();//initialise parking lot floors
    }

    public static ParkingLotSystem getInstance(){
        if(parkingLotSystem==null){
            synchronized (ParkingLotSystem.class){
                if(parkingLotSystem==null){
                    parkingLotSystem=new ParkingLotSystem();
                }
            }
        }
        return parkingLotSystem;
    }

    public void initialiseFloor(int id,int totalSpotsCompact, int totalSpotsLarge, int totalSpotsHandicapped){
        this.floors.add(new ParkingFloor(id,totalSpotsCompact,totalSpotsLarge,totalSpotsHandicapped));
    }
    public int getTotalCapacity() {
        int totalCapacity=0;
        for(ParkingFloor floor: floors){
            totalCapacity += floor.getParkingSpotCount(floor);
        }
        return totalCapacity;
    }

    public ParkingTicket issueParkingTicket(ParkingSpotType parkingSpotType) {
        if (currentOccupancy < getTotalCapacity()) {
            currentOccupancy++;
            return new ParkingTicket("Ticket-"+currentOccupancy, LocalDateTime.now(),"Default",parkingSpotType);
        } else {
            System.out.println("Parking lot is full. Cannot issue parking ticket.");
            return null;
        }
    }

    void entry(){
        ++this.currentOccupancy;
    }

    void exit(){
        --this.currentOccupancy;
    }

    public double calculateParkingFee(ParkingSpotType parkingSpotType, int hrs){

        return 0;
    }
}
