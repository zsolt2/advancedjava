package org.example;

import java.util.List;

public interface StudentRepository {
    List<StudentDto> findByCousreId(List<Long> courseIdList);
}
