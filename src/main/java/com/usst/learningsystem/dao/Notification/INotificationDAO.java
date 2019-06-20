package com.usst.learningsystem.dao.Notification;

import com.usst.learningsystem.entity.Resource.Notification;

import java.util.List;

public interface INotificationDAO
{
    //发布一个公告
    int addOne(Notification notification);
    //删除一个公告
    int deleteOne(int ID);
    //找到一个公告
    Notification findNotification(int ID);
    //找到所有公告
    List<Notification> findNotificationList();

}
