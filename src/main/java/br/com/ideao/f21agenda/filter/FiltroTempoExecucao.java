package br.com.ideao.f21agenda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class FiltroTempoExecucao  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long tempoInicial = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest)servletRequest).getRequestURI();
        String parametros = ((HttpServletRequest)servletRequest).getParameter("logica");

        System.out.println("Tempo de requisição de " + uri + "?logica=" + parametros + " demorou (ms): " + (tempoFinal - tempoInicial));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
