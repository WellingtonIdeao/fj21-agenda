package br.com.ideao.f21agenda.servlet;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/adicionaContato")
public class AdicionarContatoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereço = req.getParameter("endereco");
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(data);

        } catch (ParseException e) {
            out.println("Erro de conversão da data.");
            return;
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereço);
        contato.setDataNascimento(dataNascimento);


        try(Connection connection = new ConnectionFactory().getConnection()) {
            ContatoDao contatoDao = new ContatoDao(connection);
            contatoDao.adicionar(contato);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(req, resp);
    }
}
