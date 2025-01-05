import logicircuit.CmdProcessor;
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
            case "ADD":
                // Lógica para ADD AND1:AND@500,500,false [AND1] 
                return "Comando ADD processado.";

            case "WIRE":
                // Lógica para WIRE
                System.out.println("Comando WIRE recebido com argumentos: " + args);
                return "Comando WIRE processado.";

            case "TURN":
                // Lógica para TURN
                System.out.println("Comando TURN recebido com argumentos: " + args);
                return "Comando TURN processado.";

            case "SAVE":
                // Lógica para SAVE
                System.out.println("Comando SAVE recebido com argumentos: " + args);
                return "Comando SAVE processado.";

            case "OPEN":
                // Lógica para OPEN
                System.out.println("Comando OPEN recebido com argumentos: " + args);
                return "Comando OPEN processado.";

            default:
                return "Erro: comando desconhecido.";
        }
    }
}
