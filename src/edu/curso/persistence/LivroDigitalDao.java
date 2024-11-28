package edu.curso.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.exceptions.LivroException;
import edu.curso.model.LivroDigital;

public class LivroDigitalDao implements ICRUDDao<LivroDigital> {
   
    Connection con = null;
    
    public LivroDigitalDao() throws LivroException {
        con = GenericDao.createConnection();
    }


    @Override
    public void modificar(LivroDigital t) throws LivroException {
        try {
            String sql = """
                    UPDATE livrosDigitais SET nome = ?, autor = ?, lancamento = ?, formato = ?
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, t.getNome());
            stm.setString(2, t.getAutor());
            stm.setDate(3, java.sql.Date.valueOf(t.getDataLancamento()));
            stm.setString(4, t.getFormato());
            stm.setLong(6, t.getCodigo());

            int i =stm.executeUpdate();
            System.out.println(i);
            
        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public void deletar(LivroDigital t) throws LivroException {
        try {
            String sql = """
                    DELETE FROM livrosDigitais WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, t.getCodigo());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public List<LivroDigital> buscar(String nome) throws LivroException {
        List<LivroDigital> livros = new ArrayList<>();

        try {
            String sql = """
                    SELECT * FROM livrosDigitais WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LivroDigital livro = new LivroDigital();
                livro.setCodigo(rs.getLong("id"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setDataLancamento(rs.getDate("lancamento").toLocalDate());
                livro.setFormato(rs.getString("formato"));
                
                livros.add(livro);
            } 

            return livros;

        } catch (SQLException e) {
            throw new LivroException(e);
        }
    }

    @Override
    public void inserir(LivroDigital t) throws LivroException {
        try {
            String sql = """
                    INSERT INTO livrosDigitais (nome, autor, lancamento, formato)
                    VALUES (?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
           
            stm.setString(1, t.getNome());
            stm.setString(2, t.getAutor());
            stm.setDate(3, java.sql.Date.valueOf(t.getDataLancamento()));
            stm.setString(4, t.getFormato());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new LivroException(e);
        }    
    }

}
