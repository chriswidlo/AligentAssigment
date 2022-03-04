package datetime;

import datetime.impl.DatetimeCalculationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class DatetimeCalculationTest {
    DatetimeCalculation datetimeCalculation;
    ZoneId firstZoneId;
    ZoneId secondZoneId;

    @BeforeEach
    void setUp() {
        datetimeCalculation = new DatetimeCalculationImpl();
        firstZoneId = ZoneId.of("Europe/Paris");
        secondZoneId = ZoneId.of("Asia/Tokyo");
    }

    @Test
    void testDaysBetweenDatesPastToPast() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 25);

        long result = datetimeCalculation.daysBetweenDates(first, second);

        assertEquals(121, result);
    }

    @Test
    void testDaysBetweenDatesPastToFuture() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.daysBetweenDates(first, second);

        assertEquals(537, result);
    }

    @Test
    void testWeekdaysBetweenPastToPast() {

        LocalDateTime first = LocalDateTime.of(2021, 2, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second);

        assertEquals(282, result);
    }

    @Test
    void testWeekdaysBetweenDatesPastToFuture() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second);

        assertEquals(383, result);
    }

    @Test
    void testWeekdaysBetweenDatesPastToFutureFormatSeconds() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second,PeriodFormat.SECONDS);

        assertEquals(33091200, result);
    }

    @Test
    void testWeekdaysBetweenDatesPastToFutureFormatMinutes() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second,PeriodFormat.MINUTES);

        assertEquals(551520, result);
    }

    @Test
    void testWeekdaysBetweenDatesPastToFutureHours() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second,PeriodFormat.HOURS);

        assertEquals(9192, result);
    }

    @Test
    void testWeekdaysBetweenDatesPastToFutureYears() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second,PeriodFormat.YEARS);

        assertEquals(1, result);
    }


    @Test
    void testCompleteWeeksBetweenDatesPastToPast() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second);

        assertEquals(113, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesPastToPastFormatSeconds() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second,PeriodFormat.SECONDS);

        assertEquals(68342400, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesPastToPastFormatMinutes() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second,PeriodFormat.MINUTES);

        assertEquals(1139040, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesPastToPastFormatHours() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second,PeriodFormat.HOURS);

        assertEquals(18984, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesPastToPastFormatYears() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second,PeriodFormat.YEARS);

        assertEquals(2, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesPastToFuture() {
        LocalDateTime first = LocalDateTime.of(2022, 3, 2, 5, 5);
        LocalDateTime second = LocalDateTime.of(2023, 8, 21, 5, 5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second);

        assertEquals(76, result);
    }

    @Test
    void testDaysBetweenDatesFormatSeconds() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.daysBetweenDates(first, second,PeriodFormat.SECONDS);

        assertEquals(10454400, result);
    }

    @Test
    void testDaysBetweenDatesFormatMinutes() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.daysBetweenDates(first, second,PeriodFormat.MINUTES);

        assertEquals(174240, result);
    }

    @Test
    void testDaysBetweenDatesFormatHours() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.daysBetweenDates(first, second,PeriodFormat.HOURS);

        assertEquals(2904, result);
    }

    @Test
    void testDaysBetweenDatesFormatYears() {
        LocalDateTime first = LocalDateTime.of(2018, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.daysBetweenDates(first, second,PeriodFormat.YEARS);

        assertEquals(3, result);
    }


    @Test
    void testDaysBetweenDatesWithZone() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second);

        assertEquals(120, result);
    }

    @Test
    void testDaysBetweenDatesWithZoneFormatSeconds() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.SECONDS);

        assertEquals(10368000, result);
    }

    @Test
    void testDaysBetweenDatesWithZoneFormatMinutes() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.MINUTES);

        assertEquals(172800, result);
    }

    @Test
    void testDaysBetweenDatesWithZoneHours() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.HOURS);

        assertEquals(2880, result);
    }

    @Test
    void testDaysBetweenDatesWithZoneYears() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.YEARS);

        assertEquals(0, result);
    }

    @Test
    void testWeekdaysBetweenDatesWithZone() {

        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.weekdaysBetweenDates(firstZoneId,secondZoneId, first, second);

        assertEquals(86, result);
    }

    @Test
    void testWeekdaysBetweenDatesWithZoneFormatSeconds() {

        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.weekdaysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.SECONDS);

        assertEquals(7430400, result);
    }

    @Test
    void testWeekdaysBetweenDatesWithZoneFormatMinutes() {

        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.weekdaysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.MINUTES);

        assertEquals(123840, result);
    }

    @Test
    void testWeekdaysBetweenDatesWithZoneFormatHours() {

        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.weekdaysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.HOURS);

        assertEquals(2064, result);
    }

    @Test
    void testWeekdaysBetweenDatesWithZoneFormatYears() {

        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.weekdaysBetweenDates(firstZoneId,secondZoneId, first, second,PeriodFormat.YEARS);

        assertEquals(0, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesWithZone() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second);

        assertEquals(112, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesWithZoneFormatSeconds() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second,PeriodFormat.SECONDS);

        assertEquals(67737600, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesWithZoneFormatMinutes() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second,PeriodFormat.MINUTES);

        assertEquals(1128960, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesWithZoneFormatHours() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second,PeriodFormat.HOURS);

        assertEquals(18816, result);
    }

    @Test
    void testCompleteWeeksBetweenDatesWithZoneFormatYears() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second,PeriodFormat.YEARS);

        assertEquals(2, result);
    }
}