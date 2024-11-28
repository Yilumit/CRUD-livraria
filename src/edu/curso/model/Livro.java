package edu.curso.model;

import java.time.LocalDate;

public abstract class Livro {
    private long codigo;
    private String nome;
    private String autor;
    private LocalDate dataLancamento;

    public Livro(long codigo, String nome, String autor, LocalDate dataLancamento) {
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
    }

    
    public Livro() {
        super();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public long getCodigo() {
        return codigo;
    }


    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }  

    
    
}
