package LLD.ElevatorSystem;

public class MovingDownState implements ElevatorState{

    Elevator elevator;
    MovingDownState(Elevator elevator){
        this.elevator=elevator;
    }
    @Override
    public void onEntry() {
        System.out.println("Elevator is moving down.");
    }

    @Override
    public void requestFloor(Elevator elevator, int destinationFloor) {
        // Ignore requests when the elevator is already moving down
        System.out.println("Cannot process request. "+elevator.getElevatorId()+" is already moving down.");
    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Cannot open door while "+elevator.getElevatorId()+" is moving.");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Door is already closed");
    }
}
