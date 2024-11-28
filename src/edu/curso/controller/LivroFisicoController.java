package edu.curso.controller;

import java.time.LocalDate;

import edu.curso.exceptions.LivroException;
import edu.curso.model.LivroFisico;
import edu.curso.persistence.LivroFisicoDao;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroFisicoController implements IController<LivroFisico>{
    private ObservableList<LivroFisico> livrosFisicos = FXCollections.observableArrayList();
    

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty autor = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataLancamento = new SimpleObjectProperty<>(LocalDate.now());
    private StringProperty editora = new SimpleStringProperty("");

    private LivroFisicoDao lDao;
    
    public LivroFisicoController() throws LivroException {
        lDao = new LivroFisicoDao();
        listar();
    }

    @Override
    public void gravar() throws LivroException {
        LivroFisico livro = paraEntidade();

        //Grava
        if (livro.getCodigo() == 0) {
            lDao.inserir(livro);
        } else {
            lDao.modificar(livro);
        }

        listar();
    }
                
    @Override
    public void deletar(LivroFisico t) throws LivroException {
        lDao.deletar(t);
        listar();
    }
    
    @Override
    public void buscar() throws LivroException {
        livrosFisicos.clear();
        livrosFisicos.addAll(lDao.buscar(nome.get()));
    }
    
    @Override
    public void listar() throws LivroException {
        livrosFisicos.clear();
        livrosFisicos.addAll(lDao.buscar(""));
    }
    
    public void limpar(){
        id.set(0);
        nome.set("");
        autor.set("");
        dataLancamento.set(null);
        editora.set("");
    }

    public void paraTela(LivroFisico livro){
        if (livro != null) {
            id.set(livro.getCodigo());
            nome.set(livro.getNome());
            autor.set(livro.getAutor());
            dataLancamento.set(livro.getDataLancamento());
            editora.set(livro.getEditora());
        }
    }

    private LivroFisico paraEntidade() {
        LivroFisico livro = new LivroFisico();
        livro.setCodigo(id.get());
        livro.setNome(nome.get());
        livro.setAutor(autor.get());
        livro.setDataLancamento(dataLancamento.get());
        livro.setEditora(editora.get());

        return livro;
    }

    public LongProperty getId() { 
        return id;
    }
    public StringProperty getNome() { 
        return nome;
    }
    public StringProperty getAutor(){
        return autor;
    }

    public ObjectProperty<LocalDate> getDataLancamento() {
        return dataLancamento;
    }

    public StringProperty getEditora() {
        return editora;
    }

    public ObservableList<LivroFisico> getLivrosFisicos() {
        return livrosFisicos;
    }

    
    
}
