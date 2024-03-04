package LLD.ElevatorSystem;

public class MovingUpState implements ElevatorState{
    Elevator elevator;
    MovingUpState(Elevator elevator){
        this.elevator=elevator;
    }
    @Override
    public void onEntry() {
        System.out.println("Elevator is moving up.");
    }

    @Override
    public void requestFloor(Elevator elevator, int destinationFloor) {
        // Ignore requests when the elevator is already moving up
        System.out.println("Cannot process request. "+elevator.getElevatorId()+" is already moving up.");
    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Cannot open door while the"+elevator.getElevatorId()+"is moving.");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Door is already closed");
    }
}
