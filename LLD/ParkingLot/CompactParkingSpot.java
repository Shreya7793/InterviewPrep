package LLD.ParkingLot;

public class CompactParkingSpot implements ParkingSpotFactory{

    @Override
    public ParkingSpot createParkingSpot(int id) {
        return new ParkingSpot(id,ParkingSpotType.COMPACT);
    }
    @Override
    public ParkingSpotType getParkingSpotType(){
        return ParkingSpotType.COMPACT;
    }

}
