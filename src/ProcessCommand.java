import logicircuit.CmdProcessor;

public class ProcessCommand implements CmdProcessor {
    public String process(String cmd) {
        System.out.println("Command: " + cmd);
        return cmd;
    }
    
}
