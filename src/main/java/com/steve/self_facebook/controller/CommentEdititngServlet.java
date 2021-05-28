package com.steve.self_facebook.controller;

import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.model.User;
import com.steve.self_facebook.utilities.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentEdititngServlet", value = "/CommentEdititngServlet")
public class CommentEdititngServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();) {
            HttpSession httpSession = request.getSession();
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            //postId
            int postId = Integer.parseInt(request.getParameter("postId"));
            String comment = request.getParameter("editedComment");
            //int userId = Integer.parseInt(request.getParameter("userId"));
            User user = (User) httpSession.getAttribute("user");

            PostDatabase postDatabase = new PostDatabase(ConnectionManager.getConnection());

            if(postDatabase.editComment(user.getId(), postId, comment)){
                response.getWriter().write("Success editing post");
            }else{
                response.getWriter().write("Error editing post or you don't have access to delete this comment");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
