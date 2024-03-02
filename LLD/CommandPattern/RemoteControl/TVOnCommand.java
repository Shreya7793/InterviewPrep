package LLD.CommandPattern.RemoteControl;

public class TVOnCommand implements Command{
    TV tv;
    TVOnCommand(TV tv){
        this.tv=tv;
    }
    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void unexecute() {
        tv.turnOff();
    }
}
