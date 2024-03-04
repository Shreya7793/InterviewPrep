package LLD.ElevatorSystem;

public class StoppedState implements ElevatorState{
    Elevator elevator;
    StoppedState(Elevator elevator){
        this.elevator=elevator;
    }
    @Override
    public void onEntry() {

    }

    @Override
    public void requestFloor(Elevator elevator, int destinationFloor) {
        System.out.println("Current floor is "+elevator.getCurrentFloor());
        if(destinationFloor<elevator.getCurrentFloor()){
            System.out.println("Moving down to "+destinationFloor);
            elevator.setCurrentFloor(destinationFloor);
            elevator.setElevatorState(new MovingDownState(elevator));
        } else if(destinationFloor>elevator.getCurrentFloor()){
            System.out.println("Moving Up to "+destinationFloor);
            elevator.setCurrentFloor(destinationFloor);
            elevator.setElevatorState(new MovingUpState(elevator));
        } else
            System.out.println("Elevator is already on floor " + destinationFloor);

    }

    @Override
    public void openDoor(Elevator elevator) {
        if(elevator.getElevatorState() instanceof DoorClosedState) {
            System.out.println("Opening doors");
            elevator.setElevatorState(new DoorOpenState(elevator));
        }else{
            System.out.println("Doors already open");
        }
    }

    @Override
    public void closeDoor(Elevator elevator) {
        if(elevator.getElevatorState() instanceof DoorOpenState) {
            System.out.println("Closing doors");
            elevator.setElevatorState(new DoorClosedState(elevator));
        }else{
            System.out.println("Doors already Closed");
        }
    }
}
