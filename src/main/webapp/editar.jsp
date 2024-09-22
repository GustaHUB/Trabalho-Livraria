<%@ page import="model.Livro" %>
<%@ page import="model.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Livro livro = (Livro) request.getAttribute("livro");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Livro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Editar Livro</h2>
    <form action="<%= request.getContextPath() %>/editar" method="post">
    <input type="hidden" name="id" value="<%= livro.getId() %>">
    <div class="mb-3">
        <label for="nome" class="form-label">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome" value="<%= livro.getNome() %>" required>
    </div>
    <div class="mb-3">
        <label for="autor" class="form-label">Autor</label>
        <input type="text" class="form-control" id="autor" name="autor" value="<%= livro.getAutor() %>" required>
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select class="form-select" id="status" name="status" required>
            <option value="DISPONIVEL" <%= livro.getStatus() == Status.DISPONIVEL ? "selected" : "" %>>Disponível</option>
            <option value="INDISPONIVEL" <%= livro.getStatus() == Status.INDISPONIVEL ? "selected" : "" %>>Indisponível</option>
            <option value="EMPRESTADO" <%= livro.getStatus() == Status.EMPRESTADO ? "selected" : "" %>>Emprestado</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Atualizar</button>
    <a href="/livros" class="btn btn-secondary">Cancelar</a>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
