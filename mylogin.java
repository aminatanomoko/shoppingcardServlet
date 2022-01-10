import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

//@WebServlet(name = "mylogin", value = "/mylogin")
public class mylogin extends HttpServlet {
    private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Login</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");

        if (withErrorMessage)
            out.println("Login failed. Please try again.<BR>");
        out.println("<BR>");
        out.println("<BR>Please enter your user name and password.");
        out.println("<BR><FORM METHOD=POST>");
        out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR>Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendLoginForm(response, false);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name_user = request.getParameter("userName");
        String password = request.getParameter("password");


        Cookie A_1 = new Cookie("userName", Name_user);
        Cookie A_2 = new Cookie ("password", password);
        response.addCookie(A_1);
        response.addCookie(A_2);
        if (Name_user!=null && password!=null && Name_user.equals("web_arch") && password.equals("course_cse")) {
            response.sendRedirect("/Lab2/showcart");
        }
        else {
            sendLoginForm(response, true);
        }
    }
}

