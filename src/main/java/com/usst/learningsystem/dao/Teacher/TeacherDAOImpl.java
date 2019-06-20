package com.usst.learningsystem.dao.Teacher;

import com.usst.learningsystem.entity.Role.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherDAOImpl implements ITeacherDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addOne(Teacher teacher)
    {
        return jdbcTemplate.update("insert into teacher(id, name, password, phonenumber, subject) values(?, ?, ?, ?, ?)", teacher.getID(), teacher.getName(), teacher.getPassword(), teacher.getPhonenumber(), teacher.getSubject());
    }

    @Override
    public int deleteOne(String teacherID)
    {
        return jdbcTemplate.update("delete from table teacher where id = ?", teacherID);
    }

    @Override
    public Teacher findTeacherByID(String ID)
    {
        try
        {
            List<Teacher> list = jdbcTemplate.query("select * from teacher where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Teacher.class));
            if (list != null && list.size() > 0)
            {
                Teacher teacher = list.get(0);
                return teacher;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Teacher> findTeacherList()
    {
        List<Teacher> empty = new ArrayList<>();
        try
        {
            List<Teacher> list = jdbcTemplate.query("select * from teacher", new Object[]{}, new BeanPropertyRowMapper(Teacher.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
