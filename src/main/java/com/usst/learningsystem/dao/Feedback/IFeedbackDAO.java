package com.usst.learningsystem.dao.Feedback;

import com.usst.learningsystem.entity.Resource.Feedback;

import java.util.List;

public interface IFeedbackDAO
{
    //添加一个反馈
    int addOne(Feedback feedback);
    //删除一个反馈
    int deleteOne(int feedbackID);
    //找到一条反馈意见
    Feedback findFeedback(int feedbackID);
    //找到所有反馈意见
    List<Feedback> findFeedbackList();

}
