package datetime;

public enum PeriodFormat {
    YEARS,HOURS,MINUTES,SECONDS;

    public static final int SECONDS_IN_DAY = 86400;
    public static final int MINUTES_IN_DAY = 1440;
    public static final int HOURS_IN_DAY = 24;
    public static final int DAYS_IN_YEAR = 365;

    public long convertDaysTo(long days) {
        switch (this) {
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
}
