package com.gl.student_management.service.serviceimpl;

import com.gl.student_management.entity.Student;
import com.gl.student_management.repository.StudentRepository;
import com.gl.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = studentRepository.findById(student.getId()).orElseThrow(()->new RuntimeException("Record not found"));
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setCourse(student.getCourse());
        student1.setCountry(student.getCountry());
        return studentRepository.save(student1);
    }

    @Override
    public String deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found"));
        studentRepository.delete(student);
        return "Record deleted successfully";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
