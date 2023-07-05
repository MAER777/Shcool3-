package ru.hogwarts.school.Dto;

public class StudentDotIn {
    private String name;
    private int age;

    private Long facultyId;

    public StudentDotIn(String name, int age, long facultyId) {
        this.name = name;
        this.age = age;
        this.facultyId = facultyId;
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

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}
