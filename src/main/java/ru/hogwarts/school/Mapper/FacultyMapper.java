package ru.hogwarts.school.Mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.Dto.FacultyDtoIn;
import ru.hogwarts.school.Dto.FacultyDtoOut;
import ru.hogwarts.school.Entity.Faculty;

@Component
public class FacultyMapper {
    public FacultyDtoOut toDto(Faculty faculty) {
        FacultyDtoOut facultyDtoOut = new FacultyDtoOut();
        facultyDtoOut.setName(faculty.getName());
        facultyDtoOut.setColor(faculty.getColor());
        facultyDtoOut.setId(faculty.getId());
        return facultyDtoOut;
    }

    public Faculty toEntity (FacultyDtoIn facultyDtoIn) {
        Faculty faculty = new Faculty();
        faculty.setColor(facultyDtoIn.getColor());
        faculty.setName(facultyDtoIn.getName());
        return faculty;
    }
}
