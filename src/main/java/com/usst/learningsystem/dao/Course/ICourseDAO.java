package com.usst.learningsystem.dao.Course;

import com.usst.learningsystem.entity.Resource.Course;
import com.usst.learningsystem.entity.Resource.CourseNotice;
import com.usst.learningsystem.entity.Resource.CourseVideolink;
import com.usst.learningsystem.entity.Resource.Course_Message;

import java.util.List;

public interface ICourseDAO
{
    //添加一门课程
    int addOne(Course course);

    //删除一个课程
    int deleteOne(int courseID);

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

}
