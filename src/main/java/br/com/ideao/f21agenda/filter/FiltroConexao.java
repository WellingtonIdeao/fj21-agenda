package br.com.ideao.f21agenda.filter;

import br.com.ideao.f21agenda.factory.ConnectionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class FiltroConexao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try(Connection connection = new ConnectionFactory().getConnection()) {
            servletRequest.setAttribute("connection", connection);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
