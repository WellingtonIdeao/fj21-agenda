<%@ page import="br.com.ideao.f21agenda.dao.ContatoDao, br.com.ideao.f21agenda.model.Contato, br.com.ideao.f21agenda.factory.ConnectionFactory, java.util.List, java.sql.Connection, java.sql.SQLException" %>
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
    <%  for (Contato contato: contatos) { %>
        <tbody>
            <tr>
                <th scope="row"><%=contato.getNome() %></th>
                <td><%=contato.getEmail() %></td>
                <td><%=contato.getEndereco() %></td>
                <td><%=contato.getDataNascimento().getTime() %></td>
            </tr>
        </tbody>

    <% } %>
        <tfoot>
            <tr>
                <th scope="row" colspan="4"></th>
            </tr>
        </tfoot>
    </table>
</body>
</html>