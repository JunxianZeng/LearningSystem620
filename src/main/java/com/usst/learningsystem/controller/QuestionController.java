package com.usst.learningsystem.controller;

import com.usst.learningsystem.entity.Resource.*;
import com.usst.learningsystem.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/questions")
public class QuestionController
{
    @Autowired
    private IService service;

    //查看一个题目的详细信息
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String questionDetail(@RequestParam(value = "题目ID") String questionID, Model model)
    {
        int ID = Integer.parseInt(questionID);
        Question question = service.findQuestionByID(ID);
        model.addAttribute("questionInfo", question);
        return "question/questiondetail";
    }

    //添加题目留言
    @RequestMapping(value = "/detail/addmessage", method = RequestMethod.POST)
    public String addQuestionMessage(@RequestParam(value = "题目ID") String questionID, @RequestParam(value = "学生ID") String studentID, @RequestParam(value = "留言内容") String content, Model model)
    {
        int ID = Integer.parseInt(questionID);
        service.addQuestionMessage(ID,studentID,content);
        return "question/addmessage_succeed";
    }

    //删除题目留言
    @RequestMapping(value = "/detail/deletemessage", method = RequestMethod.POST)
    public String deleteQuestionMessage(@RequestParam(value = "id") String id, @RequestParam(value = "学生ID") String studentID, Model model)
    {
        if (id != null && studentID != null)
        {
            int ID = Integer.parseInt(id);
            Course_Message message = service.getCourseMessage(ID);
            //只能删除自己的留言
            if (studentID.equals(message.getStudentID()))
            {
                service.deleteQuestionMessage(ID);
                return "question/deletemessage_succeed";
            }
        }
        return "question/deletemessage_failed";
    }

    //添加一个题目
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addQuestion(@RequestParam(value = "题目ID") String questionID, Model model)
    {
        //暂未实现
        return "question/add_succeed";
    }

    //删除一个题目
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteQuestion(@RequestParam(value = "题目ID") String questionID, Model model)
    {
        int ID = Integer.parseInt(questionID);
        service.deleteOneQuestion(ID);
        return "question/delete_succeed";
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
