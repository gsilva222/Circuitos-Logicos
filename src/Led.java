public class Led extends Componente {

    private boolean[] inputs;

    public Led (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.LED, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        ProgCircuito.drawPanel.drawComponent(logicircuit.LCComponent.LED, super.getCoordX(), super.getCoordY(), super.getEstado(), super.getLegenda());
    }

    @Override
    public void setInput(boolean[] inputs) {
        super.setEstado(inputs[0]);
    }

    @Override
    public void checkFull(){
        if(inputs.length==1){
            throw new IllegalArgumentException("Já tem 1 pin!");
        }
    }
}
