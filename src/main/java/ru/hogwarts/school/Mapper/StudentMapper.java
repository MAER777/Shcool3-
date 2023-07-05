package ru.hogwarts.school.Mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.Dto.StudentDoOut;
import ru.hogwarts.school.Dto.StudentDotIn;
import ru.hogwarts.school.Exception.FacultyNotFoundException;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repositories.FacultyRepository;

import java.util.Optional;

@Component
public class StudentMapper {

    private final FacultyMapper facultyMapper;
    private final FacultyRepository facultyRepository;

    public StudentMapper(FacultyMapper facultyMapper, FacultyRepository facultyRepository) {
        this.facultyMapper = facultyMapper;
        this.facultyRepository = facultyRepository;
    }

    public StudentDoOut toDto(Student student) {
        StudentDoOut studentDoOut = new StudentDoOut();
        studentDoOut.setName(student.getName());
        studentDoOut.setAge(student.getAge());
        studentDoOut.setId(student.getId());
        Optional.ofNullable(student.getFaculty())
                .ifPresent(faculty -> studentDoOut.setFaculty(facultyMapper.toDto(faculty)));
        return studentDoOut;
    }

    public Student toEntity (StudentDotIn studentDotIn) {
        Student student = new Student();
        student.setAge(studentDotIn.getAge());
        student.setName(studentDotIn.getName());
        Optional.ofNullable(studentDotIn.getFacultyId())
                .ifPresent(faultyId ->
                        facultyRepository.findById(faultyId)
                        .orElseThrow(() -> new FacultyNotFoundException(faultyId)));
        return student;
    }
}
