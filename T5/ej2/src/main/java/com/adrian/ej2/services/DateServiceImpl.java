package com.adrian.ej2.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService {

    @Override
    public Integer countDays(LocalDate date1, LocalDate date2) {
        return (int)ChronoUnit.DAYS.between(date1, date2);
    }

    @Override
    public ArrayList<Integer> countLeapYears(LocalDate date1, LocalDate date2) {
        int year1 = date1.getYear();
        int year2 = date2.getYear();
        int year = year1;
        while (year % 4 != 0) {
            year++;
        }

        ArrayList<Integer> leapYears = new ArrayList<>();
        for (int i = 0; year + i <= year2; i++) {
            if ((year + i) % 100 != 0 || (year + i) % 400 == 0) {
                leapYears.add(year + i);
            }
        }
        return leapYears;
    }

    @Override
    public Integer countYearsStartOnSunday(LocalDate date1, LocalDate date2) {
        LocalDate januaryOne = LocalDate.of(date1.getYear(), 1, 1);

        int startingSundays = 0;
        while (januaryOne.getYear() != date2.getYear()) {
            if (januaryOne.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                startingSundays++;
            }
        }
        return startingSundays;
    }
    
}
