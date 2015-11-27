package com.netflix.vo;

import java.io.Serializable;

/**
 *
 * @author Dave
 */
public class UserVO implements Serializable
{
    private String id;
    private String username;
    private String phone;
    private String password;
    private String email;

    /**
     * @return the id
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @param correo
     */
    public void setEmail(String correo)
    {
        this.email = correo;
    }
    
    /**
     *
     * @return
     */
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
     * @param username
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
     * @param phone
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     *
     * @return
     */
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