package datetime;

import org.junit.jupiter.api.AfterEach;
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
    void daysBetweenDates() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 25);

        long result = datetimeCalculation.daysBetweenDates(first, second);

        assertEquals(121, result);
    }

    @Test
    void weekdaysBetweenDates() {

        LocalDateTime first = LocalDateTime.of(2021, 2, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second);

        assertEquals(282, result);
    }

    @Test
    void completeWeeksBetweenDates() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(first, second);

        assertEquals(113, result);
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
    void daysBetweenDatesZone() {
        LocalDateTime first = LocalDateTime.of(2021, 11, 1, 5, 0);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 11, 0);

        long result = datetimeCalculation.daysBetweenDates(firstZoneId,secondZoneId, first, second);

        assertEquals(120, result);
    }

    @Test
    void weekdaysBetweenDatesZone() {

        LocalDateTime first = LocalDateTime.of(2021, 2, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2, 5, 5);

        long result = datetimeCalculation.weekdaysBetweenDates(first, second);

        assertEquals(282, result);
    }

    @Test
    void completeWeeksBetweenDatesZone() {
        LocalDateTime first = LocalDateTime.of(2020, 1, 1, 5, 5);
        LocalDateTime second = LocalDateTime.of(2022, 3, 2,5,5);

        long result = datetimeCalculation.completeWeeksBetweenDates(firstZoneId, secondZoneId, first, second);

        assertEquals(112, result);
    }
}