package ru.hogwarts.school.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service

public class StudentService {
    private final HashMap<Long, Student> studentHashMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent (Student student) {
        student.setId(++lastId);
        studentHashMap.put(lastId, student);
        return student;
    }

    public Student findStudent (long id) {
        return  studentHashMap.get(id);
    }

    public Student editStudent (Student student) {
        if (studentHashMap.containsKey(student.getId())) {
            studentHashMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent (long id) {
        return studentHashMap.remove(id);
    }

    public Collection<Student> getAllStudentOfAge(int age) {
        return studentHashMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    public Collection<Student> getAllStudent() {
        return studentHashMap.values();
    }
}
