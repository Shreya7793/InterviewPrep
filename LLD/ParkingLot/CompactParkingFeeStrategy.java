package LLD.ParkingLot;

public class CompactParkingFeeStrategy implements FeeStrategy {
    @Override
    public double calculate(ParkingSpotType parkingSpotType, int hrs) {
        return hrs*0.2;
    }
}
