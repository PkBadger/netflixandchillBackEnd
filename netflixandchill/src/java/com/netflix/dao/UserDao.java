package com.netflix.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netflix.vo.UserVO;
import com.mysql.jdbc.Connection;



public class UserDao {


    public List<UserVO> findAll() {
        List<UserVO> users = new ArrayList<UserVO>();
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, username,phone,email FROM user ORDER BY username");
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                UserVO user = new UserVO();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPhone(rs.getString(3));
                user.setEmail(rs.getString(4));
                
                //Es necesario añadirla al array de personas
                users.add(user);
            }
            //SE CIERRAN CONEXIONES, ES NECESARIO
            rs.close();
            pstmt.close();
            conn.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

   /* public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();
        System.out.println(dao.findById("1"));
    }*/

    public UserVO findByName(final String id) {
        //ENCUENTRA POR ID LA RESPECTIVA PERSONA EN LA DATABASE
        UserVO user = null;
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, username,phone,email  FROM user WHERE user.username =?");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); //SE EJECUTA EL QUERY
            user = null;
            while (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPhone(rs.getString(3));
                user.setEmail(rs.getString(4));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Si no hay errores, se regresa la persona creada
        return user;
    }
    
    public UserVO findById(final String id) {
        //ENCUENTRA POR ID LA RESPECTIVA PERSONA EN LA DATABASE
        UserVO user = null;
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, username,phone,email  FROM user WHERE user.id =?");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); //SE EJECUTA EL QUERY
            user = null;
            while (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPhone(rs.getString(3));
                user.setEmail(rs.getString(4));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Si no hay errores, se regresa la persona creada
        return user;
    }
    
   public UserVO create(final String id, final String username, final String phone, final String password, final String Email) {
      UserVO user = new UserVO();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            
            user.setId(id);
            user.setUsername(username);
            user.setPhone(phone);
            user.setPassword(password);
            user.setEmail(Email);

            
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (username, phone,password,email) "
                    + "                                      VALUES (?, ?, ?, ?)");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, username);
            pstmt.setString(2, phone);
            pstmt.setString(3, password);
            pstmt.setString(4, Email);
            pstmt.executeUpdate(); //SE EJECUTA EL QUERY
            pstmt.close();
            conn.close();
            
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs2 = pstmt2.executeQuery();
            
            if(rs2.next()) {
                user.setId(rs2.getString(1));
                user.setUsername(rs2.getString(2));
                user.setPhone(rs2.getString(3));
                user.setPassword(rs2.getString(4));
                user.setEmail(rs2.getString(5));
            }
            rs2.close();
           
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

       
        
        
    }
    

}
