package com.demo.sp3.resource;

import com.demo.sp3.model.Student;
import com.demo.sp3.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity
                .ok()
                .body(studentService.getStudents());
    }

    @PostMapping("/")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        StudentResource.log.info("Trying to add Student: {}", student);
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
