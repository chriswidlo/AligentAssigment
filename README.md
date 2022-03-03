# AligentAssigment

# Build instructions:

1.Make sure JDK is installed on machine and path to JDK is added to environment variables.

2.Navigate to root folder project.

3.Execute command "gradlew build".

4.Tests are executed during build. Generated JAR package is located in generated folder "build/libs" in project root folder.

# Api definition:

PeriodFormat contains 4 available formats YEARS,HOURS,MINUTES,SECONDS . All of them can be used to convert days to years, hours, minutes, or seconds.

Interface "DatetimeCalculation" represents API and includes all functions.

In all functions first datetime parameter must be chronologically before second datetime parameter.

Funcions definition (all input parameters are required to be non-null):

    1.long daysBetweenDates(LocalDateTime first, LocalDateTime second);
    
        Takes 2 local datetime parameters and returns number of days between them.
    
    2.long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second);
    
        Takes 2 local datetime parameters and returns number of weekdays between them.

    3.long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second);
    
        Takes 2 local datetime parameters and returns number of complete weeks between them.
    
    4.long daysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);

        Takes 2 local datetime parameters and a period format and returns number of days between them represented in period format.
    
    5.long weekdaysBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);

        Takes 2 local datetime parameters and a period format and returns number of weekdays between them represented in period format.
    
    6.long completeWeeksBetweenDates(LocalDateTime first, LocalDateTime second, PeriodFormat periodFormat);
    
        Takes 2 local datetime parameters and a period format and returns number of complete weeks between them represented in period format.
    
    7.long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);
    
        Takes 2 time zone IDs and respectivelly 2 datetime parameters and returns days between them. (first zoneId parameter references to first date, second zoneId refernces to second date)

    8.long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);
    
        Takes 2 time zone IDs and respectivelly 2 datetime parameters and returns number of weekdays between them. (first zoneId parameter references to first date, second zoneId refernces to second date)

    9.long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate);
    
        Takes 2 time zone IDs and respectivelly 2 datetime parameters and returns number of complete weeks between them. (first zoneId parameter references to first date, second zoneId refernces to second date)
    
    10.long daysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);

       Takes 2 time zone IDs and respectivelly 2 datetime parameters and a period format and returns number of days between them represented in period format. (first zoneId parameter references to first date, second zoneId refernce to second date)
        
    11.long weekdaysBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);

       Takes 2 time zone IDs and respectivelly 2 datetime parameters and a period format and returns number of weekdays between them represented in period format. (first zoneId parameter references to first date, second zoneId refernce to second date)
       
    12.long completeWeeksBetweenDates(ZoneId firstZone, ZoneId secondZone, LocalDateTime firstDate, LocalDateTime secondDate, PeriodFormat periodFormat);
    
       Takes 2 time zone IDs and respectivelly 2 datetime parameters and a period format and returns number of complete weeks between them represented in period format. (first zoneId parameter references to first date, second zoneId refernce to second date)
    
   
