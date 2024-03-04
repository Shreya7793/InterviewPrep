package LLD.ElevatorSystem;

public class DoorClosedState implements ElevatorState{

    private Elevator elevator;

    public DoorClosedState(Elevator elevator) {
        this.elevator = elevator;
    }
    @Override
    public void onEntry() {
        System.out.println("Door is closed");
    }

    @Override
    public void requestFloor(Elevator elevator, int destinationFloor) {
        System.out.println("Cannot process request while door is open. Close door first.");
    }

    @Override
    public void openDoor(Elevator elevator) {
        if(elevator.getElevatorState() instanceof StoppedState){
            System.out.println("Opening elevator door.");
            elevator.setElevatorState(new DoorOpenState(elevator));
        } else {
            System.out.println("Cannot open door. Elevator is not in Stopped state.");
        }
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Door is already closed.");
    }
}
