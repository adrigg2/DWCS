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

    // Class that creates the iterator for the students. Provides methods to read the collection both in the standard order and in reverse order
    public class StudentIter implements Iterator<Student> {
        private int index = 0;
        private ArrayList<Student> iterator;

        public StudentIter() {
            iterator = new ArrayList<>(students);
        }

        // Checks if there are more elements in the iterator
        @Override
        public boolean hasNext() {
            return index < iterator.size();
        }

        // Returns the next element of the iterator
        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There are no more elements in the list");
            }
            // Returns the next element and increments then increments the index
            return iterator.get(index++);
        }

        // Checks if there are more elements in the iterator in reverse order
        public boolean hasPrevious() {
            return index > 0;
        }

        // Returns the previous element of the iterator
        public Student previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("There are no more elements in the list");
            }
            return iterator.get(index--);
        }

        // Sets the iterator index at the end/start of the collection to allow for backwards/forward reading
        public void reverseIndex() {
            index = index == 0 ? iterator.size() : 0;
        }
    }

    // Class to compare students by grading.
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
