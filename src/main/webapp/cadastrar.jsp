<%@ page import="java.util.List" %>
<%@ page import="model.Livro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Livro> livros = (List<Livro>) request.getAttribute("livros");

%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastrar Livro</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2>Cadastrar Livro</h2>
  <form action="/livros/adicionar" method="post">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome</label>
      <input type="text" class="form-control" id="nome" name="nome" required>
    </div>
    <div class="mb-3">
      <label for="autor" class="form-label">Autor</label>
      <input type="text" class="form-control" id="autor" name="autor" required>
    </div>
    <div class="mb-3">
      <label for="status" class="form-label">Status</label>
      <select class="form-select" id="status" name="status" required>
        <option value="DISPONIVEL">Disponível</option>
        <option value="INDISPONIVEL">Indisponível</option>
        <option value="EMPRESTADO">Emprestado</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
    <a href="/livros" class="btn btn-secondary">Cancelar</a>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
