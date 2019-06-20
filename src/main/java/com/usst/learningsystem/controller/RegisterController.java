package com.usst.learningsystem.controller;

import com.usst.learningsystem.entity.Resource.Subject;
import com.usst.learningsystem.entity.Role.Student;
import com.usst.learningsystem.entity.Role.Teacher;
import com.usst.learningsystem.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController
{
    @Autowired
    private IService service;

    //学生注册
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentRegister(@RequestParam(value = "学号") String id, @RequestParam(value = "姓名") String name, @RequestParam(value = "密码") String password, @RequestParam(value = "student_grade") String grade, @RequestParam(value = "目标院校", required = false) String targetschool, Model model)
    {
        if(service.findStudentByID(id) == null)
        {
            Student student = new Student(id,name,password,grade,targetschool);
            service.addOneStudent(student);
            return "register/succeed";
        }
        else
        {
            return "register/existed";
        }
    }

    //老师注册
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String teacherRegister(@RequestParam(value = "工号") String id, @RequestParam(value = "姓名") String name, @RequestParam(value = "密码") String password, @RequestParam(value = "电话") String phonenumber, @RequestParam(value = "teacher_subject") String subj, Model model)
    {
        if(service.findTeacherByID(id) == null)
        {
            Teacher teacher = new Teacher(id,name,password,phonenumber,getSubject(subj));
            service.addOneTeacher(teacher);
            return "register/succeed";
        }
        else
        {
            return "register/existed";
        }
    }

    private Subject getSubject(String subject)
    {
        switch (subject)
        {
            case "高等数学":
                return Subject.高等数学;
            case "英语":
                return Subject.英语;
            case "数据结构":
                return Subject.数据结构;
            case "操作系统":
                return Subject.操作系统;
            case "计算机组成":
                return Subject.计算机组成;
            case "计算机网络":
                return Subject.计算机网络;
            default:
                return Subject.政治;
        }
    }
}
