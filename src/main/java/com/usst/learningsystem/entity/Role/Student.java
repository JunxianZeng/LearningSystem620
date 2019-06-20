package com.usst.learningsystem.entity.Role;

public class Student
{
    private String ID;//学号，即登录账号
    private String name;//学生姓名
    private String password;//密码
    private String grade;//年级，如：2016级
    private String targetSchool;//目标院校

    public Student(){}

    public Student(String ID, String name, String password, String grade, String targetSchool)
    {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.targetSchool = targetSchool;
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

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getTargetSchool()
    {
        return targetSchool;
    }

    public void setTargetSchool(String targetSchool)
    {
        this.targetSchool = targetSchool;
    }
}
