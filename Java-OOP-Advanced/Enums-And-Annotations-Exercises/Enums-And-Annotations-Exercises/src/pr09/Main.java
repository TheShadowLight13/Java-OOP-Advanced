package pr09;
import pr09.enums.Lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lightNames = reader.readLine().trim().toUpperCase().split("\\s+");
        int lightsCount = Integer.valueOf(reader.readLine());
        Lights[] lights = getLights(lightNames);

        Lights currLight = lights[lights.length - 1];
        TrafficLight trafficLight = new TrafficLight(currLight, lights);

        for (int i = 0; i < lightsCount; i++) {
            trafficLight.updateLights();
            printLights(trafficLight.getNextLights());
        }
    }

    private static void printLights(Lights[] nextLights) {
        for (Lights nextLight : nextLights) {
            System.out.print(nextLight.name() + " ");
        }

        System.out.println();
    }

    private static Lights[] getLights(String[] lightNames) {
        Lights[] lights = new Lights[lightNames.length];

        for (int i = 0; i < lights.length; i++) {
            lights[i] = Lights.valueOf(lightNames[i]);
        }

        return lights;
    }
}
