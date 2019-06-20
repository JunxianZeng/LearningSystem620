package com.usst.learningsystem.dao.Student;

import com.usst.learningsystem.entity.Role.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addOne(Student student)
    {
        return jdbcTemplate.update("insert into student(id, name, password, grade, targetschool) values(?, ?, ?, ?, ?)", student.getID(), student.getName(), student.getPassword(), student.getGrade(), student.getTargetSchool());
    }

    @Override
    public int deleteOne(String studentID)
    {
        return jdbcTemplate.update("delete from table student where id = ?", studentID);
    }

    @Override
    public Student findStudentByID(String ID)
    {
        try
        {
            List<Student> list = jdbcTemplate.query("select * from student where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Student.class));
            if (list != null && list.size() > 0)
            {
                Student student = list.get(0);
                return student;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Student> findStudentList()
    {
        List<Student> empty = new ArrayList<>();
        try
        {
            List<Student> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
