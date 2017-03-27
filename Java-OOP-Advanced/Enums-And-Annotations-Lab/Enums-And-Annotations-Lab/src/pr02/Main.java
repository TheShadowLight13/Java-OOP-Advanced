package pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String loggerLevel = reader.readLine();
        Logger logger = new Logger(Importance.valueOf(loggerLevel));

        String input = reader.readLine();
        while (!input.equals("END")) {

            int colonIndex = input.indexOf(":");
            String messageLevel = input.substring(0, colonIndex);
            String content = input.substring(colonIndex + 2);
            Message message = new Message(Importance.valueOf(messageLevel), content);
            logger.record(message);

            input = reader.readLine();
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
