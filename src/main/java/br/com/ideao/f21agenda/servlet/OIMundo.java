package br.com.ideao.f21agenda.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "primeiraServlet", value = "/oi")
public class OIMundo extends HttpServlet  {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("Primeira Servlet");
        out.println("</body>");
        out.println("</html>");
    }
}
