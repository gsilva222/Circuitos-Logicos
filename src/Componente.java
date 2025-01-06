import logicircuit.*;

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
        ProgCircuito.drawPanel.drawComponent(comp, coordY, coordX, legenda);
    }


    public void setInput(boolean[] inputs) {
        throw new UnsupportedOperationException("Não é suportado.");
    }

    public boolean getOutput() {
        throw new UnsupportedOperationException("Não é suportado.");
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

    public logicircuit.LCComponent getComp() {
        return comp;
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
}


