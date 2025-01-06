import logicircuit.*;
import java.io.Serializable;

public class Conexao implements Serializable {
    private Componente source;
    private Componente target;
    private LCInputPin pin;
    private boolean estadofio;

    public Conexao (Componente source, Componente target, LCInputPin pin) {
        this.source = source;
        this.target = target;
        this.pin = pin;
        this.estadofio = false;
    }

    public void draw() {
        ProgCircuito.drawPanel.drawWire(source.getComp(), source.getCoordX(), source.getCoordY(),
        target.getComp(), target.getCoordX(), target.getCoordY(), pin, estadofio);
    }

    public boolean getEstadofio() {
        return estadofio;
    }

    public void setEstadofio(boolean estado) {
        this.estadofio = estado;
    }

    public Componente getSource() {
        return source;
    }   

    public Componente getTarget() {
        return target;
    }

    public LCInputPin getPin() {
        return pin;
    }
}
