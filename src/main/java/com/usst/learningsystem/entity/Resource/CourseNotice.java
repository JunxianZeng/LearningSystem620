package com.usst.learningsystem.entity.Resource;

import java.sql.Date;

public class CourseNotice
{
    private int ID;//公告编号
    private int courseID;//公告所属课程ID
    private String title;//公告标题
    private String content;//公告内容
    private Date time;//公告发布时间

    public CourseNotice()
    {
    }

    public CourseNotice(int ID, int courseID, String title, String content, Date time)
    {
        this.ID = ID;
        this.courseID = courseID;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getCourseID()
    {
        return courseID;
    }

    public void setCourseID(int courseID)
    {
        this.courseID = courseID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }
}
