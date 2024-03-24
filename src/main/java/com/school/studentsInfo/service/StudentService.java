package com.school.studentsInfo.service;

import com.school.studentsInfo.model.Student;
import com.school.studentsInfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Component
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Integer addStudent(Student student) {
        if(student.getEmailId().contains("outlook"))
            throw new IllegalArgumentException("Invalid email id");

        var s = studentRepository.save(student);
        return s.getId();
    }

    public Integer updateStudent(Student student) {
        if(student.getEmailId().contains("outlook"))
            throw new IllegalArgumentException("Invalid email id");
        var old = studentRepository.findById(student.getId());

        old.ifPresentOrElse(
                s -> {
                    s.setEmailId(student.getEmailId());
                    s.setName(student.getName());
                    studentRepository.save(s);
                },
                () -> {
                    throw new IllegalArgumentException();
                }
        );

        return old.get().getId();
    }

    public void updateStudentById(int id, Student student) {
        if(student.getEmailId().contains("outlook"))
            throw new IllegalArgumentException("Invalid email id");
        var old = studentRepository.findById(id);

        old.ifPresentOrElse(
                s -> {
                    s.setEmailId(student.getEmailId());
                    s.setName(student.getName());
                    studentRepository.save(s);
                },
                () -> {
                    throw new IllegalArgumentException();
                }
        );
    }
}
