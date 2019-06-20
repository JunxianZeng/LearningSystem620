package com.usst.learningsystem.controller;

import com.usst.learningsystem.entity.Role.Manager;
import com.usst.learningsystem.entity.Role.Student;
import com.usst.learningsystem.entity.Role.Teacher;
import com.usst.learningsystem.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{
    @Autowired
    private IService service;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, @RequestParam(value = "id") String id, @RequestParam(value = "password") String password, @RequestParam(value = "loginRole") String loginRole, Model model)
    {
        switch (loginRole)
        {
            case "学生":
                Student student = service.findStudentByID(id);
                if(student != null)
                {
                    if (password.equals(student.getPassword()))
                    {
                        session.setAttribute("loginRole","Student");
                        session.setAttribute("student",student);
                        model.addAttribute("studentInfo", student);
                        return "login/succeed";
                    }
                }
                return "login/notExist";
            case "老师":
                Teacher teacher = service.findTeacherByID(id);
                if(teacher != null)
                {
                    if (password.equals(teacher.getPassword()))
                    {
                        session.setAttribute("loginRole","Teacher");
                        session.setAttribute("teacher",teacher);
                        model.addAttribute("teacherInfo", teacher);
                        return "login/succeed";
                    }
                }
                return "login/notExist";
            case "管理员":
                Manager manager = service.findManagerByID(id);
                if(manager != null)
                {
                    if (password.equals(manager.getPassword()))
                    {
                        session.setAttribute("loginRole","Manager");
                        session.setAttribute("manager",manager);
                        model.addAttribute("managerInfo", manager);
                        return "login/succeed";
                    }
                }
                return "login/notExist";
        }
        return "login/notExist";
    }
}
