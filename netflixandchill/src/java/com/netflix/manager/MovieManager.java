package com.netflix.manager;



import com.netflix.dao.MovieDao;
import com.netflix.vo.MovieVO;
import java.sql.SQLException;
import java.util.List;



public class MovieManager
{
       
    public MovieVO consultar (final String id)
    {
        MovieDao dao = new MovieDao();
        MovieVO movie = dao.findById("" + id);
        
        return movie;
    }
    
    
    
    public List<MovieVO> listar ()
    {
        MovieDao dao = new MovieDao();
        List<MovieVO> movie = dao.findAll();
                
        return movie;
    }
    public List<MovieVO> BuscarPorGenero (final String Genre)
    {
        MovieDao dao = new MovieDao();
        List<MovieVO> movie = dao.findByGenre(Genre);
                
        return movie;
    }
    
    public void eliminar(final String id) {
        MovieDao dao = new MovieDao();
        dao.delete(id);
    }
    
    public void create(final MovieVO movie) {
       MovieDao dao = new MovieDao();
       dao.create(movie.getId(), movie.getTitle(), movie.getGenre());
    }
}