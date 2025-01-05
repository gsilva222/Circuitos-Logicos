public class Or extends Componente {
    
    public Or (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.OR, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.OR, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
}
