package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
@RestController
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/getTeacher")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }
    @PostMapping("/addTeacher")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher add");
    }
    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Teacher teacher){
     teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher updated");
    }
    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted");
    }
}
