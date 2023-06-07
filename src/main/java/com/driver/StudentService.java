package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        return studentRepository.addStudent(student);

    }

    public String addTeacher(Teacher teacher) {
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String Student, String Teacher) {
        return studentRepository.addStudentTeacherPair(Student, Teacher);
    }

    public String getStudentByName(String student) {
        return studentRepository.getStudentByName(student);
    }

    public String getTeacherByName(String teacher) {
        return studentRepository.getTeacherByName(teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentsByTeacherName(teacher);

    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteTeacherByName(String teacher) {
        return studentRepository.deleteTeacherByName(teacher);
    }

    public String deleteAllTeachers() {
        return studentRepository.deleteAllTeachers();
    }

}
