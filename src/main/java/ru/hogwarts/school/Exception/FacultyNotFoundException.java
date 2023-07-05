package ru.hogwarts.school.Exception;

public class FacultyNotFoundException extends NotFoundException{
    private final long id;

    public FacultyNotFoundException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Факультет с id " + id + " не найден!";
    }
}
