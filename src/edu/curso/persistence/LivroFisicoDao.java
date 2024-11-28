package edu.curso.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.exceptions.LivroException;
import edu.curso.model.LivroFisico;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class LivroFisicoDao implements ICRUDDao<LivroFisico>{

    Connection con = null;
    
    public LivroFisicoDao() throws LivroException {
        con = GenericDao.createConnection();
    }

    @Override
    public void inserir(LivroFisico t) throws LivroException {
        try {
            String sql = """
                    INSERT INTO livrosFisicos (nome, autor, lancamento, editora)
                    VALUES (?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, t.getNome());
            stm.setString(2, t.getAutor());
            stm.setDate(3, java.sql.Date.valueOf(t.getDataLancamento()));
            stm.setString(4, t.getEditora());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public void modificar(LivroFisico t) throws LivroException {
        try {
            String sql = """
                    UPDATE livrosFisicos SET nome = ?, autor = ?, lancamento = ?, editora = ?
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, t.getNome());
            stm.setString(2, t.getAutor());
            stm.setDate(3, java.sql.Date.valueOf(t.getDataLancamento()));
            stm.setString(4, t.getEditora());
            stm.setLong(5, t.getCodigo());

            stm.executeUpdate();
            
        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public void deletar(LivroFisico t) throws LivroException {
        try {
            String sql = """
                    DELETE FROM livrosFisicos WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);

            
            stm.setLong(1, t.getCodigo());
            System.out.println(t.getCodigo());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public List<LivroFisico> buscar(String nome) throws LivroException {
        List<LivroFisico> livros = new ArrayList<>();

        try {
            String sql = """
                    SELECT * FROM livrosFisicos WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LivroFisico livro = new LivroFisico();
                livro.setCodigo(rs.getLong("id"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setDataLancamento(rs.getDate("lancamento").toLocalDate());
                livro.setEditora(rs.getString("editora"));

                livros.add(livro);
            } 

            return livros;

        } catch (SQLException e) {
            new Alert(AlertType.ERROR, "Erro ao tentar buscar os livros!", ButtonType.OK).showAndWait();
            throw new LivroException(e);
        }
    }
    
}
