package br.com.ideao.f21agenda.logica;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class FormularioAlterarLogica implements Logica {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        try(Connection connection = new ConnectionFactory().getConnection()) {
            ContatoDao dao = new ContatoDao(connection);
            Contato contato = dao.busca(id);

            req.setAttribute("redirect", "AlteraContatoLogica");
            req.setAttribute("contato", contato);
        }
        return "WEB-INF/jsp/formulario-contato.jsp";
    }
}
