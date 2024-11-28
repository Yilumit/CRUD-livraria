package edu.curso.controller;

import edu.curso.exceptions.LivroException;

public interface IController<T> {
    public void gravar() throws LivroException;
    public void deletar(T t) throws LivroException;
    public void buscar() throws LivroException;
    public void listar() throws LivroException;
}
