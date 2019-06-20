package com.usst.learningsystem.dao.Feedback;

import com.usst.learningsystem.entity.Resource.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedbackDAOImpl implements IFeedbackDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addOne(Feedback feedback)
    {
        if (feedback.getName() != null)
            return jdbcTemplate.update("insert into feedback(id, title, suggestion, time, name) values(?, ?, ?, ?, ?)", null, feedback.getTitle(), feedback.getSuggestion(), feedback.getTime(), feedback.getName());
        return jdbcTemplate.update("insert into feedback(id, title, suggestion, time) values(?, ?, ?, ?)", null, feedback.getTitle(), feedback.getSuggestion(), feedback.getTime());
    }

    @Override
    public int deleteOne(int feedbackID)
    {
        return jdbcTemplate.update("delete from table feedback where id = ?", feedbackID);
    }

    @Override
    public Feedback findFeedback(int feedbackID)
    {
        try
        {
            List<Feedback> list = jdbcTemplate.query("select * from feedback where id = ?", new Object[]{feedbackID}, new BeanPropertyRowMapper(Feedback.class));
            if (list != null && list.size() > 0)
            {
                Feedback feedback = list.get(0);
                return feedback;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Feedback> findFeedbackList()
    {
        List<Feedback> empty = new ArrayList<>();
        try
        {
            List<Feedback> list = jdbcTemplate.query("select * from feedback", new Object[]{}, new BeanPropertyRowMapper(Feedback.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
