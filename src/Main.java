import logicircuit.*;

import java.util.HashMap;
import java.util.Map;

import static logicircuit.LCComponent.*;
import static logicircuit.LCInputPin.*;
import static logicircuit.LCDFrameCmd.*;

public class Main 
{
    public static LCDPanel drawPanel;
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

        drawPanel.clear();

        /*Switch sw1 = new Switch("LED1", 500, 500, true, "LED1");
        sw1.Desenhar();
        And and1 = new And("AND", 400, 400, true, "AND1");
        and1.Desenhar();
        Led ld1 = new Led("LED1", 300, 300, false, "LED1");
        ld1.Desenhar();
        Nand nand1 = new Nand("NAND", 200, 200, true, "NAND1");
        nand1.Desenhar();
        Nor nor1 = new Nor("NOR", 100, 100, false, "NOR1");
        nor1.Desenhar();
        Not not1 = new Not("NOT", 500, 50, true, "NOT1");
        not1.Desenhar();
        Or or1 = new Or("OR", 400, 50, false, "OR1");
        or1.Desenhar();
        Xor xor1 = new Xor("XOR", 300, 50, true, "XOR1");
        xor1.Desenhar();*/


    }

}
