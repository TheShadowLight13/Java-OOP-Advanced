package pr10.models;

import pr10.interfaces.ISensor;

import java.util.Random;

public class Sensor implements ISensor{
    // The reading of the pressure value from the sensor is simulated in this implementation.
    // Because the focus of the exercise is on the other class.

    private static final double OFFSET = 16;
    private static Random randomPressureSampleSimulator = new Random();

    private double readPressureSample() {
        // Simulate info read from a real sensor in a real tire
        return 6 * randomPressureSampleSimulator.nextDouble() * randomPressureSampleSimulator.nextDouble();
    }

    @Override
    public double popNextPressurePsiValue() {
        double pressureTelemetryValue = this.readPressureSample();
        return OFFSET + pressureTelemetryValue;
    }
}
