package com.netflix.vo;

import java.io.Serializable;

public class MovieVO implements Serializable
{
    private String id;
    private String title;
    private String genre;

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
    public String getTitle()
    {
        return title;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }


    @Override
    public String toString()
    {
        return this.id + " " + this.title;
    }
    
    @Override
    public boolean equals(Object otro)
    {
        if (otro instanceof MovieVO)
        {
            return this.id.equals(((MovieVO) otro).id);
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