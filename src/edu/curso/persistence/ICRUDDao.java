package edu.curso.persistence;

import java.util.List;

import edu.curso.exceptions.LivroException;

public interface ICRUDDao<T> {
    
    public void inserir(T t) throws LivroException;
    public void modificar(T t)throws LivroException;
    public void deletar(T t)throws LivroException;
    public List<T> buscar(String t)throws LivroException;
}
