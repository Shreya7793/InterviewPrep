package LLD.ObserverDesignPattern.ParkingLot;

public class ParkingDisplay implements ParkingLotObserver{
    @Override
    public void update(int availableSpots) {
        System.out.println("Parking Display - Available Spots: " + availableSpots);
    }
}
