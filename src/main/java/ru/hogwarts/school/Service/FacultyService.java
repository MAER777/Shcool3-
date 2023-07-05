package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Dto.FacultyDtoIn;
import ru.hogwarts.school.Dto.FacultyDtoOut;
import ru.hogwarts.school.Exception.FacultyNotFoundException;
import ru.hogwarts.school.Mapper.FacultyMapper;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Repositories.FacultyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public FacultyService(FacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    public FacultyDtoOut createFaculty (FacultyDtoIn facultyDtoIn) {
        return facultyMapper.toDto(
                facultyRepository.save(
                        facultyMapper.toEntity(facultyDtoIn)));
    }


    public FacultyDtoOut editFaculty (Long id, FacultyDtoIn facultyDtoIn) {
        return facultyRepository.findById(id)
                .map(oldFaculty -> {
                    oldFaculty.setColor(facultyDtoIn.getColor());
                    oldFaculty.setName(facultyDtoIn.getName());
                    return facultyMapper.toDto(facultyRepository.save(oldFaculty));
                })
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }


    public FacultyDtoOut deleteFaculty (long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.delete(faculty);
        return facultyMapper.toDto(faculty);
    }

    public FacultyDtoOut findFacility (long id) {
        return facultyRepository.findById(id)
                .map(facultyMapper::toDto)
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public List<FacultyDtoOut> getAllFacultyColor(String color) {
        return Optional.ofNullable(color)
                .map(facultyRepository::findByColor)
                .orElseGet(facultyRepository::findAll).stream()
                .map(facultyMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<FacultyDtoOut> getAllFaculty() {
        return facultyRepository.findAll()
                .stream().map(facultyMapper::toDto).toList();
    }
}
