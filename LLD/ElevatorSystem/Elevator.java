package LLD.ElevatorSystem;
/*
Elevator has unique elevator id, current floor
This is used to set the elevator state.
 */
public class Elevator {

    String elevatorId;
    int currentFloor;

    ElevatorState elevatorState;

    Elevator(String elevatorId){
        this.elevatorId=elevatorId;
        this.currentFloor=0; //Ground floor
        this.elevatorState=new StoppedState(this); //intitate state is stopped
    }
    public String getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setElevatorState(ElevatorState elevatorState){
        this.elevatorState=elevatorState;
        this.elevatorState.onEntry();
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void requestFloor(int floor) {
        // Simulate movement
        try {
            Thread.sleep(2000); // Simulate movement time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(elevatorId + " has arrived at floor " + floor);
        setCurrentFloor(floor); // Update current floor
        setElevatorState(new StoppedState(this)); // Change state to Idle after reaching floor
    }

    public void moveUp() {
        setElevatorState(new MovingUpState(this));
        currentFloor++;
    }

    public void moveDown() {
        setElevatorState(new MovingDownState(this));
        currentFloor--;
    }

    public void closeDoor(Elevator elevator){
        setElevatorState(new DoorClosedState(this));
    }
    public void openDoor(Elevator elevator){
        setElevatorState(new DoorOpenState(this));
    }
}
