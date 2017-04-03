package pr06;

import pr06.interfaces.Client;
import pr06.models.MicrowaveOven;

public class Main {

    public static void main(String[] args) {
        Client microOven = new MicrowaveOven("test");
        microOven.createTweet("This is sample test");
        microOven.sendTweet();
    }
}
