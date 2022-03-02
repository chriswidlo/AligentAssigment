package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;

public interface DatetimeCalculation {

    long daysBetweenDates(LocalDateTime first, LocalDateTime second);

    long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second);

    long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second);

    long daysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);

    long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);

    long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);

    long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);

    long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);

    long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);

    long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);

    long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);

    long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);

}
