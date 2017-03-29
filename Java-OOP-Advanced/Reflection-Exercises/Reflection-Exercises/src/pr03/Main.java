package pr03;

import pr03.contracts.Interpreter;
import pr03.contracts.Reader;
import pr03.contracts.Repository;
import pr03.contracts.UnitFactory;
import pr03.core.Engine;
import pr03.core.factories.UnitFactoryImpl;
import pr03.data.UnitRepository;
import pr03.io.CommandInterpreter;
import pr03.io.InputReader;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Interpreter interpreter = new CommandInterpreter(repository, unitFactory);
		Reader reader = new InputReader(interpreter);
		Runnable engine = new Engine(reader);
		engine.run();
	}
}
