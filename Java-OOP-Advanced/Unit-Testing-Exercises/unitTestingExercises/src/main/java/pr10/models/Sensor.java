package pr10.models;

import pr10.interfaces.ISensor;
import pr10.interfaces.RandomSimulator;

import java.util.Random;

public class Sensor implements ISensor{
    // The reading of the pressure value from the sensor is simulated in this implementation.
    // Because the focus of the exercise is on the other class.

    private static final double OFFSET = 16;
    private RandomSimulator randomPressureSampleSimulator;

    public Sensor(RandomSimulator randomPressureSampleSimulator) {
        this.randomPressureSampleSimulator = randomPressureSampleSimulator;
    }

    public double popNextPressurePsiValue() {
        double pressureTelemetryValue = this.readPressureSample();
        return OFFSET + pressureTelemetryValue;
    }

    private double readPressureSample() {
        // Simulate info read from a real sensor in a real tire
        return 6 * randomPressureSampleSimulator.nextDouble() * randomPressureSampleSimulator.nextDouble();
    }
}
