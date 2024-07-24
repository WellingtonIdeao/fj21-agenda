package br.com.ideao.f21agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("Executando a logica...");
        System.out.println("Retornando o nome da página JSP...");
        return "WEB-INF/jsp/primeira-logica.jsp";
    }
}
