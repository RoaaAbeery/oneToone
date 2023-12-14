package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.APiException;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.findAll();
    }
     public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new APiException("Teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getAge());
        teacherRepository.save(oldTeacher);
     }
     public void deleteTeacher(Integer id){
         Teacher teacher=teacherRepository.findTeacherById(id);
         if(teacher==null){
             throw new APiException("Teacher not found");
         }
         teacherRepository.delete(teacher);
     }
}
