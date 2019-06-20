package com.usst.learningsystem.controller;

import com.usst.learningsystem.entity.Resource.*;
import com.usst.learningsystem.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController
{
    @Autowired
    private IService service;

    //查看一门课程的详细信息
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String courseDetail(@RequestParam(value = "id") String courseID, Model model)
    {
        int ID = Integer.parseInt(courseID);
        Course course = service.findCourseByID(ID);
        List<CourseNotice> courseNotices = service.getCourseNotices(ID);
        List<CourseVideolink> videoLinks = service.getCourseLinks(ID);
        List<Course_Message> courseMessages = service.getCourseMessages(ID);
        model.addAttribute("courseInfo", course);
        model.addAttribute("courseNotices", courseNotices);
        model.addAttribute("videoLinks", videoLinks);
        model.addAttribute("courseMessages", courseMessages);
        System.out.println(courseMessages.get(0).getStudentID());
        return "course/coursedetail";
    }

    //添加课程公告
    @RequestMapping(value = "/detail/addnotice", method = RequestMethod.POST)
    public String addCourseNotice(@RequestParam(value = "课程ID") String courseID, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content, Model model)
    {
        int ID = Integer.parseInt(courseID);
        service.addCourseNotice(ID, title, content);
        return "course/add_succeed";
    }

    //删除课程公告
    @RequestMapping(value = "/detail/deletenotice", method = RequestMethod.POST)
    public String deleteCourseNotice(@RequestParam(value = "id") String id, Model model)
    {
        int ID = Integer.parseInt(id);
        service.deleteCourseNotice(ID);
        return "course/delete_succeed";
    }

    //添加课程视频链接
    @RequestMapping(value = "/detail/addlink", method = RequestMethod.POST)
    public String addCourseLink(@RequestParam(value = "课程ID") String courseID, @RequestParam(value = "title") String title, @RequestParam(value = "link") String link, Model model)
    {
        int ID = Integer.parseInt(courseID);
        service.addVideoLink(ID, title, link);
        return "course/add_succeed";
    }

    //删除课程视频链接
    @RequestMapping(value = "/detail/deletelink", method = RequestMethod.POST)
    public String deleteCourseLink(@RequestParam(value = "id") String id, Model model)
    {
        int ID = Integer.parseInt(id);
        service.deleteVideoLink(ID);
        return "course/delete_succeed";
    }

    //添加课程留言
    @RequestMapping(value = "/detail/addmessage", method = RequestMethod.POST)
    public String addCourseMessage(@RequestParam(value = "课程ID") String courseID, @RequestParam(value = "学生ID") String studentID, @RequestParam(value = "留言内容") String content, Model model)
    {
        int ID = Integer.parseInt(courseID);
        service.addCourseMessage(ID, studentID, content);
        return "course/addmessage_succeed";
    }

    //删除课程留言
    @RequestMapping(value = "/detail/deletemessage", method = RequestMethod.POST)
    public String deleteCourseMessage(@RequestParam(value = "id") String id, @RequestParam(value = "学生ID") String studentID, Model model)
    {
        if (id != null && studentID != null)
        {
            int ID = Integer.parseInt(id);
            Course_Message message = service.getCourseMessage(ID);
            //只能删除自己的留言
            if (studentID.equals(message.getStudentID()))
            {
                service.deleteCourseMessage(ID);
                return "course/deletemessage_succeed";
            }
        }
        return "course/deletemessage_failed";
    }

    //添加一门课程
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCourse(@RequestParam(value = "课程ID") String courseID, @RequestParam(value = "课程名称") String name, @RequestParam(value = "科目") String subject, @RequestParam(value = "课程描述") String description, Model model)
    {
        int ID = Integer.parseInt(courseID);
        Course course = new Course(ID, name, getSubject(subject), description);
        service.addOneCourse(course);
        return "course/add_succeed";
    }

    //删除一门课程
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCourse(@RequestParam(value = "id") String courseID, Model model)
    {
        int ID = Integer.parseInt(courseID);
        service.deleteOneCourse(ID);
        return "course/delete_succeed";
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
