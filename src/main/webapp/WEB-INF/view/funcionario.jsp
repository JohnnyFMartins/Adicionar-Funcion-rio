<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informações do Funcionário</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
    
        <div class="card">
         
            <h2>${funcionario.nome}</h2>
            <p><strong>Cargo:</strong> ${funcionario.cargo}</p>
            <p><strong>Email:</strong> ${funcionario.email}</p>
            <p><strong>Telefone:</strong> ${funcionario.telefone}</p>

            <button class="button" onclick="window.location.href='form?idFuncionario=${funcionario.id}'">Editar Funcionário</button>
            <button class="button" style="background-color: #dc3545;" onclick="window.location.href='deletarFuncionario?idFuncionario=${funcionario.id}'">Deletar Funcionário</button>
            <button class="button" style="background-color: #6c757d;" onclick="window.location.href='home.html'">Voltar</button>
        
        
        		<!--  	 <td class="acoes">
                        <a href="funcionario?idFuncionario=${funcionario.id}">Visualizar</a>
                        <a href="form?idFuncionario=${funcionario.id}">Editar</a>
                        <a href="deletarFuncionario?idFuncionario=${funcionario.id}">Deletar</a>
                    </td> -->
        
        
        
        
        
        </div>
    </div>
</body>
</html>