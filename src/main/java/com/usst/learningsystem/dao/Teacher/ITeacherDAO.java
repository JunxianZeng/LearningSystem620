package com.usst.learningsystem.dao.Teacher;

import com.usst.learningsystem.entity.Role.Teacher;

import java.util.List;

public interface ITeacherDAO
{
    //添加一个老师
    int addOne(Teacher teacher);
    //删除一个老师
    int deleteOne(String teacherID);
    //根据ID找老师
    Teacher findTeacherByID(String ID);
    //找到所有老师
    List<Teacher> findTeacherList();
}
