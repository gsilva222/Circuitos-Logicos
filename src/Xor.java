public class Xor extends Componente {
    
    public Xor (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.OR, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.XOR, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
}