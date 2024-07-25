<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contato</title>
</head>
<body>
    <form action="mvc?logica=${redirect}" method="POST">
        <input type="hidden" name="id" value="${contato.id}"/>
        Nome: <input type="text" name="nome" value="${contato.nome}" /> <br/>
        E-mail: <input type="text" name="email" value="${contato.email}" /> <br/>
        Endereço: <input type="text" name="endereco" value="${contato.endereco}" /> <br/>
        Data Nascimento: <input type="text" name="dataNascimento" value='<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>'/><br/>

        <input type="submit" value="Gravar" />
    </form>
    <p><a href="mvc?logica=ListaContatosLogica">Retornar a lista de Contatos</a></p>
</body>
</html>