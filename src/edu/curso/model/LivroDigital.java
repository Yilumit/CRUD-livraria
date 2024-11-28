package edu.curso.model;

import java.time.LocalDate;

public class LivroDigital extends Livro{
    private String formato;

    public LivroDigital(String nome, String autor, LocalDate dataLancamento, String formato, long codigo) {
            super(codigo, nome, autor, dataLancamento);
        this.formato = formato;
    }

    public LivroDigital() {
        super();
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }


}
