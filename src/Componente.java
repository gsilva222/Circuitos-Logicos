
import logicircuit.*;
import static logicircuit.LCComponent.*;
import static logicircuit.LCInputPin.*;

public class Componente {
    private String id;
    private int coordX;
    private int coordY;
    private boolean estado;
    private String legenda;
    private logicircuit.LCComponent comp;

    public Componente(logicircuit.LCComponent comp, String id, int coordX, int coordY,boolean estado, String legenda) {
        this.comp = comp;
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.estado = estado;
        this.legenda = legenda;
    }

    public void Desenhar(){
        Main.drawPanel.drawComponent(comp, coordY, coordX, legenda);
    }

    public String getId() {
        return id;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public logicircuit.LCComponent getComp() {
        return comp;
    }
}

