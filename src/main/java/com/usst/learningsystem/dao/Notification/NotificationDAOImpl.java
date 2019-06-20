package com.usst.learningsystem.dao.Notification;

import com.usst.learningsystem.entity.Resource.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationDAOImpl implements INotificationDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addOne(Notification notification)
    {
        return jdbcTemplate.update("insert into notification(id, title, content, time) values(?, ?, ?, ?)", null, notification.getTitle(), notification.getContent(), notification.getTime());
    }

    @Override
    public int deleteOne(int ID)
    {
        return jdbcTemplate.update("delete from table notification where id = ?", ID);
    }

    @Override
    public Notification findNotification(int ID)
    {
        try
        {
            List<Notification> list = jdbcTemplate.query("select * from notification where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Notification.class));
            if (list != null && list.size() > 0)
            {
                Notification notification = list.get(0);
                return notification;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Notification> findNotificationList()
    {
        List<Notification> empty = new ArrayList<>();
        try
        {
            List<Notification> list = jdbcTemplate.query("select * from notification", new Object[]{}, new BeanPropertyRowMapper(Notification.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
