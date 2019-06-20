package com.usst.learningsystem.dao.Manager;

import com.usst.learningsystem.entity.Role.Manager;
import com.usst.learningsystem.entity.Role.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDAOImpl implements IManagerDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Manager findManagerByID(String ID)
    {
        try
        {
            List<Manager> list = jdbcTemplate.query("select * from manager where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Student.class));
            if (list != null && list.size() > 0)
            {
                Manager manager = list.get(0);
                return manager;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }
}
