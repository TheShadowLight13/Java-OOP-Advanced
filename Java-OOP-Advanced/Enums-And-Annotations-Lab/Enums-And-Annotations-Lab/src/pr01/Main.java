package pr01;

import pr01.interfaces.IWeeklyCalendar;

public class Main {

    public static void main(String[] args) {
        IWeeklyCalendar weeklyCalendar =  new WeeklyCalendar();
        weeklyCalendar.addEntry("Friday", "sleeping");
        weeklyCalendar.addEntry("Monday", "sport");

        for (WeeklyEntry entry : weeklyCalendar.getWeeklySchedule()) {
            System.out.println(entry);
        }
    }
}
