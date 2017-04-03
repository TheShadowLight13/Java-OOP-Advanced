package pr10.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pr10.interfaces.ISensor;
import pr10.interfaces.RandomSimulator;
import pr10.models.Sensor;

public class SensorTests {

    private static final double OFFSET = 16;

    private ISensor sensor;
    private RandomSimulator randomSimulator;

    @Before
    public void initializeTestObjects() {
        this.randomSimulator = Mockito.mock(RandomSimulator.class);
        this.sensor = new Sensor(this.randomSimulator);
    }

    @Test
    public void testPopNextPressurePsiValueWorksFine() {
        Mockito.when(this.randomSimulator.nextDouble()).thenReturn(0.25);
        double nextPressurePsiValue = this.sensor.popNextPressurePsiValue();
        Assert.assertEquals(16.375, nextPressurePsiValue, 0.001);
    }
}
