package controller;

import jakarta.servlet.RequestDispatcher;
import model.Livro;
import repositories.LivroRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"", "/livros"})
public class LivroController extends HttpServlet {
    private LivroRepository livroRepository;

    public LivroController(){
         livroRepository = new LivroRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = livroRepository.listarLivros();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/livros.jsp");
        request.setAttribute("livros", livros);

        dispatcher.forward(request, response);
    }
}
