package LLD.CommandPattern.RemoteControl;
/*
Usecase:
Remote control that can be used to operate various electronic devices such as a TV, stereo, and lights.
Each button on the remote control represents a command, and pressing a button executes the corresponding command.
Additionally, the remote control has an undo button that can reverse the previous command.

The Command interface declares methods for executing and undoing a command.
The RemoteControl class acts as an invoker and is responsible for executing the commands.

 */
public class Client {
    public static void main(String[] args) {
        RemoteControl remoteControl=new RemoteControl();
        TV tv=new TV();
        Command tvOnCommand=new TVOnCommand(tv);
        remoteControl.setCommand(tvOnCommand);
        remoteControl.pressButton();
        remoteControl.unpressButton();

        Stereo stereo=new Stereo();
        Command stereoOnCommand=new StereoOnCommand(stereo);
        remoteControl.setCommand(stereoOnCommand);
        remoteControl.pressButton();
        remoteControl.unpressButton();
    }
}
