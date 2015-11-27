package com.netflix.vo;

import java.io.Serializable;

/**
 *
 * @author Dave
 */
public class ChillVO implements Serializable
{
    private String id;
    private String from_id;
    private String to_id;

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
        return from_id;
    }

    /**
     * @param from
     * @param nombre the nombre to set
     */
    public void setFrom(String from)
    {
        this.from_id = from;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getTo()
    {
        return to_id;
    }

    /**
     * @param to
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setTo(String to)
    {
        this.to_id = to;
    }


    @Override
    public String toString()
    {
        return this.id + " " + this.from_id;
    }
 
   
}