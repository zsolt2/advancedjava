package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements TeacherService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private final Long teacherID;

    public final int TiredCourseNumberLimit = 10;
    public final int TiredStudentNumberLimit = 10;

    public TeacherServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, Long teacherID) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherID = teacherID;
    }

    @Override
    public List<StudentDto> getMyStudents() {
         List<CourseDto> courseByTeacher =  courseRepository.findByTeacher(teacherID);

         return  studentRepository.findByCousreId(courseByTeacher.stream()
                                                .map(course->course.getId())
                                                .collect(Collectors.toList()));
    }

    @Override
    public boolean shouldBeTired(Long teacherID) {
        return courseRepository.getElementCount(teacherID) > TiredCourseNumberLimit ||
                getMyStudents().size() > TiredStudentNumberLimit;
    }
}
