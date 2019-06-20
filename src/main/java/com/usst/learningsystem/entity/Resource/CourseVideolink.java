package com.usst.learningsystem.entity.Resource;


public class CourseVideolink
{
    private int ID;//视频编号
    private int courseID;//视频所属课程ID
    private String title;//视频标题
    private String link;//视频链接

    public CourseVideolink()
    {
    }

    public CourseVideolink(int ID, int courseID, String title, String link)
    {
        this.ID = ID;
        this.courseID = courseID;
        this.title = title;
        this.link = link;
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

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }
}
