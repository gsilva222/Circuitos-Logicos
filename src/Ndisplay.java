public class Ndisplay extends Componente {
    
    public Ndisplay (String id, int coordX, int coordY, boolean estado, String legenda) {
        super(logicircuit.LCComponent.OR, id, coordX, coordY, estado, legenda);
    }

    @Override
    public void Desenhar() {
        Main.drawPanel.drawComponent(logicircuit.LCComponent.BIT3_DISPLAY, super.getCoordX(), super.getCoordY(), super.getLegenda());
    }
    
}
