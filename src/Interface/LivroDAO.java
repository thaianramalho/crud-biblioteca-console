package Interface;

import java.util.List;
import Model.Livro;

public interface LivroDAO {
    void addLivro(Livro livro) throws DAOException;
    void removeLivro(int id) throws DAOException;
    Livro getLivro(int id) throws DAOException;
    List<Livro> getAllLivros() throws DAOException;
}
