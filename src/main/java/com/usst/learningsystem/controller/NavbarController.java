package com.usst.learningsystem.controller;

import com.usst.learningsystem.entity.Resource.Course;
import com.usst.learningsystem.entity.Resource.Feedback;
import com.usst.learningsystem.entity.Resource.Notification;
import com.usst.learningsystem.entity.Resource.Question;
import com.usst.learningsystem.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class NavbarController
{
    @Autowired
    private IService service;

    //主页
    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String mainpage(Model model)
    {
        //计算倒计时
        String targetTime = "2019-12-21";//考研时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
            date = format.parse(targetTime);
        } catch (ParseException e)
        {
            System.out.println("时间转换错误!");
            //e.printStackTrace();
        }
        int days = (int) ((date.getTime() - new Date().getTime()) / (1000 * 3600 * 24));

        //获取所有公告
        List<Notification> notifications = service.findNotificationList();
        model.addAttribute("days", days);
        model.addAttribute("notifications", notifications);
        return "mainpage";
    }

    //主页公告
    @RequestMapping(value = "/mainpage/notification", method = RequestMethod.GET)
    public String notification(@RequestParam(value = "id") String id, Model model)
    {
        //根据公告id获取公告内容
        int ID = Integer.parseInt(id);
        Notification notification = service.findNotification(ID);
        model.addAttribute("notification", notification);
        return "notification/"+id;
    }

    //题库
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questionBank(Model model)
    {
        //获取所有题库
        List<Question> questions = service.findQuestionList();
        model.addAttribute("questions", questions);
        return "questions";
    }

    //课程
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String course(Model model)
    {
        //获取所有课程
        List<Course> courses = service.findCourseList();
        model.addAttribute("courses", courses);
        return "courses";
    }

    //反馈
    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public String feedback(Model model)
    {
        //获取所有反馈
        List<Feedback> feedbacks = service.findFeedbackList();
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks";
    }

    //关于我们
    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutus(Model model)
    {
        return "aboutus";
    }

    //错误界面
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model)
    {
        return "error";
    }
}
