import logicircuit.*;

import java.util.HashMap;
import java.util.Map;

import static logicircuit.LCComponent.*;
import static logicircuit.LCInputPin.*;
import static logicircuit.LCDFrameCmd.*;

public class ProgCircuito
{
    public static LCDPanel drawPanel;
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

        /*Circuito circuito = new Circuito();

        Switch sw1 = new Switch("SW1", 10, 50, false, "SW1");
        Switch sw2 = new Switch("SW2", 10, 150, true, "SW2");
        Switch sw3 = new Switch("SW3", 10, 350, true, "SW3");
        And and1 = new And("AND1", 100, 100, false, "AND1");
        And and2 = new And("AND2", 220, 200, false, "AND2");
        Or or1 = new Or("OR1", 330, 330, false, "OR1");
        Led ld1 = new Led("LED1", 440, 220, false, "LED1");
        Led ld2 = new Led("LED2", 440, 430, false, "LED2");
        circuito.addComponente(sw1);
        circuito.addComponente(sw2);
        circuito.addComponente(sw3);
        circuito.addComponente(and1);
        circuito.addComponente(and2);
        circuito.addComponente(or1);
        circuito.addComponente(ld1);
        circuito.addComponente(ld2);
        circuito.addConexao(sw1.getId(), and1.getId(), PIN_A);
        circuito.addConexao(sw2.getId(), and1.getId(), PIN_B);
        circuito.addConexao(and1.getId(), and2.getId(), PIN_A);
        circuito.addConexao(sw3.getId(), and2.getId(), PIN_B);
        circuito.addConexao(sw3.getId(), or1.getId(), PIN_B);
        circuito.addConexao(and2.getId(), or1.getId(), PIN_A);
        circuito.addConexao(and2.getId(), ld1.getId(), PIN_A);
        circuito.addConexao(or1.getId(), ld2.getId(), PIN_A);
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.setEstadoFio();
        circuito.setEstadoComponente();
        circuito.Desenhar(); */
    }

}
