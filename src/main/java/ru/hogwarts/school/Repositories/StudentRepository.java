package ru.hogwarts.school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
}
