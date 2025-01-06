import logicircuit.*;

public class ProgCircuito
{
    public static transient LCDPanel drawPanel;
    static boolean sd = false, se = false, sf = false;

    public static void main(String[] args) 
    {
        new ProgCircuito();
    }

    private ProgCircuito()
    {
        ProcessCommand processCommand = new ProcessCommand();
        LCDFrameCmd frame = new LCDFrameCmd(processCommand,"Demo de Logic Circuit", 900, 700);        
        drawPanel = frame.drawPanel();

        drawPanel.clear();
    }
}