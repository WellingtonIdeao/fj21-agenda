package br.com.ideao.f21agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
    String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
