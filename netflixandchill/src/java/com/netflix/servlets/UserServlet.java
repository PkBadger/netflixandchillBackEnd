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
import java.util.Properties;
/**
 *
 * @author Alejandro
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/login/*"})
public class UserServlet extends HttpServlet {
    
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
         UserManager manager = new UserManager();
         PrintWriter out = response.getWriter();
         BufferedReader br = request.getReader();
         Gson gson = new Gson();
         Properties data = gson.fromJson(br, Properties.class);
         String username = data.getProperty("name");
         String password = data.getProperty("password");
         UserVO user = manager.consultar(String.valueOf(username));
         String json = new Gson().toJson(user);
         out.println(json);
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
    
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        UserManager managers = new UserManager();
        UserVO user = managers.consultar(String.valueOf('1'));
        System.out.println(user);
    }
}
