import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

//@WebServlet(name = "showcardServlet", value = "/showcardServlet")
public class showcardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* HttpSession session = request.getSession(true); */

        Cookie[] cookies = request.getCookies();

        int length = cookies.length;

        String userName = null;
        String password = null;

        for (int i=0; i<length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("userName"))
                userName = cookie.getValue();
            else if (cookie.getName().equals("password"))
                password = cookie.getValue();
        }
/*
String userName = request.getParameter("userName");
String password = request.getParameter("password");
if (userName != null && password != null) {
session.setAttribute(userName, password);
}

Enumeration names = session.getAttributeNames();
while (names.hasMoreElements()) {
String name = (String) names.nextElement();
String value = session.getAttribute(name).toString();

*/


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Items to buy</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");


        out.println("Hello Mr. " + userName + " <BR>Your password is: "+password);



        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>Select books to buy:");
        out.println("<BR><FORM METHOD=POST>");

        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE= \"Java for the Web with Servlets, JSP, and EJB: A Developer's Guide to J2EE Solutions\"> Java for the Web with Servlets, JSP, and EJB: A Developer's Guide to J2EE Solutions");

        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE=\"Java Enterprise in a Nutshell\"> Java Enterprise in a Nutshell");

        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE= \"Core J2EE Patterns: Best Practices and Design Strategies\"> Core J2EE Patterns: Best Practicees and Design Strategies");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE=\"EJB 3 in Action\"> EJB 3 in Action");
        out.println("<BR>");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=\"Add to Cart\">");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] number = request.getParameterValues("book");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (number != null ) {

            int length = number.length;
            out.println("Books added in to your cart : ");
            out.println("<BR>");

            for (int i=0; i<length; i++) {
                out.println("<BR>" + number[i]);
            }
        }
        else
        {
            out.println("You have not selected any book, please go back and select books to buy");
        }

    }
}