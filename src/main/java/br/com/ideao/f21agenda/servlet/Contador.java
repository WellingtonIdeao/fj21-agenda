package br.com.ideao.f21agenda.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contador")
public class Contador extends HttpServlet {
    private int contador;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contador++;
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("O contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
    }
}
