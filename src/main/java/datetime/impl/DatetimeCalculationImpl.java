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
import java.time.temporal.Temporal;
import java.util.Objects;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class DatetimeCalculationImpl implements DatetimeCalculation {

    public static final int DAYS_IN_WEEK = 7;
    public static final int WEEKDAYS_IN_WEEK = 5;

    @Override
    public long daysBetweenDates(LocalDateTime first, LocalDateTime second) {
        if (!areArgumentsValid(first, second)) {
            throw new InvalidArgument("Some or all arguments are null. Dates must have non-null value");
        }

        if (!areDatesChronological(first, second)) {
            throw new WrongDatesOrder("Dates are in not chronological order");
        }

        return daysBetweenTemporals(first, second);
    }

    private long daysBetweenTemporals(Temporal first, Temporal second) {
        return ChronoUnit.DAYS.between(first, second);
    }

    private boolean areArgumentsValid(LocalDateTime first, LocalDateTime second) {
        return first != null && second != null;
    }

    @Override
    public long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second) {
        long daysBetween = daysBetweenDates(first, second);
        return calculateWeekdaysBetweenDates(first.getDayOfWeek(), daysBetween);
    }

    @Override
    public long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second) {
        return BigInteger.valueOf(daysBetweenDates(first, second))
                .divide(BigInteger.valueOf(DAYS_IN_WEEK))
                .longValue();
    }

    @Override
    public long daysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(daysBetweenDates(first, second));
    }

    @Override
    public long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(weekdaysBetweenDates(first, second));
    }

    @Override
    public long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat) {
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(completeWeeksBetweenDates(first, second) * 7);
    }

    @Override
    public long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        if (!areArgumentsValid(firstZone, secondZone, firstDate, secondDate)) {
            throw new InvalidArgument("Some or all arguments are null. Zones and dates must have non-null value");
        }
        if (!areDatesChronological(firstDate.atZone(firstZone), secondDate.atZone(secondZone))) {
            throw new WrongDatesOrder("Dates are in not chronological order");
        }
        return daysBetweenTemporals(firstDate.atZone(firstZone), secondDate.atZone(secondZone));
    }

    private boolean areArgumentsValid(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        return firstZone != null && secondZone != null && areArgumentsValid(firstDate, secondDate);
    }

    @Override
    public long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        long daysBetween = daysBetweenDates(firstZone, secondZone, firstDate, secondDate);
        //daysBetweenDates() converts dates to localDateTime and then calculates days between so we need to do the same here.
        return calculateWeekdaysBetweenDates(firstDate.atZone(firstZone).toLocalDateTime().getDayOfWeek(), daysBetween);
    }

    private long calculateWeekdaysBetweenDates(DayOfWeek firstDateDayOfWeek, long daysBetween) {
        long fullWeeks = daysBetween / DAYS_IN_WEEK;

        long weekdaysBetweenDates = fullWeeks * WEEKDAYS_IN_WEEK;

        for (long daysFromNotFullWeek = daysBetween % DAYS_IN_WEEK; daysFromNotFullWeek > 0; daysFromNotFullWeek--) {
            if (firstDateDayOfWeek != SATURDAY && firstDateDayOfWeek != SUNDAY) {
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
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(daysBetweenDates(firstZone, secondZone, firstDate, secondDate));
    }

    @Override
    public long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat) {
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(weekdaysBetweenDates(firstZone, secondZone, firstDate, secondDate));
    }

    @Override
    public long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat) {
        if (periodFormat == null) {
            throw new InvalidArgument("Period format can't be null, but it was");
        }
        return periodFormat.convertDaysTo(completeWeeksBetweenDates(firstZone, secondZone, firstDate, secondDate) * 7);
    }

    private boolean areDatesChronological(LocalDateTime first, LocalDateTime second) {
        return first.isBefore(second);
    }

    private boolean areDatesChronological(ZonedDateTime first, ZonedDateTime second) {
        return first.isBefore(second);
    }

}
