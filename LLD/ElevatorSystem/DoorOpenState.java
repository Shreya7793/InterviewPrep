package LLD.ElevatorSystem;

public class DoorOpenState implements ElevatorState{
    private Elevator elevator;

    public DoorOpenState(Elevator elevator) {
        this.elevator = elevator;
    }
    @Override
    public void onEntry() {
        System.out.println("Door is open");
    }

    @Override
    public void requestFloor(Elevator elevator, int destinationFloor) {
        System.out.println("Cannot process request while door is open. Close door first.");
    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Door is already open.");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Closing elevator door.");
        elevator.setElevatorState(new DoorClosedState(elevator));
    }
}
