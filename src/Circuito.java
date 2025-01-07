import java.util.ArrayList;
import java.io.Serializable;
import logicircuit.LCInputPin;
import logicircuit.LCComponent;

public class Circuito implements Serializable {
    
    ArrayList<Componente> componentes = new ArrayList<Componente>();
    ArrayList<Conexao> conexoes = new ArrayList<Conexao>();

    public void addComponente(Componente componente) {
        componentes.add(componente);
    }

    public void Desenhar() {
        ProgCircuito.drawPanel.clear();
        for (Componente componente : componentes) {
            componente.Desenhar();
        }
        for (Conexao conexao : conexoes) {
            conexao.draw();
        }
    }

    public void addConexao(String from, String to, LCInputPin pin) {
        for (Conexao conexao : conexoes) {
            if (conexao.getTarget().getId().equals(to) && conexao.getPin().equals(pin)) {
                System.out.println("Erro: O pin " + pin + " do componente " + to + " já está ocupado.");
                return;
            }
        }

        /*for (Componente componente : componentes) {
            if (componente.getId().equals(to)) {
                // Valida se o pin está dentro do limite do componente
                switch (componente.getComp().numberInputPins) {
                    case ONE:
                        if (!pin.equals(LCInputPin.PIN_A)) {
                            System.out.println("Erro: Componente " + to + " só suporta PIN_A.");
                            return;
                        }
                        break;
                    case TWO:
                        if (!pin.equals(LCInputPin.PIN_A) && !pin.equals(LCInputPin.PIN_B)) {
                            System.out.println("Erro: Componente " + to + " só suporta PIN_A e PIN_B.");
                            return;
                        }
                        break;
                    case THREE:
                        // PIN_C é permitido neste caso
                        break;
                    default:
                        System.out.println("Erro: Número de pinos inválido para o componente " + to + ".");
                        return;
                }
            }
        }*/



        for (Componente componente : componentes) {
            if (componente.getId().equals(from)) {
                for (Componente componente2 : componentes) {
                    if (componente2.getId().equals(to)) {
                        Conexao conexao = new Conexao(componente, componente2, pin);
                        conexoes.add(conexao);
                    }
                }
            }
        }
    }

    public void setEstadoFio() {
        for (Conexao conexao : conexoes) {
           for(Componente componente : componentes) {
               if (componente.getId().equals(conexao.getSource().getId())) {
                try {
                   conexao.setEstadofio(componente.getOutput());
                } catch (Exception e) {
                    // TODO: handle exception
                }
               }
           }
        }
    }

    public void setEstadoComponente() {
        for (Componente componente : componentes){
            ArrayList<Boolean> inputs = new ArrayList<Boolean>();
            for(Conexao conexao : conexoes) {
                if (componente.getId().equals(conexao.getTarget().getId())) {
                        inputs.add(conexao.getEstadofio());
                }
            }
            boolean[] inputsArray = new boolean[inputs.size()];
            for (int i = 0; i < inputs.size(); i++) {
                inputsArray[i] = inputs.get(i);
            }
            try{
                componente.setInput(inputsArray);
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    public  void setAllStates(){
        for(int i = 0; i < componentes.size()+1;i++){
            setEstadoFio();
            setEstadoComponente();
        }
    }
}
