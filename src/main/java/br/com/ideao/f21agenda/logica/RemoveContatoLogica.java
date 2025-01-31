package br.com.ideao.f21agenda.logica;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContatoLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        Connection connection = (Connection) req.getAttribute("connection");
        ContatoDao dao = new ContatoDao(connection);

        Contato contato = new Contato();
        contato.setId(id);

        dao.exclui(contato);
        System.out.println("Excluindo contato...");

        return "mvc?logica=ListaContatosLogica";
    }
}
