package com.netflix.manager;



import com.netflix.dao.UserDao;
import com.netflix.vo.UserVO;
import java.sql.SQLException;
import java.util.List;



public class UserManager
{
       
    public UserVO consultar (final String id)
    {
        UserDao dao = new UserDao();
        UserVO user = dao.findById("" + id);
        
        return user;
    }
    
    
    
    public List<UserVO> listar ()
    {
        UserDao dao = new UserDao();
        List<UserVO> user = dao.findAll();
                
        return user;
    }

    public void create(final UserVO user) {
       UserDao dao = new UserDao();
       dao.create(user.getId(), user.getUser(), user.getPhone(),user.getPassword(), user.getImage());
    }
}