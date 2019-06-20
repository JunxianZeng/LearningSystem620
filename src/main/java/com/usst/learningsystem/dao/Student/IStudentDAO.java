package com.usst.learningsystem.dao.Student;

import com.usst.learningsystem.entity.Role.Student;

import java.util.List;

public interface IStudentDAO
{
    //添加一个学生
    int addOne(Student student);
    //删除一个学生
    int deleteOne(String studentID);
    //根据ID找学生
    Student findStudentByID(String ID);
    //找到所有学生
    List<Student> findStudentList();
}
