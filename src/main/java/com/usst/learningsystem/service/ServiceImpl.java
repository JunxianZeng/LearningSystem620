package com.usst.learningsystem.service;

import com.usst.learningsystem.dao.Course.ICourseDAO;
import com.usst.learningsystem.dao.Feedback.IFeedbackDAO;
import com.usst.learningsystem.dao.Manager.IManagerDAO;
import com.usst.learningsystem.dao.Notification.INotificationDAO;
import com.usst.learningsystem.dao.Question.IQuestionDAO;
import com.usst.learningsystem.dao.Student.IStudentDAO;
import com.usst.learningsystem.dao.Teacher.ITeacherDAO;
import com.usst.learningsystem.entity.Resource.*;
import com.usst.learningsystem.entity.Role.Manager;
import com.usst.learningsystem.entity.Role.Student;
import com.usst.learningsystem.entity.Role.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService
{
    @Autowired
    private IStudentDAO studentDAO;
    @Autowired
    private ITeacherDAO teacherDAO;
    @Autowired
    private IManagerDAO managerDAO;
    @Autowired
    private ICourseDAO courseDAO;
    @Autowired
    private IQuestionDAO questionDAO;
    @Autowired
    private INotificationDAO notificationDAO;
    @Autowired
    private IFeedbackDAO feedbackDAO;

    @Override
    public int addOneStudent(Student student)
    {
        return studentDAO.addOne(student);
    }

    @Override
    public int deleteOneStudent(String studentID)
    {
        return studentDAO.deleteOne(studentID);
    }

    @Override
    public Student findStudentByID(String ID)
    {
        return studentDAO.findStudentByID(ID);
    }

    @Override
    public List<Student> findStudentList()
    {
        return studentDAO.findStudentList();
    }

    @Override
    public int addOneTeacher(Teacher teacher)
    {
        return teacherDAO.addOne(teacher);
    }

    @Override
    public int deleteOneTeacher(String teacherID)
    {
        return teacherDAO.deleteOne(teacherID);
    }

    @Override
    public Teacher findTeacherByID(String ID)
    {
        return teacherDAO.findTeacherByID(ID);
    }

    @Override
    public List<Teacher> findTeacherList()
    {
        return teacherDAO.findTeacherList();
    }

    @Override
    public Manager findManagerByID(String ID)
    {
        return managerDAO.findManagerByID(ID);
    }

    @Override
    public int addOneCourse(Course course)
    {
        return courseDAO.addOne(course);
    }

    @Override
    public int deleteOneCourse(int courseID)
    {
        return courseDAO.deleteOne(courseID);
    }

    @Override
    public Course findCourseByID(int courseID)
    {
        return courseDAO.findCourseByID(courseID);
    }

    @Override
    public List<Course> findCourseList()
    {
        return courseDAO.findCourseList();
    }

    @Override
    public int addCourseMessage(int courseID, String studentID, String content)
    {
        return courseDAO.addCourseMessage(courseID, studentID, content);
    }

    @Override
    public int deleteCourseMessage(int ID)
    {
        return courseDAO.deleteCourseMessage(ID);
    }

    @Override
    public Course_Message getCourseMessage(int ID)
    {
        return courseDAO.getCourseMessage(ID);
    }

    @Override
    public List<Course_Message> getCourseMessages(int courseID)
    {
        return courseDAO.getCourseMessages(courseID);
    }

    @Override
    public int addCourseNotice(int courseID, String title, String content)
    {
        return courseDAO.addCourseNotice(courseID, title, content);
    }

    @Override
    public int deleteCourseNotice(int ID)
    {
        return courseDAO.deleteCourseNotice(ID);
    }

    @Override
    public List<CourseNotice> getCourseNotices(int courseID)
    {
        return courseDAO.getCourseNotices(courseID);
    }

    @Override
    public int addVideoLink(int courseID, String videoTitle, String videoLink)
    {
        return courseDAO.addVideoLink(courseID, videoTitle, videoLink);
    }

    @Override
    public int deleteVideoLink(int ID)
    {
        return courseDAO.deleteVideoLink(ID);
    }

    @Override
    public List<CourseVideolink> getCourseLinks(int courseID)
    {
        return courseDAO.getCourseLinks(courseID);
    }

    @Override
    public int addOneQuestion(Question question)
    {
        return questionDAO.addOne(question);
    }

    @Override
    public int deleteOneQuestion(int questionID)
    {
        return questionDAO.deleteOne(questionID);
    }

    @Override
    public Question findQuestionByID(int questionID)
    {
        return questionDAO.findQuestionByID(questionID);
    }

    @Override
    public List<Question> findQuestionList()
    {
        return questionDAO.findQuestionList();
    }

    @Override
    public int addQuestionMessage(int questionID, String studentID, String content)
    {
        return questionDAO.addQuestionMessage(questionID, studentID, content);
    }

    @Override
    public int deleteQuestionMessage(int ID)
    {
        return questionDAO.deleteQuestionMessage(ID);
    }

    @Override
    public Question_Message getQuestionMessage(int ID)
    {
        return questionDAO.getQuestionMessage(ID);
    }

    @Override
    public List<Question_Message> getQuestionMessages(int questionID)
    {
        return questionDAO.getQuestionMessages(questionID);
    }

    @Override
    public int addOneNotification(Notification notification)
    {
        return notificationDAO.addOne(notification);
    }

    @Override
    public int deleteOneNotification(int ID)
    {
        return notificationDAO.deleteOne(ID);
    }

    @Override
    public Notification findNotification(int ID)
    {
        return notificationDAO.findNotification(ID);
    }

    @Override
    public List<Notification> findNotificationList()
    {
        return notificationDAO.findNotificationList();
    }

    @Override
    public int addOneFeedback(Feedback feedback)
    {
        return feedbackDAO.addOne(feedback);
    }

    @Override
    public int deleteOneFeedback(int feedbackID)
    {
        return feedbackDAO.deleteOne(feedbackID);
    }

    @Override
    public Feedback findFeedback(int feedbackID)
    {
        return feedbackDAO.findFeedback(feedbackID);
    }

    @Override
    public List<Feedback> findFeedbackList()
    {
        return feedbackDAO.findFeedbackList();
    }
}
