package ru.hogwarts.school.Dto;

public class StudentDotIn {
    private String name;
    private int age;

    public StudentDotIn(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentDotIn() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
