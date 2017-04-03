package pr10.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pr10.interfaces.IAlarm;
import pr10.interfaces.ISensor;
import pr10.models.Alarm;

public class AlarmTests {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private IAlarm alarm;
    private ISensor fakeSensor;

    @Before
    public void initializeTestObjects() {
        this.fakeSensor = Mockito.mock(ISensor.class);
        this.alarm = new Alarm(this.fakeSensor);
    }

    @Test
    public void testCtorWithSensorInterface() {
        Assert.assertEquals(false, this.alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithUnderLowPressureThreshold() {
        Mockito.when(this.fakeSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD - 1);
        this.alarm.check();
        Assert.assertEquals(true, this.alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithExceedHighPressureThreshold() {
        Mockito.when(this.fakeSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD + 1);
        this.alarm.check();
        Assert.assertEquals(true, this.alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithEqualsLowPressureThreshold() {
        Mockito.when(this.fakeSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD);
        this.alarm.check();
        Assert.assertEquals(false, this.alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithEqualsHighPressureThreshold() {
        Mockito.when(this.fakeSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);
        this.alarm.check();
        Assert.assertEquals(false, this.alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithPressureInRange() {
        Mockito.when(this.fakeSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD + 1);
        this.alarm.check();
        Assert.assertEquals(false, this.alarm.getAlarmOn());
    }
}
