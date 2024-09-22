<%@ page import="java.util.List" %>
<%@ page import="model.Livro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Livro> livros = (List<Livro>) request.getAttribute("livros");
    System.out.println("Número de livros: " + livros.size());
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administração de Livros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/dashboard.css">
</head>
<body class="bg-light">

<!-- Menu superior -->
<nav class="navbar navbar-expand-lg shadow-sm navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Livraria</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <!-- Conteúdo principal -->
        <main class="justify-content-center">

            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Livros Cadastrados</h1>
                <a href="/livros/adicionar" class="btn btn-primary">Adicionar Livro</a>
            </div>

            <!-- Tabela de livros -->
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Data de Criação</th>
                        <th>Status</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Livro livro : livros) { %>
                    <tr>
                        <td><%= livro.getId() %></td>
                        <td><%= livro.getNome() %></td>
                        <td><%= livro.getAutor() %></td>
                        <td><%= livro.getDataCriacao() %></td>
                        <td><%= livro.getStatus() %></td>
                        <td>
                            <a href="/livros/editar?id=<%= livro.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                            <a href="/livros/excluir?id=<%= livro.getId() %>" class="btn btn-sm btn-danger">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
