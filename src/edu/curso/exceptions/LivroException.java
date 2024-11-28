package edu.curso.exceptions;

public class LivroException extends Exception{

    public LivroException(Exception e) {
        System.err.println(e);
    }

}
