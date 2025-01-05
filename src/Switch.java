public class Switch extends Componente {

    public Switch (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.SWITCH, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.SWITCH, super.getCoordX(), super.getCoordY(), super.getEstado(), super.getLegenda());
    }
}
