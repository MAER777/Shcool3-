package ru.hogwarts.school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);

    List<Student> findAllByAgeBetween(int ageFrom, int ageTo);

    List<Student> findAllByFaculty_Id(long facultyId);
}
