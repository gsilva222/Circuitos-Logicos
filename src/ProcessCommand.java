import logicircuit.CmdProcessor;
import static logicircuit.LCComponent.SWITCH;
import java.util.regex.*;



public class ProcessCommand implements CmdProcessor {

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
                System.out.println("Comando WIRE recebido com argumentos: " + args);
                return "Comando WIRE processado.";

            // TURN <state> <id_elemento_entrada>
            case "TURN":
                System.out.println("Comando TURN recebido com argumentos: " + args);
                return "Comando TURN processado.";

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
        Circuito circuito = new Circuito();

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
    
                case "3BD":
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
}
