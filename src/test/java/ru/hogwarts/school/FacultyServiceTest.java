//package ru.hogwarts.school;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import ru.hogwarts.school.Dto.FacultyDtoIn;
//import ru.hogwarts.school.Dto.FacultyDtoOut;
//import ru.hogwarts.school.Mapper.FacultyMapper;
//import ru.hogwarts.school.Mapper.StudentMapper;
//import ru.hogwarts.school.Model.Faculty;
//import ru.hogwarts.school.Repositories.FacultyRepository;
//import ru.hogwarts.school.Repositories.StudentRepository;
//import ru.hogwarts.school.Service.FacultyService;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class FacultyServiceTest {
//
//    private FacultyRepository facultyRepository;
//    private FacultyService facultyService;
//
//    @BeforeEach
//    public void  beforeEach() {
//        facultyRepository = mock(FacultyRepository.class);
//        FacultyMapper facultyMapper = new FacultyMapper();
//        facultyService = new FacultyService(
//                facultyRepository,
//                mock(StudentRepository.class),
//                facultyMapper,
//                new StudentMapper(facultyMapper, facultyRepository)
//        );
//    }
//
//    @Test
//    public void createTest() {
//        FacultyDtoIn facultyDtoIn = new FacultyDtoIn();
//        facultyDtoIn.setName("name");
//        facultyDtoIn.setColor("color");
//
//        Faculty faculty = new Faculty();
//        faculty.setId(1L);
//        faculty.setName("name");
//        faculty.setColor("color");
//
//        FacultyDtoOut expected = new FacultyDtoOut();
//        expected.setId(1L);
//        facultyDtoIn.setName("name");
//        facultyDtoIn.setColor("color");
//
//        when(facultyRepository.save(any())).thenReturn(faculty);
//
//        FacultyDtoOut actual = facultyService.createFaculty(facultyDtoIn);
//
//        assertThat(actual)
//                .usingRecursiveComparison()
//                .isEqualTo(expected);
//    }
////    FacultyService serviceTest;
////
////    @BeforeEach
////    public void facultyList() {
////        serviceTest = new FacultyService();
////        serviceTest.createFaculty(new Faculty(2L, "pupa", "red"));
////        serviceTest.createFaculty(new Faculty(3L, "pupa", "red"));
////        serviceTest.createFaculty(new Faculty(4L, "pupa", "red"));
////        serviceTest.createFaculty(new Faculty(5L, "pupa", "black"));
////    }
////
//////    @AfterEach
//////    public void removeStudentList() {
//////        new HashSet<>(serviceTest.getAllStudent().forEach(serviceTest::de);)
//////    }
////
////    @Test
////    public void addFacultyTest() {
////        int size = serviceTest.getAllFaculty().size();
////        Faculty a = new Faculty(1L, "fff", "black");
////        assertThat(serviceTest.createFaculty(a))
////                .isEqualTo(a)
////                .isIn(serviceTest.getAllFaculty());
////        assertEquals(size + 1, serviceTest.getAllFaculty().size());
////    }
////
////    @Test
////    public void findFacultyPositiveTest() {
////        assertEquals(new Faculty(1l,"pupa", "red"), serviceTest.findFacility(1));
////    }
////
////    @Test
////    public void findFacultyNegativeTest() {
////        assertNull(serviceTest.findFacility(7));
////    }
////
////    @Test
////    public void editFacultyPositiveTest() {
////        Faculty a = new Faculty(1L, "fff", "red");
////        int size = serviceTest.getAllFaculty().size();
////        assertEquals(a,serviceTest.editFaculty(a));
////        assertEquals(size, serviceTest.getAllFaculty().size());
////    }
////    @Test
////    public void editFacultyNegativeTest() {
////        Faculty a = new Faculty(1l, "pupa", "red");
//////        int size = serviceTest.getAllFaculty().size();
//////        assertNull(serviceTest.editFaculty(a));
//////        assertEquals(size, serviceTest.getAllFaculty().size());
////    }
////
////    @Test
////    public void removeFacultyPositiveTest() {
////        Faculty a = new Faculty(1L, "pupa", "red");
////        int size = serviceTest.getAllFaculty().size();
////        assertEquals(a, serviceTest.deleteFaculty(1l));
////        assertEquals(size - 1, serviceTest.getAllFaculty().size());
////    }
////
////    @Test
////    public void removeFacultyNegativeTest() {
////        int size = serviceTest.getAllFaculty().size();
////        assertNull(serviceTest.deleteFaculty(10));
////        assertEquals(size, serviceTest.getAllFaculty().size());
////    }
////
////    @Test
////    public void getFacultyAgePositiveTest() {
////        Faculty a = new Faculty(5l, "fff", "red");
////        serviceTest.createFaculty(a);
////        List<Faculty> test = List.of(new Faculty(5l, "ddd", "red"), a);
//////        assertIterableEquals(test, serviceTest.getAllStudentOfAge(4));
////    }
////
////    @Test
////    public void getFacultyNegativeTest() {
////        List<Faculty> test = Collections.emptyList();
////        assertIterableEquals(test, serviceTest.getAllFacultyColor("tt"));
////    }
//}
