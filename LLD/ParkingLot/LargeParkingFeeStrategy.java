package LLD.ParkingLot;

public class LargeParkingFeeStrategy implements FeeStrategy{
    @Override
    public double calculate(ParkingSpotType parkingSpotType,int hrs) {
        return hrs*0.5;
    }
}
