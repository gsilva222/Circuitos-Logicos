import logicircuit.*;

import java.util.regex.*;



public class ProcessCommand implements CmdProcessor {

    public Circuito circuito = new Circuito();

    @Override
    public String process(String cmd) {
        // Divide o comando em duas partes: o comando e os argumentos
        String[] parts = cmd.trim().split(" ", 2);
        if (parts.length < 2) {
            return "Erro: comando incompleto.";
        }

        String command = parts[0].toUpperCase();
        String args = parts[1];

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
                System.out.println("Comando SAVE recebido com argumentos: " + args);
                return "Comando SAVE processado.";

            case "OPEN":
                System.out.println("Comando OPEN recebido com argumentos: " + args);
                return "Comando OPEN processado.";

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
        String regex = "(\\w+):(\\w+)@(\\d+),(\\d+) ?(?:\\[(.*)\\])?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);

        if (matcher.matches()) {
            String id = matcher.group(1);
            String component = matcher.group(2);
            int x = Integer.parseInt(matcher.group(3));
            int y = Integer.parseInt(matcher.group(4));
            String legend = matcher.group(5);

            System.out.println("ID: " + id);
            System.out.println("Componente: " + component);
            System.out.println("Coordenada X: " + x);
            System.out.println("Coordenada Y: " + y);
            System.out.println("Legenda: " + (legend != null ? legend : "Sem legenda"));

            component = component.toUpperCase();

            switch (component) {
                case "SWITCH":
                    Switch sw = new Switch(id, x, y, false, legend);
                    circuito.addComponente(sw);
                    circuito.Desenhar();
                    break;
    
                case "AND":
                    And and = new And(id, x, y, false, legend);
                    circuito.addComponente(and);
                    circuito.Desenhar();
                    break;
    
                case "OR":
                    Or or = new Or(id, x, y, false, legend);
                    circuito.addComponente(or);
                    circuito.Desenhar();
                    break;
    
                case "NOT":
                     Not not = new Not(id, x, y, false, legend);
                    circuito.addComponente(not);
                    circuito.Desenhar();
                    break;
    
                case "LED":
                    Led led = new Led(id, x, y, false, legend);
                    circuito.addComponente(led);
                    circuito.Desenhar();
                    break;
    
                case "NDISPLAY":
                    Ndisplay ndisplay = new Ndisplay(id, x, y, false, legend);
                    circuito.addComponente(ndisplay);
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
     * @param args Argumentos do comando WIRE no formato: <id_elemento1> <id_elemento2> <input_pin_elemento2>
     * @return Mensagem indicando o sucesso ou erro do processamento
     */
    private String processWireCommand(String args){
        String regex = "(\\w+) (\\w+) (\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);

        if (matcher.matches()) {
            String from = matcher.group(1);
            String to = matcher.group(2);
            String pin = matcher.group(3);
            pin = pin.toUpperCase();

            System.out.println("ID Elemento 1: " + from);
            System.out.println("ID Elemento 2: " + to);
            System.out.println("Pin: " + getPin(pin));

            circuito.addConexao(from, to, getPin(pin));
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
            default:
                return LCInputPin.PIN_A;
        }
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
                            circuito.setEstadoComponente();
                            circuito.setEstadoFio();
                        }
                    }
                    break;
                case "OFF":
                    for (Componente componente : circuito.componentes) {
                        if (componente.getId().equals(id)) {
                            componente.setEstado(false);
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
}
