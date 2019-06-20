package com.usst.learningsystem.entity.Role;

import com.usst.learningsystem.entity.Resource.Subject;

public class Teacher
{
    private String ID;
    private String name;
    private String password;
    private String phonenumber;
    private Subject subject;

    public Teacher(){}

    public Teacher(String ID, String name, String password, String phonenumber, Subject subject)
    {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.subject = subject;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }
}
