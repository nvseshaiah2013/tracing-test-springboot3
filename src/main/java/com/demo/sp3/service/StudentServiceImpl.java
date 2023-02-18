package com.demo.sp3.service;

import com.demo.sp3.model.Student;
import com.demo.sp3.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        StudentServiceImpl.log.info("Trying to get Students");
        var students = studentRepository.findAll();
        StudentServiceImpl.log.info("Found {} students", students.size());
        return students;
    }

    public Student addStudent(Student student) {
        StudentServiceImpl.log.info("Inside add student service impl");
        var newStudent = studentRepository.save(student);
        StudentServiceImpl.log.info("Added the student with id : {}", newStudent.getId());
        return newStudent;
    }

    public void deleteStudent(Long id) {
        StudentServiceImpl.log.info("Trying to delete student with Id : {}", id);
        studentRepository
                .findById(id)
                .ifPresentOrElse(studentRepository::delete,
                        () -> StudentServiceImpl.log.error("No Student found with id :{}", id));
    }
}
