package datetime.impl;

import datetime.DatetimeCalculation;
import datetime.PeriodFormat;
import datetime.exception.InvalidArgument;
import datetime.exception.WrongDatesOrder;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DatetimeCalculationImpl implements DatetimeCalculation {

    public static final int DAYS_IN_WEEK = 7;
    public static final int WEEKDAYS_IN_WEEK = 5;
    public static final int SECONDS_IN_DAY = 86400;
    public static final int MINUTES_IN_DAY = 1440;
    public static final int HOURS_IN_DAY = 24;
    public static final int DAYS_IN_YEAR = 365;

    @Override
    public long daysBetweenDates(LocalDateTime first, LocalDateTime second) {
        if (!areArgumentsValid(first, second)) {
            throw new InvalidArgument("Some or all arguments are null. Dates must have non-null value");
        }

        if (!areDatesChronological(first, second)) {
            throw new WrongDatesOrder("Dates are in not chronological order");
        }

        return ChronoUnit.DAYS.between(first, second);
    }

    private boolean areArgumentsValid(LocalDateTime first, LocalDateTime second) {
        return first != null && second != null;
    }

    @Override
    public long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second) {
        long daysBetween = daysBetweenDates(first, second);

        long fullWeeks = daysBetween / DAYS_IN_WEEK;

        long weekdaysBetweenDates = fullWeeks * WEEKDAYS_IN_WEEK;
        DayOfWeek firstDateDayOfWeek = first.getDayOfWeek();


        for (long daysFromNotFullWeek = daysBetween % DAYS_IN_WEEK; daysFromNotFullWeek > 0; daysFromNotFullWeek--) {
            if (firstDateDayOfWeek != DayOfWeek.SATURDAY && firstDateDayOfWeek != DayOfWeek.SUNDAY) {
                weekdaysBetweenDates += 1;
            }
            firstDateDayOfWeek = firstDateDayOfWeek.plus(1);
        }

        return weekdaysBetweenDates;
    }

    @Override
    public long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second) {
        return BigInteger.valueOf(daysBetweenDates(first, second))
                .divide(BigInteger.valueOf(DAYS_IN_WEEK))
                .longValue();
    }

    @Override
    public long daysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, daysBetweenDates(first, second));
    }

    @Override
    public long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, weekdaysBetweenDates(first, second));
    }

    @Override
    public long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, completeWeeksBetweenDates(first, second) * 7);
    }

    @Override
    public long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        if (!areArgumentsValid(firstZone, secondZone, firstDate, secondDate)) {
            throw new InvalidArgument("Some or all arguments are null. Zones and dates must have non-null value");
        }

        if (!areDatesChronological(firstDate.atZone(firstZone), secondDate.atZone(secondZone))) {
            throw new WrongDatesOrder("Dates are in not chronological order");
        }


        return ChronoUnit.DAYS.between(firstDate.atZone(firstZone), secondDate.atZone(secondZone));
    }

    private boolean areArgumentsValid(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        return firstZone != null && secondZone != null && firstDate != null && secondDate != null;
    }

    @Override
    public long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        long daysBetween = daysBetweenDates(firstZone, secondZone, firstDate, secondDate);

        long fullWeeks = daysBetween / DAYS_IN_WEEK;

        long weekdaysBetweenDates = fullWeeks * WEEKDAYS_IN_WEEK;
        //daysBetweenDates() converts dates to localDateTime and then calculates days between so we need to do the same here.
        DayOfWeek firstDateDayOfWeek = firstDate.atZone(firstZone).toLocalDateTime().getDayOfWeek();


        for (long daysFromNotFullWeek = daysBetween % DAYS_IN_WEEK; daysFromNotFullWeek > 0; daysFromNotFullWeek--) {
            if (firstDateDayOfWeek != DayOfWeek.SATURDAY && firstDateDayOfWeek != DayOfWeek.SUNDAY) {
                weekdaysBetweenDates += 1;
            }
            firstDateDayOfWeek = firstDateDayOfWeek.plus(1);
        }

        return weekdaysBetweenDates;
    }

    @Override
    public long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        return BigInteger.valueOf(daysBetweenDates(firstZone, secondZone, firstDate, secondDate))
                .divide(BigInteger.valueOf(DAYS_IN_WEEK))
                .longValue();
    }

    @Override
    public long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, daysBetweenDates(firstZone, secondZone, firstDate, secondDate));
    }

    @Override
    public long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, weekdaysBetweenDates(firstZone, secondZone, firstDate, secondDate));
    }

    @Override
    public long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat) {
        return convertDaysTo(periodFormat, completeWeeksBetweenDates(firstZone, secondZone, firstDate, secondDate));
    }

    private long convertDaysTo(PeriodFormat format, long days) {
        switch (format) {
            case SECONDS:
                return days * SECONDS_IN_DAY;
            case MINUTES:
                return days * MINUTES_IN_DAY;
            case HOURS:
                return days * HOURS_IN_DAY;
            case YEARS:
                return days / DAYS_IN_YEAR;
        }
        return 0;
    }

    private boolean areDatesChronological(LocalDateTime first, LocalDateTime second) {
        return first.isBefore(second);
    }

    private boolean areDatesChronological(ZonedDateTime first, ZonedDateTime second) {
        return first.isBefore(second);
    }

}
