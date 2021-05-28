package com.steve.self_facebook.controller;

import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.model.User;
import com.steve.self_facebook.utilities.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCommentServlet", value = "/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try(PrintWriter out = response.getWriter();) {
            out.println("<html><body>");
            out.println("<h1>" + "Servlet Registration example" + "</h1>");
            out.println("</body></html>");

            HttpSession httpSession = request.getSession();

            //postId
            int postId = Integer.parseInt(request.getParameter("postId"));
            User user = (User) httpSession.getAttribute("user");

            PostDatabase postDatabase = new PostDatabase(ConnectionManager.getConnection());

            if(postDatabase.deleteComment(postId, user.getId())){
                response.getWriter().write("Success deleting comment");
            }else{
                httpSession.setAttribute("message", "error deleting comment or you don't have access to delete this comment");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
