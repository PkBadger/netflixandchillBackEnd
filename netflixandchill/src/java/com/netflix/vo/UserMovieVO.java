package com.netflix.vo;

import java.io.Serializable;

/**
 *
 * @author Dave
 */
public class UserMovieVO implements Serializable
{   
    private String id;
    private String userid;
    private String movieid;


    /**
     * 
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
     *
     * @return
     */
    public String getUserId()
    {
        return userid;
    }
    
    /**
     *
     * @param userid
     */
    public void setUserId(String userid)
    {
        this.userid = userid;
    }  
    
    /**
     *
     * @return
     */
    public String getMovieId() {
        return movieid;
    }
    
    /**
     *
     * @param movieid
     */
    public void setMovieId(String movieid) {
        this.movieid = movieid;
    }
    
    @Override
    public String toString()
    {
        return this.id + " " + this.id;
    }
    
    @Override
    public boolean equals(Object otro)
    {
        if (otro instanceof UserMovieVO)
        {
            return this.id.equals(((UserMovieVO) otro).id);
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