package com.usst.learningsystem.entity.Role;

public class Manager
{
    private String ID;
    private String name;
    private String password;
    private String telephone;

    public Manager()
    {
    }

    public Manager(String ID, String name, String password, String telephone)
    {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
