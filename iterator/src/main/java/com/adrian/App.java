package com.adrian;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Teacher teacher = new Teacher(0, "Profe");
        teacher.addStudent(new Student(1, "student1", 5));
        teacher.addStudent(new Student(2, "student2", 10));
        teacher.addStudent(new Student(3, "student3", 2));
        teacher.addStudent(new Student(4, "student4", 6));
        teacher.addStudent(new Student(5, "student5", 1));
        teacher.addStudent(new Student(6, "student6", 4));
        teacher.addStudent(new Student(7, "student7", 3));
        teacher.addStudent(new Student(8, "student8", 8));
        teacher.addStudent(new Student(9, "student9", 7));
        teacher.addStudent(new Student(10, "student10", 5));
        
        // Check every student in teacher and get only the ones with passing grades
        ArrayList<Student> passingStudents = new ArrayList<>();
        teacher.forEach((student) -> {
            if (student.getGrade() >= 5) {
                passingStudents.add(student);
            }
        });

        System.out.println("Students with passing grades:\n");
        passingStudents.forEach((student) -> {
            System.out.println(student);
        });
    }
}
