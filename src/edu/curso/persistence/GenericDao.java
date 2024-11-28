package edu.curso.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.curso.exceptions.LivroException;

public class GenericDao {
    
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/livrariadb?allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";

    private static Connection con = null;

    public static Connection createConnection() throws LivroException {
        try {
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new LivroException(e);
        }
        return con;
    }

}
