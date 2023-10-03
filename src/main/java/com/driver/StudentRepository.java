package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {


    HashMap<String,Student> studentHashMap=new HashMap<>();
    HashMap<String,Teacher> teacherHashMap=new HashMap<>();
    HashMap<Student,Teacher> mapDB=new HashMap<>();

    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
    }
    public  void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student ,String teacher){
        mapDB.put(studentHashMap.get(student),teacherHashMap.get(teacher));
    }
    public Student getStudentByName(String name){
        return studentHashMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherHashMap.get(name);
    }
    public List<String> getStudentsByTeacherName(String name){
        List<String> ansList=new ArrayList<>();
        Teacher teacher=teacherHashMap.get(name);
        for(Student obj: mapDB.keySet()){
            if(mapDB.get(obj)==teacher){
                ansList.add(obj.getName());
            }
        }
        return ansList;
    }
    public List<String> getAllStudents(){
        List<String> ansList=new ArrayList<>();
        for(String student:studentHashMap.keySet()){
            ansList.add(student);
        }
        return ansList;
    }
    public void deleteTeacherByName(String teacher){
        Teacher teacherobj=teacherHashMap.get(teacher);
        teacherHashMap.remove(teacher);
        for(Student student:mapDB.keySet()){
            if(mapDB.get(student)==teacherobj){
                mapDB.remove(student);
                studentHashMap.remove(student);
            }
        }
    }
    public void deleteAllTeachers() {
       for(String teacher :teacherHashMap.keySet()){
           Teacher teacherobj=teacherHashMap.get(teacher);
           for(Student student: mapDB.keySet()){
               if(mapDB.get(student)==teacherobj){
                   mapDB.remove(student);
                   studentHashMap.remove(student.getName());
               }
           }
           teacherHashMap.remove(teacher);
       }
    }

}
