package LLD.ObserverDesignPattern.ParkingLot;

public interface ParkingLotObservable {
    void registerObserver(ParkingLotObserver parkingLotObserver);
    void removeObserver(ParkingLotObserver parkingLotObserver);
    void notifyObservers();
}
