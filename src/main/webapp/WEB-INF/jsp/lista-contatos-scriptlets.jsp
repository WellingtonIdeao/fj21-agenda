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
        <thead>
            <tr>
                <th scope="col">Nome</th>
                <th scope="col">Email</th>
                <th scope="col">Endereco</th>
                <th scope="col">Data de Nascimento</th>
            </tr>
        </thead>

    <c:forEach var="contato" items="${contatos}">
        <tbody>
            <tr>
                <th scope="row">${contato.nome}</th>
                <td>${contato.email}</td>
                <td>${contato.endereco}</td>
                <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
                <td><a href="mvc?logica=FormularioAlterarLogica&id=${contato.id}">Editar</a></td>
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