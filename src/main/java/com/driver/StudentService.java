package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository repoObj;

    public void addStud(Student student) {
        repoObj.addToStudArray(student);
    }

    public void addTeach(Teacher teacher) {
        repoObj.addToTeachArray(teacher);
    }
    public void servicePair(String student,String teacher){
        repoObj.repoPair(student,teacher);
    }
    public Student servicegetStudent(String name){
        return repoObj.getRepoStud(name);
    }
    public Teacher servicegetTecaher(String name){
        return repoObj.getRepoTeach(name);
    }
    public List<String> getStudentbytname(String name){
        return repoObj.getStudListbyTname(name);
    }
    public  List<String> servicegetAllStud(){
        return repoObj.getrepoAllStud();
    }
    public void servicedeltebyTeacher( String teacher){
        repoObj.deletebytname(teacher);
    }
    public void servicedeleteAll(){
        repoObj.repoDeleteAll();
    }

}