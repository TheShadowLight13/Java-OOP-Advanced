package pr10;

import pr10.interfaces.io.Interpreter;
import pr10.interfaces.io.Reader;
import pr10.interfaces.repository.Repository;
import pr10.io.CommandInterpreter;
import pr10.io.InputReader;
import pr10.repository.WeaponRepository;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Repository weaponRepository = new WeaponRepository();
        Interpreter commandInterpreter = new CommandInterpreter(weaponRepository);
        Reader reader = new InputReader(commandInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
