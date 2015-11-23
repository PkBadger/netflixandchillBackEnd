package com.netflix.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netflix.vo.ChillVO;
import com.mysql.jdbc.Connection;


public class ChillDAO {


    public List<ChillVO> findFrom(final String id) {
        List<ChillVO> chills = new ArrayList<ChillVO>();
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, from_id,to_id FROM chill WHERE chill.from_id =?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                ChillVO chill = new ChillVO();
                chill.setId(rs.getString(1));
                chill.setFrom(rs.getString(2));
                chill.setTo(rs.getString(3));
              
                //Es necesario añadirla al array de personas
                chills.add(chill);
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
        return chills;
    }
    
   public List<ChillVO> findTo(final String id) {
        List<ChillVO> chills = new ArrayList<ChillVO>();
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, from_id,to_id FROM chill WHERE chill.to_id =?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                ChillVO chill = new ChillVO();
                chill.setId(rs.getString(1));
                chill.setFrom(rs.getString(2));
                chill.setTo(rs.getString(3));
              
                //Es necesario añadirla al array de personas
                chills.add(chill);
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
        return chills;
    }

    public void delete(final String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM chill WHERE chill.id = ?");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, id);
            pstmt.executeUpdate(); //SE EJECUTA EL QUERY
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
        
    }
    
    public ChillVO create(final String id, final String from, final String to) {
      ChillVO chill = new ChillVO();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            
            chill.setId(id);
            chill.setFrom(from);
            chill.setTo(to);

            
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO chill (from_id, to_id) "
                    + "                                      VALUES (?, ?)");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, from);
            pstmt.setString(2, to);
            pstmt.executeUpdate(); //SE EJECUTA EL QUERY
            pstmt.close();
            conn.close();
            
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs2 = pstmt2.executeQuery();
            
            if(rs2.next()) {
                chill.setId(rs2.getString(1));
                chill.setFrom(rs2.getString(2));
                chill.setTo(rs2.getString(3));
            }
            rs2.close();
           
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chill;

       
        
        
    }

    

}
