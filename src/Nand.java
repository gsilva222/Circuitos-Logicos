public class Nand extends Componente {

    public Nand (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.SWITCH, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.NAND, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
}
