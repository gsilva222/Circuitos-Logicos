import logicircuit.*;

import java.util.HashMap;
import java.util.Map;

import static logicircuit.LCComponent.*;
import static logicircuit.LCInputPin.*;

public class Main 
{
    private final LCDPanel drawPanel;
    static boolean sd = false, se = false, sf = false;

    public static void main(String[] args) 
    {
        new Main();
    }

    private Main() 
    {
        ProcessCommand processCommand = new ProcessCommand();
        LCDFrameCmd frame = new LCDFrameCmd(processCommand,"Demo de Logic Circuit", 900, 700);
        drawPanel = frame.drawPanel();
    }

}
