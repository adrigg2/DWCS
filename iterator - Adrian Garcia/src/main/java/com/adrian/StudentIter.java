package com.adrian;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

// Class that creates the iterator for the students. Provides methods to read the collection both in the standard order and in reverse order
public class StudentIter implements Iterator<Student> {
    private int index = 0;
    private ArrayList<Student> iterator;

    public StudentIter(Collection<Student> students) {
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
        // Returns the next element and then increments the index
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
        // Returns the next element and then decreases the index
        return iterator.get(index--);
    }

    // Sets the iterator index at the end (if it's smaller than half the size of the collection)/start (if it's greater than half the size of the collection) 
    // of the collection to allow for backwards/forward reading
    public void reverseIndex() {
        index = index < (iterator.size() / 2) ? iterator.size() : 0;
    }
}
