<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Funcionários</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <div class="container">
        <h1>Funcionários Cadastrados</h1>
        <c:forEach items="${funcionarios}" var="funcionario" >
        <ul class="employee-list">
            <li class="employee-item">
                <span>${funcionario.nome} - ${funcionario.cargo}</span>
                <a href="funcionario?idFuncionario=${funcionario.id}" class="button">Ver Detalhes</a>
                
                
           
            <!-- Adicione mais funcionÃ¡rios aqui -->
        </ul>
         </c:forEach >
        <button class="add-button" onclick="window.location.href='form.html'">Adicionar Novo Funcionário</button>
    </div>
    
</body>
</html>