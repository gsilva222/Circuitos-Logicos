public class Ndisplay extends Componente {
    
    private boolean[] inputs;
    public Ndisplay (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.OR, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.BIT3_DISPLAY, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 3) {
            throw new IllegalArgumentException("Display tem de ter 3 inputs");
        }
        this.inputs = inputs;
    }
}
