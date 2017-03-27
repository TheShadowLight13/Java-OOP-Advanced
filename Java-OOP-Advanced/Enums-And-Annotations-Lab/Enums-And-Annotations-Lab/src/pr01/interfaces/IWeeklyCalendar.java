package pr01.interfaces;

import pr01.WeeklyEntry;

public interface IWeeklyCalendar {
    void addEntry(String weekday, String notes);

    Iterable<WeeklyEntry> getWeeklySchedule();
}
