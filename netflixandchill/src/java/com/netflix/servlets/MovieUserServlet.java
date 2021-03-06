/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflix.servlets;

import com.google.gson.Gson;
import com.netflix.manager.UserMovieManager;
import com.netflix.vo.UserMovieVO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "MovieUserServlet", urlPatterns = {"/movies/*"})
public class MovieUserServlet extends HttpServlet {

      
    private class RestRequest {
    // Accommodate two requests, one for all resources, another for a specific resource
    private Pattern regExIdPattern = Pattern.compile("/([0-9]*)");
 
    private Integer id;
 
    public RestRequest(String pathInfo) throws ServletException {
      // regex parse pathInfo
      Matcher matcher;
 
      // Check for ID case first, since the All pattern would also match
      matcher = regExIdPattern.matcher(pathInfo);
      if (matcher.find()) {
        id = Integer.parseInt(matcher.group(1));
        return;
      }
 
      throw new ServletException("Invalid URI");
    }
 
    //get Id
    public Integer getId() {
      return id;
    }
 
    //Set Id
    public void setId(Integer id) {
      this.id = id;
    }
  }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserMovieManager manager = new UserMovieManager();
        PrintWriter out = response.getWriter();
        try {
          RestRequest resourceValues = new RestRequest(request.getPathInfo());
          int id = resourceValues.getId();
          List<UserMovieVO> movies = manager.findByUser(String.valueOf(id));
          String json = new Gson().toJson(movies);
          out.println(json);
        } catch (ServletException e) {
          response.setStatus(400);
          response.resetBuffer();
          e.printStackTrace();
          out.println(e.toString());
        }
        
        out.close();
        
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         UserMovieManager manager = new UserMovieManager();
         PrintWriter out = response.getWriter();
         BufferedReader br = request.getReader();
         Gson gson = new Gson();
         Properties data = gson.fromJson(br, Properties.class);
         String movieId = data.getProperty("imdbId");
         String userid = data.getProperty("usrId");
         UserMovieVO userMovie = new UserMovieVO();
         userMovie.setMovieId(String.valueOf(movieId));
         userMovie.setUserId(String.valueOf(userid));
         manager.create(userMovie);
         String json = new Gson().toJson(userMovie);
         out.println(json);
        out.close();      
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         UserMovieManager manager = new UserMovieManager();
         PrintWriter out = response.getWriter();
                 try {
          RestRequest resourceValues = new RestRequest(request.getPathInfo());
          int id = resourceValues.getId();
          manager.eliminar(String.valueOf(id));
          out.println("Movie deleted.");
        } catch (ServletException e) {
          response.setStatus(400);
          response.resetBuffer();
          e.printStackTrace();
          out.println(e.toString());
        }
        out.close();
        
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
