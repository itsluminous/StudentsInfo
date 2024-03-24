package com.school.studentsInfo.repository;

import com.school.studentsInfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> { }


