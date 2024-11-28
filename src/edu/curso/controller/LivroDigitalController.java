package edu.curso.controller;

import java.time.LocalDate;

import edu.curso.exceptions.LivroException;
import edu.curso.model.LivroDigital;
import edu.curso.persistence.LivroDigitalDao;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroDigitalController implements IController<LivroDigital> {
    private ObservableList<LivroDigital> livrosDigitais = FXCollections.observableArrayList();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty autor = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataLancamento = new SimpleObjectProperty<>(LocalDate.now());
    private StringProperty formato = new SimpleStringProperty("");

    private LivroDigitalDao lDao;

    public LivroDigitalController() throws LivroException{
        lDao = new LivroDigitalDao();
        listar();
    }

    @Override
    public void gravar() throws LivroException {
        LivroDigital livro = paraEntidade();

        //Grava
        if (livro.getCodigo() == 0) {
            livro.setCodigo(livrosDigitais.size()+1);
            lDao.inserir(livro);
            // LivroFisicoController.setContador(contador);
        //Atualiza
        } else {
            lDao.modificar(livro);
        }

        listar();
    }

    @Override
    public void deletar(LivroDigital t) throws LivroException {
        lDao.deletar(t);
        listar();
    }

    @Override
    public void buscar() throws LivroException {
        livrosDigitais.clear();
        livrosDigitais.addAll(lDao.buscar(nome.get()));
    }

    @Override
    public void listar() throws LivroException {
        livrosDigitais.clear();
        livrosDigitais.addAll(lDao.buscar(""));
    }

    public void limpar(){
        id.set(0);
        nome.set("");
        autor.set("");
        dataLancamento.set(null);
        formato.set("");
    }

    public void paraTela(LivroDigital livro){
        if (livro != null) {
            id.set(livro.getCodigo());
            nome.set(livro.getNome());
            autor.set(livro.getAutor());
            dataLancamento.set(livro.getDataLancamento());
            formato.set(livro.getFormato());
        }
    }

    private LivroDigital paraEntidade() {
        LivroDigital livro = new LivroDigital();
        livro.setCodigo(id.get());
        livro.setNome(nome.get());
        livro.setAutor(autor.get());
        livro.setDataLancamento(dataLancamento.get());
        livro.setFormato(formato.get());

        return livro;
    }

    public ObservableList<LivroDigital> getLivrosDigitais() {
        return livrosDigitais;
    }

    public LongProperty getId() {
        return id;
    }

    public StringProperty getNome() {
        return nome;
    }

    public StringProperty getAutor() {
        return autor;
    }

    public ObjectProperty<LocalDate> getDataLancamento() {
        return dataLancamento;
    }

    public StringProperty getFormato() {
        return formato;
    }

    
}
