package datetime.impl;

import datetime.DatetimeCalculation;
import datetime.PeriodFormat;
import datetime.exception.WrongDatesOrder;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DatetimeCalculationImpl implements DatetimeCalculation {


    @Override
    public long daysBetweenDates(LocalDateTime first, LocalDateTime second) {
        if(!areDatesChronological(first, second)) {
            throw new WrongDatesOrder("Dates are in not chronological order");
        }

        return ChronoUnit.DAYS.between(first, second);
    }

    @Override
    public long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second) {

        return 0;
    }

    @Override
    public long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second) {
        return BigInteger.valueOf(daysBetweenDates(first, second))
                .divide(BigInteger.valueOf(7L))
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
        if(!areDatesChronological(firstDate.atZone(firstZone), secondDate.atZone(secondZone))){
            throw new WrongDatesOrder("Dates are in not chronological order");
        }

        return ChronoUnit.DAYS.between(firstDate.atZone(firstZone), secondDate.atZone(secondZone));
    }

    @Override
    public long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {




        return 0;
    }

    @Override
    public long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate) {
        return BigInteger.valueOf(daysBetweenDates(firstZone, secondZone, firstDate, secondDate))
                .divide(BigInteger.valueOf(7L))
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
                return days * 86400;
            case MINUTES:
                return days * 1440;
            case HOURS:
                return days * 24;
            case YEARS:
                return days / 365;
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
