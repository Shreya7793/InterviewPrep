package LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

/*
This is central component for managing & coordinating the behavior of different elevators.
It oversees the performance of all elevators.
 */
public class ElevatorController {
    private static ElevatorController elevatorController; //singleton instance
    List<Elevator> elevatorList; //list to hold elevators

    //private constructor to prevent instantiation from outside
    private ElevatorController(){
        elevatorList=new ArrayList<>();
    }

    //This method creates a singleton instance. It is using double Locking
    //Note the return type is ElevatorController
    public static ElevatorController getInstance(){
        if(elevatorController==null){
            synchronized (ElevatorController.class){ //this means that only one thread can access Elevator controller class at once
                if(elevatorController==null) //second check
                    elevatorController=new ElevatorController();
            }
        }
        return elevatorController;
    }

    // Method to add elevator to the control system
    public void addElevator(Elevator elevator){
        elevatorList.add(elevator);
    }

    // Method to remove elevator from the control system
    public  void removeElevator(Elevator elevator){
        elevatorList.remove(elevator);
    }

    //Method to get all the elevators list
    public List<Elevator> getElevatorList(){
        return elevatorList;
    }
}
