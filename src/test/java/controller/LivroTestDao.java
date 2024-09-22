package controller;

import model.Livro;
import model.Status;
import org.junit.jupiter.api.Test;
import repositories.LivroRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTestDao {
    LivroRepository livroRepository = new LivroRepository();

    @Test
    public void exibirListaDeLivros() {

        List<Livro> livros = livroRepository.listarLivros();

        for (Livro livro : livros) {
            System.out.println(livro);
        }

        assertFalse(livros.isEmpty(), "A lista de livros não deve estar vazia.");
    }

    @Test
    public void inserirLivro() {
        LivroController livroController = new LivroController();
        Livro livro = new Livro(0, "Novo Livro", "Autor Teste 23", LocalDate.now(), Status.DISPONIVEL);
        livroRepository.inserirLivro(livro);
    }

    @Test
    public void atualizarLivro() {
        LivroController livroController = new LivroController();

        Livro livroAtualizado = new Livro(4, "Livro Atualizado", "Autor Modificado", LocalDate.now(), Status.DISPONIVEL);
        livroRepository.atualizarLivro(livroAtualizado);
    }

    @Test
    public void excluirLivro() {
        LivroController livroController = new LivroController();
        Livro livro = new Livro(5, "Livro para Excluir", "Autor Teste", LocalDate.now(), Status.DISPONIVEL);

        livroRepository.excluirLivro(livro.getId());
    }
}
