package br.com.ideao.f21agenda.logica;

import br.com.ideao.f21agenda.dao.ContatoDao;
import br.com.ideao.f21agenda.factory.ConnectionFactory;
import br.com.ideao.f21agenda.model.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddAlterLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        try(Connection connection = new ConnectionFactory().getConnection()){
            ContatoDao dao = new ContatoDao(connection);

            String dataEmTexto = req.getParameter("dataNascimento");
            Calendar dataNascimento = null;
            try {
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
                dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(data);

            } catch (ParseException e) {
                throw new RuntimeException("Erro de conversão da data");
            }

            Contato contato = new Contato();
            contato.setNome(req.getParameter("nome"));
            contato.setEmail(req.getParameter("email"));
            contato.setEndereco(req.getParameter("endereco"));
            contato.setDataNascimento(dataNascimento);


            if(!req.getParameter("id").isEmpty()) {
                long id = Long.parseLong(req.getParameter("id"));
                contato.setId(id);
                dao.altera(contato);
                return "WEB-INF/jsp/contato-alterado.jsp";
            } else {
                dao.adicionar(contato);
                return "WEB-INF/jsp/contato-adicionado.jsp";
            }
        }
    }
}
