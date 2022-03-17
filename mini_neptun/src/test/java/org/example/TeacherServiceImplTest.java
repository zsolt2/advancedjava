package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TeacherServiceImplTest {

    @Test
    public void getMyCourseDetails() {
        // GIVEN
        Long teacherID = 1234l;
        StudentRepository studentRepository = mock(StudentRepository.class);

        List<CourseDto> findByTeacherResult = new ArrayList<>();
        findByTeacherResult.add(new CourseDto(1L, "Demo course", new ArrayList<>()));
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findByTeacher(teacherID)).thenReturn(findByTeacherResult);

        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherID);
        List<StudentDto> findByCourseIdResult = new ArrayList<>();
        findByCourseIdResult.add(new StudentDto(1L, "Name 1","ABC123"));
        findByCourseIdResult.add(new StudentDto(1L, "Name 2","ABC124"));
        findByCourseIdResult.add(new StudentDto(1L, "Name 3","ABC125"));
        when(studentRepository.findByCousreId(anyList())).thenReturn(findByCourseIdResult);

        // WHEN
        List<StudentDto> students = teacher.getMyStudents();
        // THEN
        assertEquals(students.size(), 3);
        verify(courseRepository, times(1)).findByTeacher(teacherID);
        verify(studentRepository, times(1)).findByCousreId(anyList());
    }

    @Test
    public void shouldBeTired() {
        // GIVEN
        Long teacherID = 1234l;

        List<CourseDto> findByTeacherResult = new ArrayList<>();
        findByTeacherResult.add(new CourseDto(1L, "Demo course", new ArrayList<>()));
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findByTeacher(teacherID)).thenReturn(findByTeacherResult);

        List<StudentDto> findByCourseIdResult = new ArrayList<>();
        StudentRepository studentRepository = mock(StudentRepository.class);
        findByCourseIdResult.add(new StudentDto(1L, "Name 1","ABC123"));
        findByCourseIdResult.add(new StudentDto(1L, "Name 2","ABC124"));
        findByCourseIdResult.add(new StudentDto(1L, "Name 3","ABC125"));
        when(studentRepository.findByCousreId(anyList())).thenReturn(findByCourseIdResult);
        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherID);


        // WHEN
        assertFalse(teacher.shouldBeTired(teacherID));

    }


    @Test
    public void shouldBeTired_Too_much_course() {
        // GIVEN
        Long teacherID = 1234l;

        List<CourseDto> findByTeacherResult = new ArrayList<>();
        findByTeacherResult.add(new CourseDto(1L, "Demo course", new ArrayList<>()));
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findByTeacher(teacherID)).thenReturn(findByTeacherResult);
        when(courseRepository.getElementCount(teacherID)).thenReturn(100);

        List<StudentDto> findByCourseIdResult = new ArrayList<>();
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.findByCousreId(anyList())).thenReturn(findByCourseIdResult);
        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherID);


        // WHEN
        assertTrue(teacher.shouldBeTired(teacherID));

    }

    @Test
    public void shouldBeTired_TooMuchStudents() {
        // GIVEN
        Long teacherID = 1234l;

        List<CourseDto> findByTeacherResult = new ArrayList<>();
        findByTeacherResult.add(new CourseDto(1L, "Demo course", new ArrayList<>()));

        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findByTeacher(teacherID)).thenReturn(findByTeacherResult);


        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.findByCousreId(anyList())).thenReturn(generateStudents(11));
        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherID);


        // WHEN
        assertTrue(teacher.shouldBeTired(teacherID));

    }

    private List<StudentDto> generateStudents(int numberOfStudents){
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++){
            studentDtoList.add(new StudentDto(Long.valueOf(i), "name "+i, "nc "+i));
        }
        return studentDtoList;
    }
}