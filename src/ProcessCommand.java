import logicircuit.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.*;



public class ProcessCommand implements CmdProcessor {

    public Circuito circuito = new Circuito();

    @Override
    public String process(String cmd) {
        // Divide o comando em duas partes: o comando e os argumentos
        String[] parts = cmd.trim().split(" ", 2);
        String command = parts[0].toUpperCase();
        String args = parts.length > 1 ? parts[1] : "";

        switch (command) {
            // ADD <id>:<tipo_porta>@<coord_X>,<coord_Y> [<legenda>]
            case "ADD":
                return processAddCommand(args);

            // WIRE <id_elemento1> <id_elemento2> <input_pin_elemento2>
            case "WIRE":
                return processWireCommand(args);

            // TURN <state> <id_elemento_entrada>
            case "TURN":
                return processTurnCommand(args);

            case "SAVE":
                if (args.isEmpty()) {
                    return "Erro: nome do arquivo não fornecido.";
                }
                saveCircuit(args.trim());
                return "Circuito gravado.";

            case "OPEN":
                if (args.isEmpty()) {
                    return "Erro: nome do arquivo não fornecido.";
                }
                openCircuit(args.trim());
                return "Circuito carregado.";
            case "CLEAR":
                circuito.clear();
                return "Circuito limpo com sucesso.";

            default:
                return "Erro: comando desconhecido.";

        }
    }

    /**
     * Processa o comando ADD.
     *
     * @param args Argumentos do comando ADD no formato: <id>:<tipo_porta>@<coord_X>,<coord_Y> [<legenda>]
     * @return Mensagem indicando o sucesso ou erro do processamento
     */
    private String processAddCommand(String args) {
        String regex = "(\\w+):(\\w+)@(\\d+),(\\d+)(?: (.*))?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);
    
        if (matcher.matches()) {
            String id = matcher.group(1);
            String component = matcher.group(2);
            int x = Integer.parseInt(matcher.group(3));
            int y = Integer.parseInt(matcher.group(4));
            // Usar o id como legenda
            String legend = matcher.group(5) != null ? matcher.group(5).trim() : id;
    
            System.out.println("ID: " + id);
            System.out.println("Componente: " + component);
            System.out.println("Coordenada X: " + x);
            System.out.println("Coordenada Y: " + y);
            System.out.println("Legenda: " + legend);
    
            component = component.toUpperCase();

            switch (component) {
                case "SWITCH":
                    Switch sw = new Switch(id, x, y, false, legend);
                    circuito.addComponente(sw);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                case "AND":
                    And and = new And(id, x, y, false, legend);
                    circuito.addComponente(and);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                case "OR":
                    Or or = new Or(id, x, y, false, legend);
                    circuito.addComponente(or);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                case "NOT":
                     Not not = new Not(id, x, y, false, legend);
                    circuito.addComponente(not);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                case "LED":
                    Led led = new Led(id, x, y, false, legend);
                    circuito.addComponente(led);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                case "NDISPLAY":
                    Ndisplay ndisplay = new Ndisplay(id, x, y, false, legend);
                    circuito.addComponente(ndisplay);
                    circuito.setAllStates();
                    circuito.Desenhar();
                    break;
    
                default:
                    return "Erro: tipo de componente desconhecido.";
            }


            return "Comando ADD processado com sucesso.";
        } else {
            return "Erro: formato do comando ADD inválido.";
        }
    }


    /**
     * Processa o comando WIRE.
     *
     * @param args Argumentos do comando WIRE no formato: <id_elemento1> <id_elemento2> [<input_pin_elemento2>]
     * @return Mensagem indicando o sucesso ou erro do processamento
     */
    private String processWireCommand(String args){
        String regex = "(\\w+) (\\w+)(?: (\\w+))?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);

        if (matcher.matches()) {
            String from = matcher.group(1);
            String to = matcher.group(2);
            String pin = matcher.group(3) != null ? matcher.group(3).toUpperCase() : "PIN_A";

            System.out.println("ID Elemento 1: " + from);
            System.out.println("ID Elemento 2: " + to);
            System.out.println("Pin: " + getPin(pin));

            for (Conexao conexao : circuito.conexoes) {
                if (conexao.getTarget().getId().equals(to) && conexao.getPin().equals(getPin(pin))) {
                    return("Erro: O pin " + pin + " do componente " + to + " já está ocupado.");
                }
            }

            circuito.addConexao(from, to, getPin(pin));
            circuito.setAllStates();
            circuito.Desenhar();

            return "Comando WIRE processado com sucesso.";
        } else {
            return "Erro: formato do comando WIRE inválido.";
        }
    }

    private LCInputPin getPin(String pin){
        switch (pin) {
            case "PIN_A":
                return LCInputPin.PIN_A;
            case "PIN_B":
                return LCInputPin.PIN_B;
            case "PIN_C":
                return LCInputPin.PIN_C;
        }
        return LCInputPin.PIN_A;
    }

    /**
     * Processa o comando TURN.
     *
     * @param args Argumentos do comando TURN no formato: <state> <id_elemento_entrada>
     * @return Mensagem indicando o sucesso ou erro do processamento
     */
    private String processTurnCommand(String args)
    {
        String regex = "(\\w+) (\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);

        if (matcher.matches()) {
            String state = matcher.group(1);
            String id = matcher.group(2);

            System.out.println("State: " + state);
            System.out.println("ID Elemento: " + id);

            state = state.toUpperCase();

            switch (state) {
                case "ON":
                    for (Componente componente : circuito.componentes) {
                        if (componente.getId().equals(id)) {
                            componente.setEstado(true);
                            circuito.setAllStates();
                            circuito.Desenhar();
                        }
                    }
                    break;
                case "OFF":
                    for (Componente componente : circuito.componentes) {
                        if (componente.getId().equals(id)) {
                            componente.setEstado(false);
                            circuito.setAllStates();
                            circuito.Desenhar();
                        }
                    }
                    break;
                default:
                    return "Erro: estado desconhecido.";
            }

            circuito.Desenhar();

            return "Comando TURN processado com sucesso.";
        } else {
            return "Erro: formato do comando TURN inválido.";
        }
    }

    private void saveCircuit(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(circuito);
        System.out.println("Circuito gravado com sucesso em " + fileName);
        } catch (IOException e) {
        System.err.println("Erro ao gravar o circuito: " + e.getMessage());
        }
}

    private void openCircuit(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        circuito = (Circuito) ois.readObject();
        circuito.setAllStates();
        circuito.Desenhar();
        System.out.println("Circuito carregado com sucesso de " + fileName);
        } catch (IOException | ClassNotFoundException e) {
        System.err.println("Erro ao carregar o circuito: " + e.getMessage());
        }
}
}
