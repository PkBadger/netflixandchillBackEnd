/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflix.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.netflix.manager.UserManager;
import com.netflix.vo.UserVO;
import java.io.BufferedReader;
import java.util.List;
/**
 *
 * @author Alejandro
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/api/*"})
public class UserServlet extends HttpServlet {
    
    private class RestRequest {
    // Accommodate two requests, one for all resources, another for a specific resource
    private Pattern regExAllPattern = Pattern.compile("/users");
    private Pattern regExIdPattern = Pattern.compile("/users/([0-9]*)");
 
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
 
      matcher = regExAllPattern.matcher(pathInfo);
      if (matcher.find()) { 
          id = -1;
          return;
      }
 
      throw new ServletException("Invalid URI");
    }
 
    public Integer getId() {
      return id;
    }
 
    public void setId(Integer id) {
      this.id = id;
    }
  }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager manager = new UserManager();
        PrintWriter out = response.getWriter();
        try {
          RestRequest resourceValues = new RestRequest(request.getPathInfo());
          int id = resourceValues.getId();
          out.println(id);
          if (id != -1) {
          UserVO user = manager.consultar(String.valueOf(id));
          String json = new Gson().toJson(user);
          out.println(json);
          }
          else {
            List<UserVO> list = manager.listar();
            String json2 = new Gson().toJson(list);
            out.println(json2);
          }
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
         PrintWriter out = response.getWriter();
         StringBuilder sb = new StringBuilder();
         BufferedReader br = request.getReader();
         String str;
         while( (str = br.readLine()) != null ){
             sb.append(str);
         }  
         out.println(sb);
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
    
    public static void main(String args[]) {
        UserManager managers = new UserManager();
        UserVO user = managers.consultar(String.valueOf('1'));
        System.out.println(user);
    }
}
