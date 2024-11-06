package com.adrian;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;

// Class to represent a teacher. Can be iterated to check their students one by one
public class Teacher extends Person implements Iterable<Student> {
    private TreeSet<Student> students;

    public Teacher(int id, int birthYear, String name) {
        super(id, birthYear, name);
        students = new TreeSet<>(new StudentGradingComparator());
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    // Iterator with the students
    @Override
    public Iterator<Student> iterator() {
        return new StudentIter(students);
    }

    // Class to compare students by mark.
    private class StudentGradingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getMark() > o2.getMark()) {
                return 1;
            } else if (o1.getMark() < o2.getMark()) {
                return -1;
            } else {
                return 0;
            }
        }
    }    
}
