package com.steve.self_facebook.controller;

import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.utilities.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            int postId = Integer.parseInt(request.getParameter("postId"));
            System.out.println("Post Id id here "+postId);

            PostDatabase postDatabase = new PostDatabase(ConnectionManager.getConnection());

            if(postDatabase.deletePost(postId)){
                out.println("File uploaded to this directory");
                response.getWriter().write("Success Data");
            }else{
                out.print("500 error");
                response.getWriter().write("Failed do delete post");
            }

            response.sendRedirect("home.jsp");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
