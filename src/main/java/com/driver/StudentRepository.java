package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    ArrayList<Student> studentArrayList=new ArrayList<>();
    ArrayList<Teacher> teacherArrayList=new ArrayList<>();

    HashMap<Student,Teacher> mapDB=new HashMap<>();

    public void addToStudArray(Student student){
        studentArrayList.add(student);
    }
    public  void addToTeachArray(Teacher teacher){
        teacherArrayList.add(teacher);
    }
    public void repoPair(String student ,String teacher){
        Student Sobj=getStud(student);
        Teacher Tobj=getTeach(teacher);
        mapDB.put(Sobj,Tobj);
    }
    public Student getRepoStud(String name){
        for(Student obj:mapDB.keySet()){
            if(obj.getName().equals(name)){
                return obj;
            }
        }
        return null;
    }
    public Teacher getRepoTeach(String name){
        for(Teacher obj: mapDB.values()){
            if(name.equals(obj.getName())){
                return obj;
            }
        }
        return null;
    }
    public List<String> getStudListbyTname(String name){
        List<String> ansList=new ArrayList<>();
        for(Student obj: mapDB.keySet()){
            if(mapDB.get(obj).getName().equals(name)){
                ansList.add(obj.getName());
            }
        }
        return ansList;
    }
    public List<String> getrepoAllStud(){
        List<String> ansList=new ArrayList<>();
        for(Student obj:mapDB.keySet()){
            ansList.add(obj.getName());
        }
        return ansList;
    }
    public void deletebytname(String teacher){
        for(Student obj:mapDB.keySet()){
            if(mapDB.get(obj).getName().equals(teacher)){
               mapDB.remove(obj);
            }
        }
    }
    public void repoDeleteAll(){
        for(Student obj:mapDB.keySet()){
            mapDB.remove(obj);
        }
    }
    public Student getStud(String s){
        for(Student obj:studentArrayList){
            if(s.equals(obj.getName())){
                return obj;
            }
        }
        return null;
    }
    public Teacher getTeach(String s){
        for(Teacher obj:teacherArrayList){
            if(s.equals(obj.getName())){
                return obj;
            }
        }
        return null;
    }
}
