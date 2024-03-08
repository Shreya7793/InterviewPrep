package LLD.DesignPatterns.ObserverDesignPattern.ParkingLot;
/*
 In a parking lot scenario, the Observer Design Pattern can be applied.
 A sensor detects the occupancy status of parking spots and
 notifies various displays or systems about the availability of parking spots.
 */
public class Client {
    public static void main(String []args){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingDisplay parkingDisplay1=new ParkingDisplay();
        ParkingDisplay parkingDisplay2=new ParkingDisplay();

        parkingLot.registerObserver(parkingDisplay1);
        parkingLot.registerObserver(parkingDisplay2);

        // Simulate car entering and exiting
        parkingLot.carEnters();
        parkingLot.carEnters();
        parkingLot.carEnters();

        parkingLot.carExits();
        parkingLot.carExits();
        parkingLot.carExits();
    }
}
