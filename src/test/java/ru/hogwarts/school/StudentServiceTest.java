package ru.hogwarts.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repositories.StudentRepository;
import ru.hogwarts.school.Service.StudentService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    StudentService out;
    private final Collection<Student> students = Set.of(
            new Student(1L, "aaa", 15),
            new Student(2L, "sss", 17),
            new Student(3L, "ddd", 15),
            new Student(4L, "fff", 17),
            new Student(5L, "ggg", 19)
    );

//    @Test
//    void addStudentTest() {
//        Student a = new Student(1L, "ddd", 20);
//        when(repository.save(a)).thenReturn(a);
//        assertEquals(a, out.createStudent(a));
//    }
//
//    @Test
//    void findStudentByIdPositiveTest() {
//        Student a = new Student(2L, "sss", 17);
//        when(repository.findById(2L)).thenReturn(Optional.of(a));
//        assertEquals(a, out.findStudent(2L));
//    }
//
//    @Test
//    void findStudentByIdNegativeTest() {
//        Student a = new Student(2L, "sss", 17);
//        assertNull(repository.findById(10L));
//    }
//    StudentService serviceTest;
//
//    @BeforeEach
//    public void studentList() {
//        serviceTest = new StudentService(studentRepository);
//        serviceTest.createStudent(new Student(2L, "pupa", 3));
//        serviceTest.createStudent(new Student(3L, "pupa", 3));
//        serviceTest.createStudent(new Student(4L, "pupa", 3));
//        serviceTest.createStudent(new Student(5L, "pupa", 3));
//    }
//
////    @AfterEach
////    public void removeStudentList() {
////        new HashSet<>(serviceTest.getAllStudent().forEach(serviceTest::de);)
////    }
//
//    @Test
//    public void addStudentTest() {
//        int size = serviceTest.getAllStudent().size();
//        Student a = new Student(1L, "fff", 4);
//        assertThat(serviceTest.createStudent(a))
//                .isEqualTo(a)
//                .isIn(serviceTest.getAllStudent());
//        assertEquals(size + 1, serviceTest.getAllStudent().size());
//    }
//
//    @Test
//    public void findStudentPositiveTest() {
//        assertEquals(new Student(4l,"pupa", 3), serviceTest.findStudent(4));
//    }
//
//    @Test
//    public void findStudentNegativeTest() {
//        assertNull(serviceTest.findStudent(7));
//    }
//
//    @Test
//    public void editStudentPositiveTest() {
//        Student a = new Student(1L, "fff", 4);
//        int size = serviceTest.getAllStudent().size();
//        assertEquals(a,serviceTest.editStudent(a));
//        assertEquals(size, serviceTest.getAllStudent().size());
//    }
//    @Test
//    public void editStudentNegativeTest() {
//        Student a = new Student(55l, "fff", 4);
//        int size = serviceTest.getAllStudent().size();
//        assertNull(serviceTest.editStudent(a));
//        assertEquals(size, serviceTest.getAllStudent().size());
//    }
//
//    @Test
//    public void removeStudentPositiveTest() {
//        Student a = new Student(1L, "pupa", 3);
//        int size = serviceTest.getAllStudent().size();
//        assertEquals(a, serviceTest.deleteStudent(1l));
//        assertEquals(size - 1, serviceTest.getAllStudent().size());
//    }
//
//    @Test
//    public void removeStudentNegativeTest() {
//        int size = serviceTest.getAllStudent().size();
//        assertNull(serviceTest.deleteStudent(10));
//        assertEquals(size, serviceTest.getAllStudent().size());
//    }
//
//    @Test
//    public void getStudentAgePositiveTest() {
//        Student a = new Student(5l, "fff", 4);
//        serviceTest.createStudent(a);
//        List<Student> test = List.of(new Student(5l, "ddd", 4), a);
////        assertIterableEquals(test, serviceTest.getAllStudentOfAge(4));
//    }
//
//    @Test
//    public void getStudentNegativeTest() {
//        List<Student> test = Collections.emptyList();
//        assertIterableEquals(test, serviceTest.getAllStudentOfAge(4));
//    }
}
