package com.usst.learningsystem.entity.Resource;

public class Course
{
    private int ID;//课程ID
    private String name;//课程名称
    private Subject subject;//课程类型
    private String description;//课程描述

    public Course()
    {
    }

    public Course(int ID, String name, Subject subject, String description)
    {
        this.ID = ID;
        this.name = name;
        this.subject = subject;
        this.description = description;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject type)
    {
        this.subject = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
