package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentdb = new HashMap<>();
    HashMap<String, Teacher> teacherdb = new HashMap<>();
    HashMap<String, String> Pairdb = new HashMap<>();

    public String addStudent(Student student) {
        String ans = student.getName();
        studentdb.put(ans, student);
        return "new Student added Successfully";

    }

    public String addTeacher(Teacher teacher) {
        String ans = teacher.getName();
        teacherdb.put(ans, teacher);
        return "new Teacher added Successfully";
    }

    public String addStudentTeacherPair(String Student, String Teacher) {
        Pairdb.put(Student, Teacher);
        return "The student teacher pair added successfully";
    }

    public String getStudentByName(String student) {
        if (studentdb.containsKey(student)) {
            return student;
        }
        return "the Student name get successfully from the database";
    }

    public String getTeacherByName(String teacher) {
        if (studentdb.containsKey(teacher)) {
            return teacher;
        }
        return "the Teacher name get successfully from the database";
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> ListofStudent = new ArrayList<>();

        for (Map.Entry<String, String> entry : Pairdb.entrySet()) {
            if (entry.getValue().equals(teacher)) {
                String studentName = entry.getKey();
                ListofStudent.add(studentName);
            }
        }
        return ListofStudent;
    }

    public List<String> getAllStudents() {
        List<String> listOfStudent = new ArrayList<>();
        for (Map.Entry<String, String> entry : Pairdb.entrySet()) {

            String studentName = entry.getKey();
            listOfStudent.add(studentName);

        }
        return listOfStudent;

    }

    public String deleteTeacherByName(String teacher) {

        teacherdb.remove(teacher);
        for (Map.Entry<String, String> entryset : Pairdb.entrySet()) {
            if (entryset.getValue().equals(teacher)) {
                String studentName = entryset.getKey();
                studentdb.remove(studentName);
                Pairdb.remove(studentName);
            }
        }

        return "remove teacher data everything successfully";
    }

    public String deleteAllTeachers() {
        for (String teacherName : teacherdb.keySet()) {
            teacherdb.remove(teacherName);
            for (Map.Entry<String, String> entryset : Pairdb.entrySet()) {
                if (entryset.getValue().equals(teacherName)) {
                    String studentName = entryset.getKey();
                    studentdb.remove(studentName);
                    Pairdb.remove(studentName);
                }
            }
        }
        return "remove everything in database successfully";
    }
}