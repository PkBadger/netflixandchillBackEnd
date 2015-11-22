package com.netflix.manager;



import com.netflix.dao.UserMovieDAO;
import com.netflix.vo.UserMovieVO;
import java.sql.SQLException;
import java.util.List;



public class UserMovieManager
{
    /*  
    public UserMovieVO consultar (final String id)
    {
        UserMovieDAO dao = new UserMovieDAO();
        UserMovieVO  movie = dao.findById("" + id);
        
        return movie;
    }*/
    
    
    
    public List<UserMovieVO > findByMovie (final String id)
    {
         UserMovieDAO dao = new UserMovieDAO();
        List<UserMovieVO > movie = dao.findbyMovie(id);
                
        return movie;
    }
     public List<UserMovieVO > findByUser (final String id)
    {
        UserMovieDAO dao = new UserMovieDAO();
        List<UserMovieVO > movie = dao.findbyUser(id);
                
        return movie;
    }
    
    public void eliminar(final String id) {
        UserMovieDAO dao = new UserMovieDAO();
        dao.delete(id);
    }
    
    public void create(final UserMovieVO UserMovie) {
        UserMovieDAO dao = new UserMovieDAO();
       dao.create(UserMovie.getId(), UserMovie.getUserId(), UserMovie.getMovieId());
    }
}