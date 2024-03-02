package LLD.ObserverDesignPattern.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkingLotObservable{
    List<ParkingLotObserver> parkingLotObserverList;
    int totalSpots;
    int availableSpots;

    ParkingLot(int totalSpots){
        parkingLotObserverList=new ArrayList<>();
        this.totalSpots=totalSpots;
        this.availableSpots=totalSpots;
    }

    void carEnters(){
        if(availableSpots>0){
            availableSpots--;
            notifyObservers();
        }else
            System.out.println("Parking Lot is Full");
    }

    void carExits(){
        if(availableSpots<totalSpots) {
            availableSpots++;
            notifyObservers();
        }
    }
    @Override
    public void registerObserver(ParkingLotObserver parkingLotObserver) {
        parkingLotObserverList.add(parkingLotObserver);
    }

    @Override
    public void removeObserver(ParkingLotObserver parkingLotObserver) {
        parkingLotObserverList.add(parkingLotObserver);
    }

    @Override
    public void notifyObservers() {
        for(ParkingLotObserver parkingLotObserver:parkingLotObserverList)
            parkingLotObserver.update(availableSpots);
    }
}
