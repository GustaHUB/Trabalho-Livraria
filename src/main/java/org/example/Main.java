package org.example;

import model.Livro;
import model.Status;
import service.LivroService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LivroService livroService = new LivroService();

        // Adicionar um livro de teste
        Livro livro1 = new Livro(0, "O Senhor dos Anéis", "J.R.R. Tolkien", LocalDate.now(), Status.DISPONIVEL);
        livroService.adicionarLivro(livro1);

        // Listar todos os livros
        List<Livro> livros = livroService.listarLivros();
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}
