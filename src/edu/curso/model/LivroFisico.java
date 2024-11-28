package edu.curso.model;

import java.time.LocalDate;

public class LivroFisico extends Livro {
    private String editora;

    public LivroFisico(String nome, String autor, LocalDate dataLancamento, String editora, long codigo) {
            super(codigo, nome, autor, dataLancamento);
        this.editora = editora;
    }

    public LivroFisico() {
        super();
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
 
}
