package ru.hogwarts.school.Controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Dto.FacultyDtoOut;
import ru.hogwarts.school.Dto.FacultyDtoIn;
import ru.hogwarts.school.Service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyDtoOut createFaculty (@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.createFaculty(facultyDtoIn);
    }

    @PutMapping("/id/{id}")
    public FacultyDtoOut editFaculty (Long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.editFaculty(id,facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut getFaculty (@PathVariable Long id) {
        return facultyService.findFacility(id);
    }

    @GetMapping("/color/{color}")
    public List<FacultyDtoOut> getAllFacultyColor(@PathVariable String color) {
        return facultyService.getAllFacultyColor(color);
    }

    @GetMapping
    public List<FacultyDtoOut> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @DeleteMapping("{id}")
    public FacultyDtoOut deleteFaculty (@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }
}
