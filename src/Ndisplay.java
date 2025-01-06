public class Ndisplay extends Componente {
    
    private boolean[] inputs;

    public Ndisplay (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.BIT3_DISPLAY, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.BIT3_DISPLAY, super.getCoordX(), super.getCoordY(), getValue());
    }
    
    @Override
    public void setInput(boolean[] inputs) {
        if (inputs.length != 3) {
            throw new IllegalArgumentException("Display tem de ter 3 inputs");
        }
        this.inputs = inputs;
    }

    private int getValue()
    {
        int value = 0;
        if(inputs == null) {
            return value;
        }
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i]) {
                value += Math.pow(2, i);
            }
        }
        return value;
    }
}
