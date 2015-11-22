package com.netflix.vo;

import java.io.Serializable;

public class ChillVO implements Serializable
{
    private String id;
    private String from;
    private String to;

    /**
     * @return the id
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
    public String getFrom()
    {
        return from;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setFrom(String from)
    {
        this.from = from;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setTo(String to)
    {
        this.to = to;
    }


    @Override
    public String toString()
    {
        return this.id + " " + this.from;
    }
 
   
}