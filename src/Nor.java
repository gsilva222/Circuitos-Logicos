public class Nor extends Componente {

    private boolean[] inputs;
    public Nor (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.SWITCH, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.NOR, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }

    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 2) {
            throw new IllegalArgumentException("NOR gate must have 2 inputs");
        }
        this.inputs = inputs;
    }

    @Override
    public boolean getOutput() {
        if (inputs == null) {
            throw new IllegalStateException("NOR gate inputs are not set");
        }
        return !(inputs[0] || inputs[1]);
    }
}
