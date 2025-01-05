import logicircuit.LCComponent;
import logicircuit.LCInputPin;


public class Conexao {
    private Componente source;
    private Componente target;
    private LCInputPin pin;


    public Conexao (Componente source, Componente target, LCInputPin pin) {
        this.source = source;
        this.target = target;
        this.pin = pin;
    }

    public void draw() {
        Main.drawPanel.drawWire(source.getComp(), source.getCoordX(), source.getCoordY(), target.getComp(), target.getCoordX(), target.getCoordY(), pin, true);
    }
}
