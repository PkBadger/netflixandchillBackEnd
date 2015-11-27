package com.netflix.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netflix.vo.UserMovieVO;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Dave
 */
public class UserMovieDAO {

    /**
     *
     * @param id
     * @return
     */
    public List<UserMovieVO> findbyMovie(final String id) {
        List<UserMovieVO> UserMovies = new ArrayList<UserMovieVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, userId,movieId FROM UserMovie WHERE UserMovie.movieId =?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                UserMovieVO UserMovie = new UserMovieVO();
                UserMovie.setId(rs.getString(1));
                UserMovie.setUserId(rs.getString(2));
                UserMovie.setMovieId(rs.getString(3));
              
                //Es necesario añadirla al array de personas
                UserMovies.add(UserMovie);
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
        return UserMovies;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public List<UserMovieVO> findbyUser(final String id) {
        List<UserMovieVO> UserMovies = new ArrayList<UserMovieVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, userId,movieId FROM UserMovie WHERE UserMovie.userId =?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                UserMovieVO UserMovie = new UserMovieVO();
                UserMovie.setId(rs.getString(1));
                UserMovie.setUserId(rs.getString(2));
                UserMovie.setMovieId(rs.getString(3));
                //Es necesario añadirla al array de personas
                UserMovies.add(UserMovie);
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
        return UserMovies;
    }
    
    /**
     *
     * @param id
     */
    public void delete(final String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM UserMovie WHERE movie.id = ?");
            //Se realiza el statement SQL, se pasa el id 1 a movie.id
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
    
    /**
     *
     * @param id
     * @param userId
     * @param movieId
     * @return
     */
    public UserMovieVO create(final String id, final String userId, final String movieId) {
      UserMovieVO UserMovie = new UserMovieVO();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                        
            UserMovie.setId(id);
            UserMovie.setUserId(userId);
            UserMovie.setMovieId(movieId);

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO UserMovie (userId, movieId) "
                    + "                                      VALUES (?, ?)");
            //Se realiza el statement SQL, se pasa el id 1 a movie.id
            pstmt.setString(1, userId);
            pstmt.setString(2, movieId);
            pstmt.executeUpdate(); //SE EJECUTA EL QUERY
            pstmt.close();
            conn.close();
            
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs2 = pstmt2.executeQuery();
            
            if(rs2.next()) {
                UserMovie.setId(rs2.getString(1));
                UserMovie.setUserId(rs2.getString(2));
                UserMovie.setMovieId(rs2.getString(3));
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
        return UserMovie;
  
    }

}
