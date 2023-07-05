package ru.hogwarts.school.Mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.Dto.FacultyDtoIn;
import ru.hogwarts.school.Dto.FacultyDtoOut;
import ru.hogwarts.school.Dto.StudentDoOut;
import ru.hogwarts.school.Dto.StudentDotIn;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;

@Component
public class StudentMapper {

    public StudentDoOut toDto(Student student) {
        StudentDoOut studentDoOut = new StudentDoOut();
        studentDoOut.setName(student.getName());
        studentDoOut.setAge(student.getAge());
        studentDoOut.setId(student.getId());
        return studentDoOut;
    }

    public Student toEntity (StudentDotIn studentDotIn) {
        Student student = new Student();
        student.setAge(studentDotIn.getAge());
        student.setName(studentDotIn.getName());
        return student;
    }
}
