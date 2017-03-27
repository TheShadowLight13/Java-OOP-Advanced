package pr10.io;

import pr10.interfaces.io.Interpreter;
import pr10.interfaces.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader implements Reader{

    private final String END_COMMAND = "END";

    private Interpreter interpreter;

    public InputReader(Interpreter interpreter) {
        this.setInterpreter(interpreter);
    }

    public Interpreter getInterpreter() {
        return this.interpreter;
    }

    private void setInterpreter(Interpreter interpreter) {
        this.interpreter = interpreter;
    }


    @Override
    public void readCommands() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().trim();
        while (!input.equals(END_COMMAND)) {
            this.getInterpreter().interpretCommand(input);
            input = reader.readLine().trim();
        }
    }
}
