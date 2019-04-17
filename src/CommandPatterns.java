
/**
 * 命令模式
 */
public class CommandPatterns {
    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        LightOnCommand lightOnCommand = new LightOnCommand(receiver);
        Invoker invoker = new Invoker(lightOnCommand);
        invoker.action();


        LightOffCommand lightOffCommand = new LightOffCommand(receiver);
        invoker.setCommand(lightOffCommand);
        invoker.action();
    }

}


interface Command {
    void execute();
}

class Receiver {
    public void lightOn() {
        System.out.println("开灯");
    }

    public void lightOff() {
        System.out.println("关灯");
    }
}

class LightOnCommand implements Command {
    private Receiver receiver;

    public LightOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.lightOn();
    }
}

class LightOffCommand implements Command {
    private Receiver receiver;

    public LightOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.lightOff();
    }
}

class Invoker {
    private Command command;


    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}

