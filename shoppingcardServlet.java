import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "shoppingcardServlet", value = "/shoppingcartServlet")
public class shoppingcardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reque, HttpServletResponse resp) throws ServletException, IOException {

            String msg;

            HttpSession session = reque.getSession(true);
            if(session.isNew())
            {
                session.setAttribute("foo", new int[] { 0 });
                session.setAttribute("bar", new int[] { 0 });
            }

            int[] foo = (int[])session.getAttribute("foo");
            int[] bar = (int[])session.getAttribute("bar");

            if(reque.getParameter("foo") != null)
            {
                foo[0]++;
                msg = "Bought a FOO. You now have "+foo[0]+".";
            }
            else if(reque.getParameter("bar") != null)
            {
                bar[0]++;
                msg = "Bought a BAR. You now have "+bar[0]+".";
            }
            else if(reque.getParameter("buy") != null)
            {
                session.invalidate();
                msg = "Your order for "+foo[0]+" FOOs and "+bar[0]+
                        " BARs has been accepted. Your shopping cart is empty now.";
            }
            else
            {
                msg = "You have "+foo[0]+" FOOs and "+bar[0]+
                        " BARs in your shopping cart.";
            }

            resp.setContentType("text/html");
            resp.setHeader("pragma", "no-cache");
            PrintWriter out = resp.getWriter();
            out.print("<HTML><HEAD><TITLE>Shopping Cart</TITLE></HEAD><BODY>");
            out.print(msg);
            out.print("<HR><A HREF=\"");
            out.print(resp.encodeRedirectURL(reque.getRequestURI()));
            out.print("\">Back to the shop</A></BODY></HTML>");
            out.close();
        }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String msg;

        HttpSession session = req.getSession(true);
        if(session.isNew())
        {
            session.setAttribute("foo", new int[] { 0 });
            session.setAttribute("bar", new int[] { 0 });
        }

        int[] foo = (int[])session.getAttribute("foo");
        int[] bar = (int[])session.getAttribute("bar");

        if(req.getParameter("foo") != null)
        {
            foo[0]++;
            msg = "Bought a FOO. You now have "+foo[0]+".";
        }
        else if(req.getParameter("bar") != null)
        {
            bar[0]++;
            msg = "Bought a BAR. You now have "+bar[0]+".";
        }
        else if(req.getParameter("buy") != null)
        {
            session.invalidate();
            msg = "Your order for "+foo[0]+" FOOs and "+bar[0]+
                    " BARs has been accepted. Your shopping cart is empty now.";
        }
        else
        {
            msg = "You have "+foo[0]+" FOOs and "+bar[0]+
                    " BARs in your shopping cart.";
        }

        res.setContentType("text/html");
        res.setHeader("pragma", "no-cache");
        PrintWriter out = res.getWriter();
        out.print("<HTML><HEAD><TITLE>Shopping Cart</TITLE></HEAD><BODY>");
        out.print(msg);
        out.print("<HR><A HREF=\"");
        out.print(res.encodeRedirectURL(req.getRequestURI()));
        out.print("\">Back to the shop</A></BODY></HTML>");
        out.close();
    }

        @Override
        public String getServletInfo()
        {
            return "ShoppingCartServlet2 from Lab2 servlet exercise";
        }
    }


