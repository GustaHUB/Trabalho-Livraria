package service;

import controller.LivroController;
import model.Livro;
import repositories.LivroRepository;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository = new LivroRepository();

    public List<Livro> listarLivros() {
        return livroRepository.listarLivros();
    }

    public void adicionarLivro(Livro livro) {
        livroRepository.inserirLivro(livro);
    }

    // Outros métodos de negócio
}
