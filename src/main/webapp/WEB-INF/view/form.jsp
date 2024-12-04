<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Funcionário</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <div class="form-wrapper">
            <h2>Adicionar Novo Funcionário</h2>
            <form action="${funcionario.id != null ? 'atualizarFuncionario' : 'adicionarFuncionario' }?idFuncionario=${funcionario.id}" method="POST">
                <label for="nome">Nome:</label>
                <input value="${funcionario.nome}" type="text" id="nome" name="nome" required>

                <label for="cargo">Cargo:</label>
                <input value="${funcionario.cargo}" type="text" id="cargo" name="cargo" required>

                <label for="email">Email:</label>
                <input value="${funcionario.email}" type="email" id="email" name="email" required>

                <label for="telefone">Telefone:</label>
                <input value="${funcionario.telefone}" type="tel" id="telefone" name="telefone" required>

                <input type="submit" value="Cadastrar" class="button">
            </form>
            <button class="button" style="background-color: #6c757d;" onclick="window.location.href='home.html'">Voltar</button>
        </div>
    </div>
</body>
</html>