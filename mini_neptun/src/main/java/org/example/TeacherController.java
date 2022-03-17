package org.example;

import java.util.*;

public interface TeacherController {
    List<CourseDto> getAllCourseWithStudents(Long TeacherId);
}
