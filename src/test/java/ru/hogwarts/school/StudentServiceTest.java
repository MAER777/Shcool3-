package ru.hogwarts.school;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.FacultyService;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;


public class StudentServiceTest {
    StudentService serviceTest;

    @BeforeEach
    public void studentList() {
        serviceTest = new StudentService();
        serviceTest.createStudent(new Student(2L, "pupa", 3));
        serviceTest.createStudent(new Student(3L, "pupa", 3));
        serviceTest.createStudent(new Student(4L, "pupa", 3));
        serviceTest.createStudent(new Student(5L, "pupa", 3));
    }

//    @AfterEach
//    public void removeStudentList() {
//        new HashSet<>(serviceTest.getAllStudent().forEach(serviceTest::de);)
//    }

    @Test
    public void addStudentTest() {
        int size = serviceTest.getAllStudent().size();
        Student a = new Student(1L, "fff", 4);
        assertThat(serviceTest.createStudent(a))
                .isEqualTo(a)
                .isIn(serviceTest.getAllStudent());
        assertEquals(size + 1, serviceTest.getAllStudent().size());
    }

    @Test
    public void findStudentPositiveTest() {
        assertEquals(new Student(4l,"pupa", 3), serviceTest.findStudent(4));
    }

    @Test
    public void findStudentNegativeTest() {
        assertNull(serviceTest.findStudent(7));
    }

    @Test
    public void editStudentPositiveTest() {
        Student a = new Student(1L, "fff", 4);
        int size = serviceTest.getAllStudent().size();
        assertEquals(a,serviceTest.editStudent(a));
        assertEquals(size, serviceTest.getAllStudent().size());
    }
    @Test
    public void editStudentNegativeTest() {
        Student a = new Student(55l, "fff", 4);
        int size = serviceTest.getAllStudent().size();
        assertNull(serviceTest.editStudent(a));
        assertEquals(size, serviceTest.getAllStudent().size());
    }

    @Test
    public void removeStudentPositiveTest() {
        Student a = new Student(1L, "pupa", 3);
        int size = serviceTest.getAllStudent().size();
        assertEquals(a, serviceTest.deleteStudent(1l));
        assertEquals(size - 1, serviceTest.getAllStudent().size());
    }

    @Test
    public void removeStudentNegativeTest() {
        int size = serviceTest.getAllStudent().size();
        assertNull(serviceTest.deleteStudent(10));
        assertEquals(size, serviceTest.getAllStudent().size());
    }

    @Test
    public void getStudentAgePositiveTest() {
        Student a = new Student(5l, "fff", 4);
        serviceTest.createStudent(a);
        List<Student> test = List.of(new Student(5l, "ddd", 4), a);
//        assertIterableEquals(test, serviceTest.getAllStudentOfAge(4));
    }

    @Test
    public void getStudentNegativeTest() {
        List<Student> test = Collections.emptyList();
        assertIterableEquals(test, serviceTest.getAllStudentOfAge(4));
    }
}
