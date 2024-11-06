package com.adrian;

// Class to represent a student
public class Student extends Person {
    private int mark;

    public Student(int id, int birthYear, String name, int mark) {
        super(id, birthYear, name);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int grade) {
        this.mark = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", grade: " + mark;
    }
}
