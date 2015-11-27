package com.netflix.manager;



import com.netflix.dao.UserMovieDAO;
import com.netflix.vo.UserMovieVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dave
 */
public class UserMovieManager
{

    /**
     *
     * @param id
     * @return
     */
    
    public List<UserMovieVO > findByMovie (final String id)
    {
         UserMovieDAO dao = new UserMovieDAO();
        List<UserMovieVO > movie = dao.findbyMovie(id);
                
        return movie;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<UserMovieVO > findByUser (final String id)
    {
        UserMovieDAO dao = new UserMovieDAO();
        List<UserMovieVO > movie = dao.findbyUser(id);
                
        return movie;
    }
    
    /**
     *
     * @param id
     */
    public void eliminar(final String id) {
        UserMovieDAO dao = new UserMovieDAO();
        dao.delete(id);
    }
    
    /**
     *
     * @param UserMovie
     */
    public void create(final UserMovieVO UserMovie) {
        UserMovieDAO dao = new UserMovieDAO();
       dao.create(UserMovie.getId(), UserMovie.getUserId(), UserMovie.getMovieId());
    }
}