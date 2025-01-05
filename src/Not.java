public class Not extends Componente {
    
    public Not (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.AND, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.NOT, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
}
