package com.usst.learningsystem.dao.Course;

import com.usst.learningsystem.entity.Resource.Course;
import com.usst.learningsystem.entity.Resource.CourseNotice;
import com.usst.learningsystem.entity.Resource.CourseVideolink;
import com.usst.learningsystem.entity.Resource.Course_Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDAOImpl implements ICourseDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addOne(Course course)
    {
        //此处可能插入报错，course.getSubject()是枚举类型，未转换为String
        return jdbcTemplate.update("insert into course(id, name, subject, description) values(?, ?, ?, ?)", course.getID(), course.getName(), course.getSubject(), course.getDescription());
    }

    @Override
    public int deleteOne(int courseID)
    {
        return jdbcTemplate.update("delete from table course where id = ?", courseID);
    }

    @Override
    public Course findCourseByID(int courseID)
    {
        try
        {
            List<Course> list = jdbcTemplate.query("select * from course where id = ?", new Object[]{courseID}, new BeanPropertyRowMapper(Course.class));
            if (list != null && list.size() > 0)
            {
                Course course = list.get(0);
                return course;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Course> findCourseList()
    {
        List<Course> empty = new ArrayList<>();
        try
        {
            List<Course> list = jdbcTemplate.query("select * from course", new Object[]{}, new BeanPropertyRowMapper(Course.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }

    @Override
    public int addCourseMessage(int courseID, String studentID, String content)
    {
        Date time = new Date(new java.util.Date().getTime());
        return jdbcTemplate.update("insert into course_message(id, courseID, studentID, messagecontent, time, positivenumber, negativenumber, toped) values(?, ?, ?, ?, ?,0,0,0)", null, courseID, studentID, content, time);
    }

    @Override
    public int deleteCourseMessage(int ID)
    {
        return jdbcTemplate.update("delete from table course_message where id = ?", ID);
    }

    @Override
    public Course_Message getCourseMessage(int ID)
    {
        try
        {
            List<Course_Message> list = jdbcTemplate.query("select * from course_message where id = ?", new Object[]{ID}, new BeanPropertyRowMapper(Course_Message.class));
            if (list != null && list.size() > 0)
            {
                Course_Message message = list.get(0);
                return message;
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Course_Message> getCourseMessages(int courseID)
    {
        List<Course_Message> empty = new ArrayList<>();
        try
        {
            List<Course_Message> list = jdbcTemplate.query("select * from course_message where courseID = ?", new Object[]{courseID}, new BeanPropertyRowMapper(Course_Message.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("出异常了");
            return empty;
        }
    }

    @Override
    public int addCourseNotice(int courseID, String title, String content)
    {
        Date time = new Date(new java.util.Date().getTime());
        return jdbcTemplate.update("insert into course_notice(id, courseID, title, content, time) values(?, ?, ?, ?,?)", null, courseID, title, content, time);
    }

    @Override
    public int deleteCourseNotice(int ID)
    {
        return jdbcTemplate.update("delete from table course_notice where id = ?", ID);
    }

    @Override
    public List<CourseNotice> getCourseNotices(int courseID)
    {
        List<CourseNotice> empty = new ArrayList<>();
        try
        {
            List<CourseNotice> list = jdbcTemplate.query("select * from course_notice where courseID = ?", new Object[]{courseID}, new BeanPropertyRowMapper(CourseNotice.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }

    @Override
    public int addVideoLink(int courseID, String videoTitle, String videoLink)
    {
        return jdbcTemplate.update("insert into course_videolink(id, courseID, title, link) values(?, ?, ?, ?)", null, courseID, videoTitle, videoLink);
    }

    @Override
    public int deleteVideoLink(int ID)
    {
        return jdbcTemplate.update("delete from table course_videolink where id = ?", ID);
    }

    @Override
    public List<CourseVideolink> getCourseLinks(int courseID)
    {
        List<CourseVideolink> empty = new ArrayList<>();
        try
        {
            List<CourseVideolink> list = jdbcTemplate.query("select * from course_videolink where courseID = ?", new Object[]{courseID}, new BeanPropertyRowMapper(CourseVideolink.class));
            if (list != null && list.size() > 0) return list;
            return empty;
        } catch (Exception e)
        {
            return empty;
        }
    }
}
