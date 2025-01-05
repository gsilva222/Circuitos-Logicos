public class And extends Componente {

    private boolean[] inputs;

    public And (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.AND, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.AND, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }

    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 2) {
            throw new IllegalArgumentException("AND tem de ter 2 inputs");
        }
        this.inputs = inputs;
    }

    @Override
    public boolean getOutput() {
        if (inputs == null) {
            throw new IllegalStateException("AND nao tem inputs");
        }
        return inputs[0] && inputs[1];
    }

}