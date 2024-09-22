package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Livro;
import model.Status;
import repositories.LivroRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/adicionar")
public class LivroCreateController extends HttpServlet {

    LivroRepository repository = new LivroRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastrar.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");
        String statusString = req.getParameter("status");
        Status status = Status.valueOf(statusString);
        LocalDate dataCriacao = LocalDate.now();

        Livro novoLivro = new Livro(0, nome, autor, dataCriacao, status);
        repository.inserirLivro(novoLivro);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
