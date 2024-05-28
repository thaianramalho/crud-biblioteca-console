package Interface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Livro;

public class LivroDAOImpl implements LivroDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public LivroDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DAOException("Driver not found", e);
        }
    }

    @Override
    public void addLivro(Livro livro) throws DAOException {
        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("erro ao adicionar o livro livro", e);
        }
    }

    @Override
    public void removeLivro(int id) throws DAOException {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("erro ao remover o livro", e);
        }
    }

    @Override
    public Livro getLivro(int id) throws DAOException {
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                } else {
                    throw new DAOException("Livro not found");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("erro ao obter livro", e);
        }
    }

    @Override
    public List<Livro> getAllLivros() throws DAOException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor")));
            }
        } catch (SQLException e) {
            throw new DAOException("erro ao obter todos os livros", e);
        }
        return livros;
    }
}
