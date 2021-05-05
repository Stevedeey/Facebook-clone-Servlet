package com.steve.self_facebook.controller;

import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.model.Post;
import com.steve.self_facebook.model.User;
import com.steve.self_facebook.utilities.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>" + "update post" + "</h1>");
            out.println("</body></html>");

            HttpSession httpSession = request.getSession();
            String title = request.getParameter("title");
            String body = request.getParameter("body");
            int postId = Integer.parseInt(request.getParameter("postId"));

            Post post = new Post(title, body);
            PostDatabase postDatabase = new PostDatabase(ConnectionManager.getConnection());

            if (postDatabase.updatePost(postId, post)) {
                out.println("File uploaded to this directory");
                httpSession.setAttribute("message", "successful");
            } else {
                out.print("500 error");
                httpSession.setAttribute("message", "Error uploading data");
            }

            response.sendRedirect("home.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
