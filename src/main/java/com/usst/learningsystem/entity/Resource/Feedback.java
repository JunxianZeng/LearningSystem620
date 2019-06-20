package com.usst.learningsystem.entity.Resource;

import java.sql.Date;

public class Feedback
{
    private int ID;//反馈的ID
    private String title;//反馈标题
    private String suggestion;//反馈建议
    private Date time;//反馈建议的时间
    private String name;//反馈人的姓名,可能为null

    public Feedback()
    {
    }

    public Feedback(int ID, String title, String suggestion, Date time, String name)
    {
        this.ID = ID;
        this.title = title;
        this.suggestion = suggestion;
        this.time = time;
        this.name = name;
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

    public String getSuggestion()
    {
        return suggestion;
    }

    public void setSuggestion(String suggestion)
    {
        this.suggestion = suggestion;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
