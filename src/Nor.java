public class Nor extends Componente {

    public Nor (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.SWITCH, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.NOR, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
}
