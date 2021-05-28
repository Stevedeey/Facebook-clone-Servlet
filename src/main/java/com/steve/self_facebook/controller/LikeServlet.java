package com.steve.self_facebook.controller;

import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.model.User;
import com.steve.self_facebook.utilities.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();){
            out.println("<html><body>");
            out.println("<h1>" + "Servlet Registration example" + "</h1>");
            out.println("</body></html>");

            HttpSession httpSession = request.getSession();
            //fetch data from post form
            int action = Integer.parseInt(request.getParameter("action"));
            int postId = Integer.parseInt(request.getParameter("postId"));
//            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = (User) httpSession.getAttribute("user");

            response.getWriter().write(action+postId+user.getId());

            PostDatabase postDatabase = new PostDatabase(ConnectionManager.getConnection());

            if(postDatabase.likePost(user.getId(), postId, action)){
                response.getWriter().write("Success liking/disliking post");
            }else{
                out.print("500 error");
                response.getWriter().write("Failed do liking post");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
