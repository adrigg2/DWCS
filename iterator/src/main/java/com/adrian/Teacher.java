package com.adrian;

import java.util.Iterator;
import java.util.LinkedHashSet;

// Class to represent a teacher. Can be iterated to check their students one by one
public class Teacher extends Person implements Iterable<Student> {
    private LinkedHashSet<Student> students;

    public Teacher(int id, String name) {
        super(id, name);
        students = new LinkedHashSet<>();
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
        private Iterator<Student> iterator;

        public StudentIter() {
            iterator = students.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Student next() {
            return iterator.next();
        }        
    }
}
