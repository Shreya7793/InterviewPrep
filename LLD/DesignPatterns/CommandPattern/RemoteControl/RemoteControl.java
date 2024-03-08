package LLD.DesignPatterns.CommandPattern.RemoteControl;

//Invoker
public class RemoteControl {
    Command command;

    void setCommand(Command command){
        this.command=command;
    }
    void pressButton(){
        command.execute();
    }
    void unpressButton(){
        command.unexecute();
    }
}
