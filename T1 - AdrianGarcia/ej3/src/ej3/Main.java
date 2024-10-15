package ej3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(6);
        persons.add(new Person("12345678A", "Juan", 15));
        persons.add(new Person("23456789B", "Pepe", 17));
        persons.add(new Person("34567891C", "Jaime", 25));
        persons.add(new Person("45678912D", "David", 13));
        persons.add(new Person("56789123E", "Palo", 19));
        persons.add(new Person("67891234F", "Adrián", 54));

        System.out.println(getOldestPersonAge(persons));
        System.out.println(getAvgAge(persons));
        System.out.println(getOldestPersonName(persons));
        System.out.println(getOldestPerson(persons));
        System.out.println(getAdults(persons).size());
        System.out.println(getOlderThanAvg(persons).size());
    }

    public static int getOldestPersonAge(ArrayList<Person> persons) {
        Person oldest = getOldestPerson(persons);
        return oldest.getAge();
    }

    public static int getAvgAge(ArrayList<Person> persons) {
        int totalAge = 0;
        int numPersons = persons.size();
        
        for (Person person : persons) {
            totalAge += person.getAge();
        }
        
        return totalAge / numPersons;
    }

    public static String getOldestPersonName(ArrayList<Person> persons) {
        Person oldest = getOldestPerson(persons);
        return oldest.getName();
    }

    public static Person getOldestPerson(ArrayList<Person> persons) {
        Person oldest = persons.get(0);
        for (Person person : persons) {
            if (person.getAge() > oldest.getAge()) {
                oldest = person;
            }
        }
        return oldest;
    }

    public static ArrayList<Person> getAdults(ArrayList<Person> persons) {
        ArrayList<Person> adults = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() >= 18) {
                adults.add(person);
            }
        }
        return adults;
    }

    public static ArrayList<Person> getOlderThanAvg(ArrayList<Person> persons) {
        ArrayList<Person> olderThanAvg = new ArrayList<>();
        int avgAge = getAvgAge(persons);
        for (Person person : persons) {
            if (person.getAge() > avgAge) {
                olderThanAvg.add(person);
            }
        }
        return olderThanAvg;
    }
}