package ru.hogwarts.school.Dto;

public class StudentDoOut {
    private long id;
    private String name;
    private int age;
    private FacultyDtoOut faculty;
    private String avatarUrl;
//
//    public StudentDoOut(long id, String name, int age, FacultyDtoOut faculty, String avatarUrl) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.faculty = faculty;
//        this.avatarUrl = avatarUrl;
//    }
//
//    public StudentDoOut() {
//
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public FacultyDtoOut getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDtoOut faculty) {
        this.faculty = faculty;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
