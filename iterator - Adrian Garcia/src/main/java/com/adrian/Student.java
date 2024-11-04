package com.adrian;

// Class to represent a student
public class Student extends Person {
    private int grade;

    public Student(int id, String name, int grade) {
        super(id, name);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grading) {
        this.grade = grading;
    }    
}
