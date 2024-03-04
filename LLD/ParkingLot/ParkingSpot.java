package LLD.ParkingLot;

public class ParkingSpot {
    int id;
    ParkingSpotType parkingSpotType;

    public ParkingSpot(int id, ParkingSpotType parkingSpotType) {
        this.id=id;
        this.parkingSpotType=parkingSpotType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
