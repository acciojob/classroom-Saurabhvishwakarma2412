package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository repoObj;

    public void addStudent(Student student) {
        repoObj.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        repoObj.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        repoObj.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String name){
        return repoObj.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return repoObj.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String name){
        return repoObj.getStudentsByTeacherName(name);
    }
    public  List<String> getAllStudents(){
        return repoObj.getAllStudents();
    }
    public void deleteTeacherByName( String teacher){
        repoObj.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        repoObj.deleteAllTeachers();
    }

}