package com.netflix.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netflix.vo.MovieVO;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Dave
 */
public class MovieDao {

    /**
     *
     * @return
     */
    public List<MovieVO> findAll() {
        List<MovieVO> movies = new ArrayList<MovieVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, title,genre FROM movie ORDER BY title");
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                MovieVO movie = new MovieVO();
                movie.setId(rs.getString(1));
                movie.setTitle(rs.getString(2));
                movie.setGenre(rs.getString(3));
                //Es necesario añadirla al array de personas
                movies.add(movie);
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
        return movies;
    }
    
    /**
     *
     * @param Genre
     * @return
     */
    public List<MovieVO> findByGenre(final String Genre) {
        List<MovieVO> movies = new ArrayList<MovieVO>();
        try {
            /* EXAMEN */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, title,genre FROM movie WHERE movie.genre = ? ORDER BY title");
            pstmt.setString(1, Genre);
            ResultSet rs = pstmt.executeQuery();
            //Se itera sobre el ResultSet, tomando los parametros
            while (rs.next()) {
                //Se crea la Perona y se establecen sus parametros
                MovieVO movie = new MovieVO();
                movie.setId(rs.getString(1));
                movie.setTitle(rs.getString(2));
                movie.setGenre(rs.getString(3));
                //Es necesario añadirla al array de personas
                movies.add(movie);
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
        return movies;
    }

    /**
     *
     * @param id
     * @return
     */
    
    public MovieVO findById(final String id) {
        //ENCUENTRA POR ID LA RESPECTIVA PERSONA EN LA DATABASE
        MovieVO movie = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, title, genre FROM movie WHERE movie.id =?");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); //SE EJECUTA EL QUERY
            movie = null;
            while (rs.next()) {
                movie = new MovieVO();
                movie.setId(rs.getString(1));
                movie.setTitle(rs.getString(2));
                movie.setGenre(rs.getString(3));
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
        return movie;
    }
    
    /**
     *
     * @param id
     */
    public void delete(final String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM movie WHERE movie.id = ?");
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
    
    /**
     *
     * @param id
     * @param title
     * @param genre
     * @return
     */
    public MovieVO create(final String id, final String title, final String genre) {
      MovieVO movie = new MovieVO();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
               
            movie.setId(id);
            movie.setTitle(title);
            movie.setGenre(genre);
            
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO movie (title, genre) "
                    + "                                      VALUES (?, ?)");
            //Se realiza el statement SQL, se pasa el id 1 a persona.id
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.executeUpdate(); //SE EJECUTA EL QUERY
            pstmt.close();
            conn.close();
            
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs2 = pstmt2.executeQuery();
            
            if(rs2.next()) {
                movie.setId(rs2.getString(1));
                movie.setTitle(rs2.getString(2));
                movie.setGenre(rs2.getString(3));
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
        return movie;
  
    }
    
}
