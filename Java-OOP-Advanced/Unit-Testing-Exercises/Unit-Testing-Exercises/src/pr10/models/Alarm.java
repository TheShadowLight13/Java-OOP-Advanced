package pr10.models;

import pr10.interfaces.IAlarm;
import pr10.interfaces.ISensor;

public class Alarm implements IAlarm{
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private ISensor sensor;
    private boolean alarmOn;

    public Alarm(ISensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;
    }

    @Override
    public void check() {
        double psiPressureValue = this.sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            this.alarmOn = true;
        }
    }

    @Override
    public boolean getAlarmOn() {
        return this.alarmOn;
    }
}
