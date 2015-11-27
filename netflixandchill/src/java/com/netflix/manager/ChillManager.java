package com.netflix.manager;



import com.netflix.dao.ChillDAO;
import com.netflix.vo.ChillVO;
import java.util.List;

/**
 *
 * @author Dave
 */
public class ChillManager
{

    /**
     *
     * @param id
     * @return
     */
    
    public List<ChillVO> findFrom (final String id)
    {
        ChillDAO dao = new ChillDAO();
        List<ChillVO > movie = dao.findFrom(id);
                
        return movie;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<ChillVO > findTo (final String id)
    {
      ChillDAO dao = new ChillDAO();
        List<ChillVO > movie = dao.findTo(id);
                
        return movie;
    }
    
    /**
     *
     * @param from_id
     * @param to_id
     */
    public void eliminar(final String from_id, final String to_id) {
       ChillDAO dao = new ChillDAO();
        dao.delete(from_id, to_id);
    }
    
    /**
     *
     * @param chill
     */
    public void create(final ChillVO chill) {
      ChillDAO dao = new ChillDAO();
       dao.create(chill.getId(), chill.getFrom(), chill.getTo());
    }
}