package com.netflix.manager;



import com.netflix.dao.UserDao;
import com.netflix.vo.UserVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dave
 */
public class UserManager
{
       
    /**
     *
     * @param name
     * @return
     */
    public UserVO consultar (final String name)
    {
        UserDao dao = new UserDao();
        UserVO user = dao.findByName("" + name);
        
        return user;
    }
    
    /**
     *
     * @param name
     * @return
     */
    public UserVO findById(final String name)
    {
        UserDao dao = new UserDao();
        UserVO user = dao.findById(name);
        
        return user;
    }    
    
    /**
     *
     * @return
     */
    public List<UserVO> listar ()
    {
        UserDao dao = new UserDao();
        List<UserVO> user = dao.findAll();
                
        return user;
    }

    /**
     *
     * @param user
     */
    public void create(final UserVO user) {
       UserDao dao = new UserDao();
       dao.create(user.getId(), user.getUser(), user.getPhone(),user.getPassword(), user.getEmail());
    }
}
