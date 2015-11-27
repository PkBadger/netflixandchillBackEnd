/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflix.servlets;

import com.google.gson.Gson;
import com.netflix.manager.ChillManager;
import com.netflix.manager.UserMovieManager;
import com.netflix.manager.UserManager;
import com.netflix.vo.ChillVO;
import com.netflix.vo.UserMovieVO;
import com.netflix.vo.UserVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ChillFromServlet", urlPatterns = {"/matchedBy/*"})
public class ChillFromServlet extends HttpServlet {

      
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
     
    //Returns id
    public Integer getId() {
      return id;
    }
 
    //Set the id
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
        ChillManager manager = new ChillManager();
        UserManager umanager = new UserManager();
        PrintWriter out = response.getWriter();
        try {
          RestRequest resourceValues = new RestRequest(request.getPathInfo());
          int id = resourceValues.getId();
          List<ChillVO> movies = manager.findFrom(String.valueOf(id));
           List<UserVO> users = new ArrayList<UserVO>();
          for(int i = 0;i<movies.size();i++)
          {
              UserVO usuario = umanager.findById(movies.get(i).getFrom());
              users.add(usuario);
          }
          String json = new Gson().toJson(users);
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
