public class Or extends Componente {
    
    private boolean[] inputs;
    public Or (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.OR, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.OR, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 2) {
            throw new IllegalArgumentException("OR tem de ter 2 inputs");
        }
        this.inputs = inputs;
    }

    @Override
    public boolean getOutput() {
        if (inputs == null) {
            throw new IllegalStateException("OR nao tem inputs");
        }
        return inputs[0] || inputs[1];
    }
}
