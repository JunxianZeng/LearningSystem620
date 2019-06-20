package com.usst.learningsystem.dao.Manager;

import com.usst.learningsystem.entity.Role.Manager;

public interface IManagerDAO
{
    //根据ID找管理员
    Manager findManagerByID(String ID);
}
