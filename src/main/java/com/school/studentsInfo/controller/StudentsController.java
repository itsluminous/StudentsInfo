package com.school.studentsInfo.controller;

import com.school.studentsInfo.model.Student;
import com.school.studentsInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<Integer> addStudent(@RequestBody Student student){
        try {
            var id = studentService.addStudent(student);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    // invalid email
        }
    }

    @PatchMapping
    public ResponseEntity<Integer> updateStudent(@RequestBody Student student){
        try {
            var id = studentService.updateStudent(student);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    // invalid email
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateStudentWithId(@RequestParam int id, @RequestBody Student student){
        try {
            studentService.updateStudentById(id, student);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    // invalid email
        }
    }
}