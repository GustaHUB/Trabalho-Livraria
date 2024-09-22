package repositories;

import connection.ConnectionFactory;
import model.Livro;
import model.Status;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    private Connection connection;

    public LivroRepository() {
        this.connection = ConnectionFactory.getConnection();
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String autor = rs.getString("autor");
                LocalDate dataCriacao = rs.getDate("data_criacao").toLocalDate();
                Status status = Status.valueOf(rs.getString("status"));

                livros.add(new Livro(id, nome, autor, dataCriacao, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public void inserirLivro(Livro livro) {
        String sql = "INSERT INTO livros (nome, autor, data_criacao, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, livro.getNome());
            st.setString(2, livro.getAutor());
            st.setDate(3, Date.valueOf(livro.getDataCriacao()));
            st.setString(4, livro.getStatus().name());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET nome = ?, autor = ?, data_criacao = ?, status = ? WHERE id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, livro.getNome());
            st.setString(2, livro.getAutor());
            st.setDate(3, Date.valueOf(livro.getDataCriacao()));
            st.setString(4, livro.getStatus().name());
            st.setInt(5, livro.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirLivro(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarLivroPorId(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        Livro livro = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String autor = rs.getString("autor");
                LocalDate dataCriacao = rs.getDate("data_criacao").toLocalDate();
                Status status = Status.valueOf(rs.getString("status"));

                livro = new Livro(id, nome, autor, dataCriacao, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livro;
    }
}
