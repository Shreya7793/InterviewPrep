package LLD.ParkingLot;

public interface ParkingSpotFactory {
    ParkingSpot createParkingSpot(int id);
    ParkingSpotType getParkingSpotType();
}
