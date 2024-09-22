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
import java.util.List;

@WebServlet("/editar")
public class LivroUpdateController extends HttpServlet {

    LivroRepository repository = new LivroRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id =  Integer.valueOf(req.getParameter("id"));

        List<Livro> departments = repository.listarLivros();
        req.setAttribute("departments", departments);

        Livro livro = repository.buscarLivroPorId(id);
        req.setAttribute("livro", livro);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editar.jsp");
        dispatcher.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);

            String nome = req.getParameter("nome");
            String autor = req.getParameter("autor");
            LocalDate dataCriacao = LocalDate.now();
            String statusStr = req.getParameter("status");
            Status status = Status.valueOf(statusStr.toUpperCase());

            Livro livro = new Livro();
            livro.setId(id);
            livro.setNome(nome);
            livro.setAutor(autor);
            livro.setDataCriacao(dataCriacao);
            livro.setStatus(status);

            repository.atualizarLivro(livro);

            resp.sendRedirect(req.getContextPath() + "/");
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/livros?error=invalidId");
        }
    }
}
