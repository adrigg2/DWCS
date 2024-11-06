package com.adrian;

import java.util.Comparator;

// Class to compare students by year of birth.
public class StudentYearComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getBirthYear() > o2.getBirthYear()) {
            return 1;
        } else if (o1.getBirthYear() < o2.getBirthYear()) {
            return -1;
        } else {
            return 0;
        }
    }
}
