package com.gl.student_management.controller;

import com.gl.student_management.entity.Student;
import com.gl.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(Student student){
        return studentService.addStudent(student);
    }

    @PutMapping
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "student with idn "+student.getId()+" updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        studentService.deleteById(id);
        return "student with id "+id+" deleted";
    }

    @GetMapping
    public List<Student> listAll(){
        return studentService.getAllStudents();
    }


}
