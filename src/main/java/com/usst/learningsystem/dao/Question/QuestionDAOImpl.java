package com.usst.learningsystem.dao.Question;

import com.usst.learningsystem.entity.Resource.Question;
import com.usst.learningsystem.entity.Resource.Question_Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDAOImpl implements IQuestionDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addOne(Question question)
    {
        return jdbcTemplate.update("insert into question(id, publisherID, subject, title, content, answer) values(?, ?, ?, ?, ?, ?)", question.getID(), question.getPublisherID(), question.getSubject(), question.getSubject(), question.getTitle(), question.getContent(), question.getAnswer());
    }

    @Override
    public int deleteOne(int questionID)
    {
        return jdbcTemplate.update("delete from table question where id = ?", questionID);
    }

    @Override
    public Question findQuestionByID(int questionID)
    {
        try
        {
            List<Question> list = jdbcTemplate.query("select * from question where id = ?", new Object[]{questionID}, new BeanPropertyRowMapper(Question.class));
            if (list != null && list.size() > 0)
            {
                Question question = list.get(0);
                return question;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Question> findQuestionList()
    {
        List<Question> empty = new ArrayList<>();
        try
        {
            List<Question> list = jdbcTemplate.query("select * from question", new Object[]{}, new BeanPropertyRowMapper(Question.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }

    @Override
    public int addQuestionMessage(int questionID, String studentID, String content)
    {
        Date time = new Date(new java.util.Date().getTime());
        return jdbcTemplate.update("insert into question_message(id, questionID, studentID, content, time) values(?, ?, ?, ?, ?)", null, questionID, studentID, content, time);
    }

    @Override
    public int deleteQuestionMessage(int ID)
    {
        return jdbcTemplate.update("delete from table question_message where id = ?", ID);
    }

    @Override
    public Question_Message getQuestionMessage(int ID)
    {
        try
        {
            List<Question_Message> list = jdbcTemplate.query("select * from question_message where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Question_Message.class));
            if (list != null && list.size() > 0)
            {
                Question_Message message = list.get(0);
                return message;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Question_Message> getQuestionMessages(int questionID)
    {
        List<Question_Message> empty = new ArrayList<>();
        try
        {
            List<Question_Message> list = jdbcTemplate.query("select * from question_message where questionID = ?", new Object[]{questionID}, new BeanPropertyRowMapper(Question_Message.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
