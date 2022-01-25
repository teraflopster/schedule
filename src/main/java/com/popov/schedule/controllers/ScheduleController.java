package com.popov.schedule.controllers;

import com.popov.schedule.models.Day;
import com.popov.schedule.models.Department;
import com.popov.schedule.models.Faculty;
import com.popov.schedule.models.Lecture;
import com.popov.schedule.models.LectureHall;
import com.popov.schedule.models.Lesson;
import com.popov.schedule.models.Student;
import com.popov.schedule.models.StudentGroup;
import com.popov.schedule.models.Teacher;
import com.popov.schedule.models.Theme;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public interface ScheduleController {
    @PostMapping("/faculty")
    void saveFaculty(@RequestBody Faculty faculty);

    @GetMapping("/faculty")
    List<Faculty> findAllFaculty();

    @PostMapping("/teacher")
    void saveTeacher(@RequestBody Teacher teacher);

    @PutMapping("/teacher")
    void updateTeacher(@RequestBody Teacher teacher);

    @DeleteMapping("/teacher")
    void deleteTeacher(@RequestBody Teacher teacher);

    @PostMapping("/theme")
    void saveTheme(@RequestBody Theme theme);

    @PostMapping("/lectureHall")
    void saveLectureHall(@RequestBody LectureHall lectureHall);

    @PostMapping("/lecture")
    void saveLecture(@RequestBody Lecture lecture);

    @PostMapping("/studentGroup")
    void saveStudentGroup(@RequestBody StudentGroup studentGroup);

    @PostMapping("/day")
    void saveDay(@RequestBody Day day);

    @GetMapping("/day")
    List<Day> getDays();

    @GetMapping("/lecture/{dayId}/{id}")
    List<Lesson> getLecture(@PathVariable Long dayId, @PathVariable Long id);

    @GetMapping("/new/student")
    List<StudentGroup> getCreateNewStudent();

    @PostMapping("/new/student")
    void saveStudent(@RequestBody Student student);

//    @GetMapping("/lecture/byUser/{date}/{id}")
//    String getLectureByUser(@PathVariable String date, @PathVariable Long id);

    @GetMapping("/group")
    List<StudentGroup> getGroup();

    @GetMapping("/department/{id}")
    List<Department> getDepartmentByFaculty(@PathVariable Long id);

    @GetMapping("/group/{course}/{departmentId}")
    List<StudentGroup> getStudentGroupByCourseAndDepartmentId(@PathVariable Long course, @PathVariable Long departmentId);
}
