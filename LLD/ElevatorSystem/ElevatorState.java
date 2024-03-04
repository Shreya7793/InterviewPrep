package LLD.ElevatorSystem;
/*
State Design Pattern
DoorClosedState
DoorOpenState->check if elevator is in stopped state and then only open door
MovingUpState
MovingDownState
StoppedState -> can request floor only here
 */
public interface ElevatorState {
    /*
    This method is called when the elevator transitions into a particular state.
    It allows the state to perform any initialization tasks or actions that need
    to be executed when entering the state.
     */
    void onEntry();
    void requestFloor(Elevator elevator, int destinationFloor); //used to move the elevator to a specific floor
    void openDoor(Elevator elevator);
    void closeDoor(Elevator elevator);
}

