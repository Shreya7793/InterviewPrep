package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorId;
    private Map<ParkingSpotType,List<ParkingSpot>> parkingSpotCountMap;

    ParkingFloor(int floorId, int totalSpotsCompact, int totalSpotsLarge, int totalSpotsHandicapped){
        this.floorId=floorId;
        this.parkingSpotCountMap=new HashMap<>();
        initializeParkingSpots(totalSpotsCompact, totalSpotsLarge, totalSpotsHandicapped);
    }
    //initializes parking spots for all types based on the provided total spot counts for each type.
    private void initializeParkingSpots(int totalSpotsCompact, int totalSpotsLarge, int totalSpotsHandicapped) {
        ParkingSpotFactory compactFactory = new CompactParkingSpot();
        ParkingSpotFactory largeFactory = new LargeParkingSpot();
        createParkingSpots(compactFactory, totalSpotsCompact);
        createParkingSpots(largeFactory, totalSpotsLarge);
    }
    private void createParkingSpots(ParkingSpotFactory parkingSpotFactory, int totalSpots) {
        List <ParkingSpot> parkingSpotList=new ArrayList<>();
        for(int i=1;i<=totalSpots;i++) {
            ParkingSpot parkingSpot=parkingSpotFactory.createParkingSpot(i);
            parkingSpotList.add(parkingSpot);
        }
        this.parkingSpotCountMap.put(parkingSpotFactory.getParkingSpotType(),parkingSpotList);
    }

    public int getFloorId() {
        return floorId;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getParkingSpotCountMap() {
        return parkingSpotCountMap;
    }

    int getParkingSpotCount(ParkingFloor floor){
        int totalSpotsPerFloor=0;
        for(List<ParkingSpot> parkingSpotList: floor.parkingSpotCountMap.values()){
            totalSpotsPerFloor += parkingSpotList.size();
        }
        return totalSpotsPerFloor;
    }
}
