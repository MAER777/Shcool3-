package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service

public class FacultyService {
    private final HashMap<Long, Faculty> facultyHashMap = new HashMap<>();

    private long lastId = 0;

    public Faculty createFaculty (Faculty faculty) {
        faculty.setId(++lastId);
        facultyHashMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFacility (long id) {
        return facultyHashMap.get(id);
    }

    public Faculty editFaculty (Faculty faculty) {
        facultyHashMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty (long id) {
        return facultyHashMap.remove(id);
    }

    public Collection<Faculty> getAllFacultyColor(String color) {
        return facultyHashMap.values().stream()
                .filter(student -> student.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyHashMap.values();
    }
}
