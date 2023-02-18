package com.demo.sp3.service;


import com.demo.sp3.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student addStudent(Student student);

    void deleteStudent(Long id);
}
