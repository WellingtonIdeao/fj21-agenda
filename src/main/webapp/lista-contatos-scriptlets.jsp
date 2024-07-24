<%@ page import="br.com.ideao.f21agenda.dao.ContatoDao, br.com.ideao.f21agenda.model.Contato, br.com.ideao.f21agenda.factory.ConnectionFactory, java.util.List, java.sql.Connection, java.sql.SQLException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar Contatos</title>
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css">
    <table>
    <%
        List<Contato> contatos = null;
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ContatoDao dao = new ContatoDao(connection);
            contatos = dao.getLista();
            request.setAttribute("lista", contatos);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>
        <thead>
            <tr>
                <th scope="col">Nome</th>
                <th scope="col">Email</th>
                <th scope="col">Endereco</th>
                <th scope="col">Data de Nascimento</th>
            </tr>
        </thead>

    <c:forEach var="contato" items="${lista}">
        <tbody>
            <tr>
                <th scope="row">${contato.nome}</th>
                <td>${contato.email}</td>
                <td>${contato.endereco}</td>
                <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
                <td><a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
            </tr>
        </tbody>
    </c:forEach>
        <tfoot>
            <tr>
                <th scope="row" colspan="4"></th>
            </tr>
        </tfoot>
    </table>
</body>
</html>