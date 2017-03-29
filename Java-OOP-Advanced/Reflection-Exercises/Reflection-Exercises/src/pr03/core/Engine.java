package pr03.core;

import pr03.contracts.Reader;

public class Engine implements Runnable {

    private Reader reader;

    public Engine(Reader reader) {
       this.setReader(reader);
    }

    public Reader getReader() {
        return this.reader;
    }

    private void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        this.getReader().readCommands();
    }
}
