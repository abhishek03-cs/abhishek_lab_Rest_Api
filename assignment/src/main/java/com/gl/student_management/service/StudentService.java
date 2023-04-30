package com.gl.student_management.service;

import com.gl.student_management.entity.Student;

import java.util.List;

public interface StudentService {
   Student addStudent(Student student);
   Student updateStudent(Student student);

   String deleteById(Long id);

   List<Student> getAllStudents();

}
