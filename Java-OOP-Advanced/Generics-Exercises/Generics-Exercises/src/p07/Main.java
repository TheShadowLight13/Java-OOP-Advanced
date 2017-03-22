package p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ICustomList<String> customList = new CustomListImpl<>();

        String input = reader.readLine();
        while (!input.toLowerCase().equals("end")) {

            String[] data = input.split("\\s+");
            String command = data[0];
            CommandInterpreter.interpretCommand(command, data, customList);

            input = reader.readLine();
        }
    }
}
