package LLD.ParkingLot;

public class Client {
public static void main(String []args) {
    ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

    // Create parking floors
    parkingLotSystem.initialiseFloor(1, 10, 5, 3);
    parkingLotSystem.initialiseFloor(2, 10, 5, 3);
    parkingLotSystem.initialiseFloor(3, 10, 5, 3);

    //Simulate vehicle entering
    ParkingTicket ticket = parkingLotSystem.issueParkingTicket(ParkingSpotType.COMPACT);
    if (ticket!=null) {
        System.out.println("Parking ticket issued. Ticket ID: " + ticket.getTicketID());
        // Simulate parking duration
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Fee calculation
       // double fee = parkingLotSystem.calculateParkingFee(ticket);
       // System.out.println("Parking fee: $" + fee);
        // Simulate vehicle exiting
      //  ParkingSpot spot = parkingLotSystem.findVacantSpot(ParkingSpotType.COMPACT);
      //  parkingLotSystem.vacateParkingSpot(spot);
        System.out.println("Vehicle exited from parking lot.");
    }
}
}
