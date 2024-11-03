package com.adrian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

// Class to represent a teacher. Can be iterated to check their students one by one
public class Teacher extends Person implements Iterable<Student> {
    private TreeSet<Student> students;

    public Teacher(int id, String name) {
        super(id, name);
        students = new TreeSet<>(new StudentComparator());
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    // Iterator with the students
    @Override
    public Iterator<Student> iterator() {
        return new StudentIter();
    }

    // Class that creates the iterator for the students
    private class StudentIter implements Iterator<Student> {
        private int index = 0;
        private ArrayList<Student> iterator;

        public StudentIter() {
            iterator = new ArrayList<>(students);
        }

        @Override
        public boolean hasNext() {
            return index < iterator.size();
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There are no more elements in the list");
            }
            // Returns the next element and increments then increments the index
            return iterator.get(index++);
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public Student previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("There are no more elements in the list");
            }
            return iterator.get(index--);
        }
    }

    // Class that defines how to compare Students.
    private class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getGrade() > o2.getGrade()) {
                return 1;
            } else if (o1.getGrade() < o2.getGrade()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
