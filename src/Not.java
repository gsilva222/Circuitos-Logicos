public class Not extends Componente {
    
    private boolean[] inputs;

    public Not (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.AND, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.NOT, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 1) {
            throw new IllegalArgumentException("NOT tem de ter 1 inputs");
        }
        this.inputs = inputs;
    }

    @Override
    public boolean getOutput() {
        if (inputs == null) {
            throw new IllegalStateException("NOT nao tem inputs");
        }
        return !(inputs[0]);
    }
}
