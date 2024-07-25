package br.com.ideao.f21agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioAddLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return "WEB-INF/jsp/formulario-contato.jsp";
    }
}
