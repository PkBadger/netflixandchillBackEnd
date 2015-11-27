package com.netflix.manager;



import com.netflix.dao.MovieDao;
import com.netflix.vo.MovieVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dave
 */
public class MovieManager
{
       
    /**
     *
     * @param id
     * @return
     */
    public MovieVO consultar (final String id)
    {
        MovieDao dao = new MovieDao();
        MovieVO movie = dao.findById("" + id);
        
        return movie;
    }
    
    /**
     *
     * @return
     */
    public List<MovieVO> listar ()
    {
        MovieDao dao = new MovieDao();
        List<MovieVO> movie = dao.findAll();
                
        return movie;
    }

    /**
     *
     * @param Genre
     * @return
     */
    public List<MovieVO> BuscarPorGenero (final String Genre)
    {
        MovieDao dao = new MovieDao();
        List<MovieVO> movie = dao.findByGenre(Genre);
                
        return movie;
    }
    
    /**
     *
     * @param id
     */
    public void eliminar(final String id) {
        MovieDao dao = new MovieDao();
        dao.delete(id);
    }
    
    /**
     *
     * @param movie
     */
    public void create(final MovieVO movie) {
       MovieDao dao = new MovieDao();
       dao.create(movie.getId(), movie.getTitle(), movie.getGenre());
    }
}