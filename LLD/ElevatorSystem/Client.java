package LLD.ElevatorSystem;

import java.util.List;

/*
Functional Requirement:
1. Vertical movement- the elevator should be able to go up/down to the floors in the building
2. Floor Selection- Passengers should be able to select the desired floor
3. Door Operation: The door should open/close automatically
3. Emergency Stop - In case of emergency, passenger should be able to halt the elevator
4. Overload protection - Should ensure that the elevator is filled more than the max capacity
5. Good-to-haves:
    5.1- communication system so that passengers can call during emergency
    5.2- power backup

Non-Functional Requirement:
1. Safety: Should comply with all safety regulations
2. Reliability: Minimum downtime for maintainence/repairs.
3. Scalability: The elevator system should be scalable to accomodate future modifications to the building
4. Performance: Should respond quickly to passenger requests and move efficiently between floors.

Implementation:
1. Singleton pattern for Elevator Controller -> contains list of Elevators
2. State Design pattern for Elevator state
DoorClosedState
DoorOpenState->check if elevator is in stopped state and then only open door
MovingUpState
MovingDownState
StoppedState -> can request floor only here
EmegencyStopState -> if time permits
3. MovementStrategy
DefaultMovementStrategy
EmergencyMovementStrategy
 */
public class Client {
    public static void main() {

        // Get the ElevatorControl instance
        ElevatorController elevatorController = ElevatorController.getInstance();
        //Add elevators to the control system
        Elevator elevator1=new Elevator("Elevator1");
        // Elevator elevator = new Elevator("Elevator1", new DefaultMovementStrategy());
        Elevator elevator2=new Elevator("Elevator2");
        elevatorController.addElevator(elevator1);
        elevatorController.addElevator(elevator2);
        //Retrieve the list of Elevators
        List<Elevator> elevatorList=elevatorController.getElevatorList();
        for (Elevator elevator:elevatorList)
            System.out.println(elevator.getElevatorId());

        elevator1.requestFloor(5); //goes tp 5th floor

        //To test state set elevator1 to MovingDownState
        elevator1.setElevatorState(new MovingDownState(elevator1));
        // Attempt to request floor while elevator is moving down
        elevator1.requestFloor(5); // This will trigger the output message
        // Set elevator1 back to IdleState
        elevator1.setElevatorState(new StoppedState(elevator1));
        // Request floor after setting elevator back to Stopped
        elevator1.requestFloor(5); // This should not trigger the output message
        elevator1.requestFloor(4);
        elevator1.requestFloor(3);
        elevator1.requestFloor(9);

    }
}