package LLD.CommandPattern.RemoteControl;

public class StereoOnCommand implements Command{
    Stereo stereo;

    StereoOnCommand(Stereo stereo){
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        stereo.turnOn();
        stereo.setVolume(10);
    }

    @Override
    public void unexecute() {
        stereo.turnOff();
    }
}
