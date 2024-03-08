package LLD.DesignPatterns.CommandPattern.RemoteControl;

//Receiver
public class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
