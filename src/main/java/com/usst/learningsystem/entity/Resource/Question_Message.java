package com.usst.learningsystem.entity.Resource;

import java.sql.Date;

public class Question_Message
{
    private int ID;//留言编号
    private int questionID;//留言所属题目ID
    private String studentID;//留言人ID
    private Date time;//留言时间
    private String messageContent;//留言内容

    //留言的智能推荐
    private int positiveNumber;//点赞数
    private int negativeNumber;//反对数
    private boolean toped;//是否置顶

    public Question_Message()
    {
    }

    public Question_Message(int ID, int questionID, String studentID, Date time, String messageContent, int positiveNumber, int negativeNumber, boolean toped)
    {
        this.ID = ID;
        this.questionID = questionID;
        this.studentID = studentID;
        this.time = time;
        this.messageContent = messageContent;
        this.positiveNumber = positiveNumber;
        this.negativeNumber = negativeNumber;
        this.toped = toped;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getQuestionID()
    {
        return questionID;
    }

    public void setQuestionID(int questionID)
    {
        this.questionID = questionID;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getMessageContent()
    {
        return messageContent;
    }

    public void setMessageContent(String messageContent)
    {
        this.messageContent = messageContent;
    }

    public int getPositiveNumber()
    {
        return positiveNumber;
    }

    public void setPositiveNumber(int positiveNumber)
    {
        this.positiveNumber = positiveNumber;
    }

    public int getNegativeNumber()
    {
        return negativeNumber;
    }

    public void setNegativeNumber(int negativeNumber)
    {
        this.negativeNumber = negativeNumber;
    }

    public boolean isToped()
    {
        return toped;
    }

    public void setToped(boolean toped)
    {
        this.toped = toped;
    }
}
