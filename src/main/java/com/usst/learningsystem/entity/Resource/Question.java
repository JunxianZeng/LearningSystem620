package com.usst.learningsystem.entity.Resource;

public class Question
{
    private int ID;//题目编号
    private String publisherID;//发布人ID
    private Subject subject;//题目所属分类

    private String title;//题目标题
    private String content;//题目内容
    private String answer;//题目答案

    //题目的智能推荐
    private int positiveNumber;//点赞数
    private int negativeNumber;//反对数
    private int difficultLevel;//难度等级

    public Question()
    {
    }

    public Question(int ID, String publisherID, Subject subject, String title, String content, String answer, int positiveNumber, int negativeNumber, int difficultLevel)
    {
        this.ID = ID;
        this.publisherID = publisherID;
        this.subject = subject;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.positiveNumber = positiveNumber;
        this.negativeNumber = negativeNumber;
        this.difficultLevel = difficultLevel;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getPublisherID()
    {
        return publisherID;
    }

    public void setPublisherID(String publisherID)
    {
        this.publisherID = publisherID;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
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

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
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

    public int getDifficultLevel()
    {
        return difficultLevel;
    }

    public void setDifficultLevel(int difficultLevel)
    {
        this.difficultLevel = difficultLevel;
    }
}
