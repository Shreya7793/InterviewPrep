package LLD.CommandPattern.RemoteControl;

//Receiver
public class Stereo {
    public void turnOn() {
        System.out.println("Stereo is ON");
    }
    public void turnOff() {
        System.out.println("Stereo is OFF");
    }
    public void setVolume(int volume) {
        System.out.println("Volume set to " + volume);
    }
}
