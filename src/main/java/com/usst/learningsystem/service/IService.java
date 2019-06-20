package com.usst.learningsystem.service;

import com.usst.learningsystem.entity.Resource.*;
import com.usst.learningsystem.entity.Role.Manager;
import com.usst.learningsystem.entity.Role.Student;
import com.usst.learningsystem.entity.Role.Teacher;

import java.util.List;

public interface IService
{
    //添加一个学生(学生注册)
    int addOneStudent(Student student);

    //删除一个学生
    int deleteOneStudent(String studentID);

    //根据ID找学生
    Student findStudentByID(String ID);

    //找到所有学生
    List<Student> findStudentList();

    //添加一个老师(老师注册)
    int addOneTeacher(Teacher teacher);

    //删除一个老师
    int deleteOneTeacher(String teacherID);

    //根据ID找老师
    Teacher findTeacherByID(String ID);

    //找到所有老师
    List<Teacher> findTeacherList();

    //根据ID找管理员
    Manager findManagerByID(String ID);

    //添加一门课程
    int addOneCourse(Course course);

    //删除一个课程
    int deleteOneCourse(int courseID);

    //根据ID找到一门课程
    Course findCourseByID(int courseID);

    //找到所有课程
    List<Course> findCourseList();

    //添加一条课程留言
    int addCourseMessage(int courseID, String studentID, String content);

    //删除一条课程留言
    int deleteCourseMessage(int ID);

    //根据id获得一条课程留言
    Course_Message getCourseMessage(int ID);

    //获取某一课程所有留言
    List<Course_Message> getCourseMessages(int courseID);

    //添加一条课程公告
    int addCourseNotice(int courseID, String title, String content);

    //删除一条课程公告
    int deleteCourseNotice(int ID);

    //获取某一课程所有公告
    List<CourseNotice> getCourseNotices(int courseID);

    //添加一个视频链接
    int addVideoLink(int courseID, String videoTitle, String videoLink);

    //删除一个视频链接
    int deleteVideoLink(int ID);

    //获取某一课程的所有视频链接
    List<CourseVideolink> getCourseLinks(int courseID);

    //添加一个题目
    int addOneQuestion(Question question);

    //删除一个题目
    int deleteOneQuestion(int questionID);

    //根据ID找到一个题目
    Question findQuestionByID(int questionID);

    //找到所有题目
    List<Question> findQuestionList();

    //添加一条问题留言
    int addQuestionMessage(int questionID, String studentID, String content);

    //删除一条问题留言
    int deleteQuestionMessage(int ID);

    //根据id获得一条问题留言
    Question_Message getQuestionMessage(int ID);

    //获取某一题目所有留言
    List<Question_Message> getQuestionMessages(int questionID);

    //发布一个公告
    int addOneNotification(Notification notification);

    //删除一个公告
    int deleteOneNotification(int ID);

    //找到一个公告
    Notification findNotification(int ID);

    //找到所有公告
    List<Notification> findNotificationList();

    //添加一个反馈
    int addOneFeedback(Feedback feedback);

    //删除一个反馈
    int deleteOneFeedback(int feedbackID);

    //找到一条反馈意见
    Feedback findFeedback(int feedbackID);

    //找到所有反馈意见
    List<Feedback> findFeedbackList();
}
