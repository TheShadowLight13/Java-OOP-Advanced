package pr03.io;

import pr03.contracts.Interpreter;
import pr03.contracts.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader implements Reader {

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
    public void readCommands() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = reader.readLine();
            while (!input.equals("fight")) {
                try {
                    String result = this.getInterpreter().interpretCommand(input);
                    OutputWriter.printResultOnNewLine(result);
                } catch (RuntimeException e) {
                   OutputWriter.printResultOnNewLine(e.getMessage());
                }

                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
