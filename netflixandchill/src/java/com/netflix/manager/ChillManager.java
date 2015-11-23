package com.netflix.manager;



import com.netflix.dao.ChillDAO;
import com.netflix.vo.ChillVO;
import java.util.List;



public class ChillManager
{
    /*  
    public UserMovieVO consultar (final String id)
    {
        UserMovieDAO dao = new UserMovieDAO();
        UserMovieVO  movie = dao.findById("" + id);
        
        return movie;
    }*/
    
    
    
    public List<ChillVO> findFrom (final String id)
    {
        ChillDAO dao = new ChillDAO();
        List<ChillVO > movie = dao.findFrom(id);
                
        return movie;
    }
     public List<ChillVO > findTo (final String id)
    {
      ChillDAO dao = new ChillDAO();
        List<ChillVO > movie = dao.findTo(id);
                
        return movie;
    }
    
    public void eliminar(final String from_id, final String to_id) {
       ChillDAO dao = new ChillDAO();
        dao.delete(from_id, to_id);
    }
    
    public void create(final ChillVO chill) {
      ChillDAO dao = new ChillDAO();
       dao.create(chill.getId(), chill.getFrom(), chill.getTo());
    }
}