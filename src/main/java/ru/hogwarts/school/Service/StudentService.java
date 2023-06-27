package ru.hogwarts.school.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repositories.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent (long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent (Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent (long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudentOfAge(int age) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
