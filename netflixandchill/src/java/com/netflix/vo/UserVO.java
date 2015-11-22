package com.netflix.vo;

import java.io.Serializable;

public class UserVO implements Serializable
{
    private String id;
    private String username;
    private String phone;
    private String password;
    private String ImageL;

    /**
     * @return the id
     */
    public String getImage()
    {
        return ImageL;
    }
    public void setImage(String img)
    {
        this.ImageL = img;
    }
    
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getUser()
    {
        return username;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String toString()
    {
        return this.id + " " + this.username;
    }
    
    @Override
    public boolean equals(Object otro)
    {
        if (otro instanceof UserVO)
        {
            return this.id.equals(((UserVO) otro).id);
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public int hashCode()
    {
        return this.id.hashCode();
    }
}