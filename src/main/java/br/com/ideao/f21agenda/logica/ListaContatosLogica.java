package br.com.ideao.f21agenda.logica;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class ListaContatosLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try(Connection connection = new ConnectionFactory().getConnection()) {
            ContatoDao dao = new ContatoDao(connection);
            List<Contato> contatos = dao.getLista();
            req.setAttribute("contatos", contatos);
        }
        return "WEB-INF/jsp/lista-contatos-scriptlets.jsp";
    }
}
