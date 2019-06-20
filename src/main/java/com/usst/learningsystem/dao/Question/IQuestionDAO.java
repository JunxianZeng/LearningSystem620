package com.usst.learningsystem.dao.Question;

import com.usst.learningsystem.entity.Resource.Question;
import com.usst.learningsystem.entity.Resource.Question_Message;

import java.util.List;

public interface IQuestionDAO
{
    //添加一个题目
    int addOne(Question question);

    //删除一个题目
    int deleteOne(int questionID);

    //根据ID找到一个题目
    Question findQuestionByID(int questionID);

    //找到所有题目
    List<Question> findQuestionList();

    //添加一条问题留言
    int addQuestionMessage(int questionID, String studentID, String content);

    //删除一条问题留言
    int deleteQuestionMessage(int ID);

    //根据id获得一条课程留言
    Question_Message getQuestionMessage(int ID);

    //获取某一题目所有留言
    List<Question_Message> getQuestionMessages(int questionID);

}
