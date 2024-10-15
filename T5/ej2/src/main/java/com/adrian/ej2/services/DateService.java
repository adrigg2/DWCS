package com.adrian.ej2.services;

import java.time.LocalDate;
import java.util.ArrayList;

public interface DateService {
    Integer countDays(LocalDate date1, LocalDate date2);
    ArrayList<Integer> countLeapYears(LocalDate date1, LocalDate date2);
    Integer countYearsStartOnSunday(LocalDate date1, LocalDate date2);
}
