package br.com.ideao.f21agenda.logica;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdicionaContatoLogica implements Logica {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

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
            throw new RuntimeException("Erro de conversão da data.");
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereço);
        contato.setDataNascimento(dataNascimento);


        Connection connection = (Connection) req.getAttribute("connection");
        ContatoDao contatoDao = new ContatoDao(connection);
        contatoDao.adicionar(contato);

        System.out.println("Adicionando contato...");
        return "WEB-INF/jsp/contato-adicionado.jsp";
    }
}
