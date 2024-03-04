package LLD.ParkingLot;

public interface FeeStrategy {
    double calculate(ParkingSpotType parkingSpotType,int hrs);
}
