package LLD.ParkingLot;

public class LargeParkingSpot implements ParkingSpotFactory{

    @Override
    public ParkingSpot createParkingSpot(int id) {
        return new ParkingSpot(id,ParkingSpotType.LARGE);
    }

    @Override
    public ParkingSpotType getParkingSpotType(){
        return ParkingSpotType.LARGE;
    }
}
