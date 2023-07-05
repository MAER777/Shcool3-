package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Dto.FacultyDtoOut;
import ru.hogwarts.school.Dto.StudentDoOut;
import ru.hogwarts.school.Dto.StudentDotIn;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDoOut createStudent (@RequestBody StudentDotIn studentDotIn) {
        return  studentService.createStudent(studentDotIn);
    }

    @PutMapping("{id}")
    public StudentDoOut editStudent (@PathVariable Long id, @RequestBody StudentDotIn studentDotIn) {
        return  studentService.editStudent(id, studentDotIn);
    }

    @GetMapping("{id}")
    public StudentDoOut getStudentInfo (@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @GetMapping("/age/{age}")
    public List<StudentDoOut> getAllStudentOfAge(@PathVariable Integer age) {
        return studentService.getAllStudentOfAge(age);
    }

    @GetMapping
    public List<StudentDoOut> getAllStudent() {
        return studentService.getAllStudent();
    }

    @DeleteMapping("{id}")
    public StudentDoOut deleteStudent (@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/filter")
    public List<StudentDoOut> findByAgeBetween (@RequestParam int ageFrom, @RequestParam int ageTo) {
        return studentService.findAgeBetween(ageFrom, ageTo);
    }

    @GetMapping("/{id}/faculty")
    public FacultyDtoOut findFaculty(@PathVariable ("id") long id) {
        return studentService.findFaculty(id);
    }
}
