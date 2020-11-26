package com.xwzjqyhr.mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwzjqyhr.mongodb.pojo.Student;
import com.xwzjqyhr.mongodb.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student) {
        studentService.insertStudent(student);

    }
    @RequestMapping(value = "/{_id}",method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String _id) {

        studentService.deleteStudent(_id);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findStudentByContidion(@RequestParam(required = false) Integer maxAge,@RequestParam(required = false) String dName) {
        System.out.println(JSONObject.toJSONString(studentService.findStudentByContidion(maxAge,dName).get(0)));
        return studentService.findStudentByContidion(maxAge,dName);
    }
    @RequestMapping(value = "/nameAgeColume",method = RequestMethod.GET)
    public List<Student> findStudentByContidion(@RequestParam Integer maxAge) {
        return studentService.findNameAgeColumeByContidion(maxAge);
    }


}











