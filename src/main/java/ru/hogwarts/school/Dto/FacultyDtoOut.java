package ru.hogwarts.school.Dto;

public class FacultyDtoOut {
    private String name;
    private String color;
    private long id;

    public FacultyDtoOut(String name, String color) {
        this.name = name;
        this.color = color;
        this.id = id;
    }

    public FacultyDtoOut() {
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
