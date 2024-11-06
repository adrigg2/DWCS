package com.adrian;

import java.util.TreeSet;

public class App 
{
    public static void main( String[] args )
    {
        // Initialize the Teacher and give them some students
        Teacher teacher = new Teacher(0, 1970, "Profe");
        teacher.addStudent(new Student(1, 2003, "student1", 5));
        teacher.addStudent(new Student(2, 2005, "student2", 10));
        teacher.addStudent(new Student(3, 2004, "student3", 2));
        teacher.addStudent(new Student(4, 1995, "student4", 6));
        teacher.addStudent(new Student(5, 1992, "student5", 1));
        teacher.addStudent(new Student(6, 2000, "student6", 4));
        teacher.addStudent(new Student(7, 1999, "student7", 3));
        teacher.addStudent(new Student(8, 2005, "student8", 8));
        teacher.addStudent(new Student(9, 2003, "student9", 7));
        teacher.addStudent(new Student(10, 2000, "student10", 5));
        
        // Check every student in teacher and print the ones with passing marks in descending order
        System.out.println("\nStudents with passing marks:");
        teacher.forEach((student) -> {
            if (student.getMark() >= 5) {
                System.out.println(student);
            }
        });

        StudentIter iterator = (StudentIter)teacher.iterator();
        iterator.reverseIndex();

        // Check every student in teacher and print them in reversed order of mark
        System.out.println("\nStudents by grade in reverse order:");
        TreeSet<Student> studentsByBirthYear = new TreeSet<>(new StudentYearComparator());
        while (iterator.hasPrevious()) {
            Student student = iterator.previous();
            System.out.println(student);
            studentsByBirthYear.add(student);
        }

        // Check every student in teacher and print them by their birth year in ascending order
        System.out.println("\nStudents by age:");
        studentsByBirthYear.forEach((student) -> {
            System.out.println(student);
        });
    }
}
