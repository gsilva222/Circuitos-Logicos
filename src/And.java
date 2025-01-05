public class And extends Componente {

    public And (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.AND, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.AND, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
}