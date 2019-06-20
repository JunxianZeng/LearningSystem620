package com.usst.learningsystem.entity.Resource;

import java.sql.Date;

public class Notification
{
    private int ID;//公告ID
    private String title;//公告标题
    private String content;//公告内容
    private Date time;//发布公告的时间

    public Notification()
    {
    }

    public Notification(int ID, String title, String content, Date time)
    {
        this.ID = ID;
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
