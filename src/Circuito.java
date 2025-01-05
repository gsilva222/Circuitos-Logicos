import java.util.ArrayList;

import logicircuit.LCInputPin;

public class Circuito {
    
    ArrayList<Componente> componentes = new ArrayList<Componente>();
    ArrayList<Conexao> conexoes = new ArrayList<Conexao>();

    public void addComponente(Componente componente) {
        componentes.add(componente);
    }

    public void Desenhar() {
        for (Componente componente : componentes) {
            componente.Desenhar();
        }
        for (Conexao conexao : conexoes) {
            conexao.draw();
        }
    }

    public void addConexao(String from, String to, LCInputPin pin) {
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
            } catch (UnsupportedOperationException e) {
                // do nothing
            }
        }
    }
}
