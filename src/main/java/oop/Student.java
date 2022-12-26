package oop;

import java.util.Objects;

public class Student {
    String name;
    int number;
    int birthYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthYear=" + birthYear +
                '}';
    }

    public Student(String name, int number, int birthYear) {
        this.name = name;
        this.number = number;
        this.birthYear = birthYear;



    }

    public static void main(String[] args) {
        Student student1 = new Student("김아무개", 11, 1996);
        Student student2 = new Student("박아무개", 20, 1996);
        Student student3 = new Student("최아무개", 11, 1996);

        System.out.println(student1.toString());
        System.out.println(student2.toString());


        boolean equals1 = student1.equals(student3);
        System.out.println(equals1);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());
    }
}
