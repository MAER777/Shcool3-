package ru.hogwarts.school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor (String color);
    List<Faculty> findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(
            String color,
            String name);
}
