package com.popov.schedule.controllers;

import com.popov.schedule.models.*;
import com.popov.schedule.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ScheduleControllerImpl implements ScheduleController{

    private final FacultyService facultyService;
    private final TeacherService teacherService;
    private final ThemeService themeService;
    private final LectureHallService lectureHallService;
    private final LectureService lectureService;
    private final StudentGroupService studentGroupService;
    private final DayService dayService;
    private final StudentService studentService;
    private final DepartmentService departmentService;

    public ScheduleControllerImpl(FacultyService facultyService, TeacherService teacherService,
                                  ThemeService themeService, LectureHallService lectureHallService,
                                  LectureService lectureService, StudentGroupService studentGroupService,
                                  DayService dayService, StudentService studentService,
                                  DepartmentService departmentService) {
        this.facultyService = facultyService;
        this.teacherService = teacherService;
        this.themeService = themeService;
        this.lectureHallService = lectureHallService;
        this.lectureService = lectureService;
        this.studentGroupService = studentGroupService;
        this.dayService = dayService;
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        facultyService.saveFaculty(faculty);
    }

    @Override
    public List<Faculty> findAllFaculty() {
        return facultyService.findAllFaculty();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        log.info("Teacher {} was saved", teacher);
        teacherService.saveTeacher(teacher);
    }

    @Override
    public void saveTheme(Theme theme) {
        log.info("Theme {} was saved", theme);
        themeService.saveTheme(theme);
    }

    @Override
    public void saveLectureHall(LectureHall lectureHall) {
        log.info("Lecture hall {} was saved", lectureHall);
        lectureHallService.saveLectureHall(lectureHall);
    }

    @Override
    public void saveLecture(Lecture lecture) {
        log.info("Lecture {} was saved", lecture);
        lectureService.saveLecture(lecture);
    }

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {
        log.info("Student group {} was saved", studentGroup);
        studentGroupService.saveStudentGroup(studentGroup);
    }

    @Override
    public void saveDay(Day day) {
        log.info("Day {} was saved", day);
        dayService.saveDay(day);
    }

    @Override
    public List<Day> getDays() {
        return dayService.getAllDays();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherService.getTeacherById(teacher.getId());

        log.info("Teacher with id {}, name {} and department id {} was deleted!",
                teacher.getId(), teacher.getName(), teacher.getDepartmentId());
        teacherService.deleteTeacher(teacher.getId());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        log.info("Teacher with id {} and old name {}, updated with the new name {}",
                teacherService.getTeacherById(teacher.getId()).get().getName(), teacher.getId(), teacher.getName());
        teacherService.updateTeacher(teacher.getName(), teacher.getDepartmentId(), teacher.getId());
    }

    @Override
    public List<Lesson> getLecture(Long dayId, Long id) {
        Optional<Day> dayOptional = dayService.getDayById(dayId);
        List<Lecture> lectures;
        List<Lesson> lessons = new ArrayList<>();
        if (dayOptional.isPresent()){
            Day day = dayOptional.get();
            lectures = lectureService.getLectureByDay(day.getId());
            for (Lecture lecture : lectures) {
                LectureHall lectureHall = lectureHallService.getLectureHallById(lecture.getLectureHallId());
                Optional<Theme> themeOptional = themeService.getThemeById(lecture.getThemeId());
                if (themeOptional.isPresent()) {
                    Teacher teacher = teacherService.getTeacherById(themeOptional.get().getTeacherId()).get();
                    lessons.add(new Lesson(themeOptional.get().getName(), teacher.getName(), lectureHall.getName()));
                    log.info("Date {}, Lecture {}, Teacher {}, Hall {}",
                            day.getLocalDate(), themeOptional.get().getName(), teacher.getName(), lectureHall.getName());
                }
            }
        } else {
            log.info("Day with date null, and group id {}, don't present", id);
        }
        return lessons;
    }

    @Override
    public List<StudentGroup> getCreateNewStudent() {
        return studentGroupService.getAllStudent();
    }

    @Override
    public void saveStudent(Student student) {
        Optional<StudentGroup> studentGroupOptional = studentGroupService.getStudentGroupById(student.getStudentGroupId());
        if (studentGroupOptional.isPresent()) {
            log.info("Student with name {}, and group name {} was saved!", student.getName(), studentGroupOptional.get().getName());
            studentService.saveStudent(student);
        } else {
            log.info("Student with name {} don't saved, because group with id {} don't found!", student.getName(), student.getStudentGroupId());
        }
    }

//    @Override
//    public String getLectureByUser(String date, Long id) {
//        String output = "";
//        Optional<Student> studentOptional = studentService.getStudentById(id);
//        if (studentOptional.isPresent()) {
//            Optional<Day> dayOptional = dayService.getDayByDateAndGroupId(date,
//                    studentOptional.get().getStudentGroupId());
//            if (dayOptional.isPresent()) {
//                List<Lecture> lectures = lectureService.getLectureByDay(dayOptional.get().getId());
//                for (Lecture lecture : lectures) {
//                    output += dayOptional.get().getLocalDate() + " ";
//                    output += themeService.getThemeById(lecture.getTheme_id()).getName() + " ";
//                    output += lectureHallService.getLectureHallById(lecture.getLecture_hall_id()).getName() + "\n";
//                }
//            }
//        }
//        return output;
//    }

    @Override
    public List<StudentGroup> getGroup() {
        return null;
    }

    @Override
    public List<Department> getDepartmentByFaculty(Long id) {
        return departmentService.getAllDepartmentsByFaculty(id);
    }

    @Override
    public List<StudentGroup> getStudentGroupByCourseAndDepartmentId(Long course, Long departmentId) {
        return studentGroupService.getGroupByCourseAndDepartment(course, departmentId);
    }
}
