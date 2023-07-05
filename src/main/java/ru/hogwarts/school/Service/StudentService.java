package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Dto.StudentDoOut;
import ru.hogwarts.school.Dto.StudentDotIn;
import ru.hogwarts.school.Exception.StudentNotFoundException;
import ru.hogwarts.school.Mapper.StudentMapper;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDoOut createStudent (StudentDotIn studentDotIn) {
        return studentMapper.toDto(
                studentRepository.save(
                        studentMapper.toEntity(studentDotIn)
                )
        );
    }

    public StudentDoOut editStudent (long id, StudentDotIn studentDotIn) {
        return studentRepository.findById(id)
                .map(oldStudent ->{
                    oldStudent.setAge(studentDotIn.getAge());
                    oldStudent.setName(studentDotIn.getName());
                    return studentMapper.toDto(studentRepository.save(oldStudent));
                })
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public StudentDoOut deleteStudent (long id) {
        Student student = studentRepository.findById(id)
                        .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(id);
        return studentMapper.toDto(student);
    }

    public StudentDoOut findStudent (long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<StudentDoOut> getAllStudentOfAge(int age) {
        return Optional.ofNullable(age)
                .map(studentRepository::findByAge)
                .orElseGet(studentRepository::findAll).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<StudentDoOut> getAllStudent() {
        return studentRepository.findAll()
                .stream().map(studentMapper::toDto).toList();
    }
}
