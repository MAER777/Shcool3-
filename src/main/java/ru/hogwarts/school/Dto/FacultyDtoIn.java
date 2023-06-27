package ru.hogwarts.school.Dto;

public class FacultyDtoIn {
    private String name;
    private String color;

    public FacultyDtoIn(long id, String name, String color) {
        this.name = name;
        this.color = color;
    }

    public FacultyDtoIn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}