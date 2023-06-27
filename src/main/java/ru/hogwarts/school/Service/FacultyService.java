package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Repositories.FacultyRepository;

import java.util.Collection;

@Service

public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFacility (long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty (long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFacultyColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}
