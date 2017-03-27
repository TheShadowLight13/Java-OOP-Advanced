package pr01;

import pr01.interfaces.IWeeklyCalendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar implements IWeeklyCalendar{

    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void addEntry(String weekday, String notes) {
        WeeklyEntry entry = new WeeklyEntry(weekday, notes);
        this.entries.add(entry);
    }

    @Override
    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(this.entries, WeeklyEntry.BY_WEEKDAY);
        return entries;
    }
}
