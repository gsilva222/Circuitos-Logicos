import java.util.ArrayList;
import java.io.Serializable;
import logicircuit.LCInputPin;

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
                    // faz nada
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
            // Converte o ArrayList para um array de boolean
            boolean[] inputsArray = new boolean[inputs.size()];
            for (int i = 0; i < inputs.size(); i++) {
                inputsArray[i] = inputs.get(i);
            }
            try{
                componente.setInput(inputsArray);
            } catch (Exception e) {
                // faz nada
            }
        }
    }

    public  void setAllStates(){
        for(int i = 0; i < componentes.size()+1;i++){
            setEstadoFio();
            setEstadoComponente();
        }
    }
    /**
     * Limpa todos os componentes e conexões do circuito e atualiza a interface.
     */
    public void clear() {
        clearComponentes();
        clearConexoes();
        Desenhar(); // Atualiza a interface gráfica
        System.out.println("Circuito limpo.");
    }

    public void clearComponentes() {
        componentes.clear();
    }

    public void clearConexoes() {
        conexoes.clear();
    }

}
