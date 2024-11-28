package edu.curso.boundary;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainBoundary extends Application{
    private Map<String, ITela> telas = new HashMap<>();
    
    @Override
    public void start(Stage stage) {
        telas.put("fisico", new LivroFisicoBoundary());
        telas.put("digital", new LivroDigitalBoundary());

        
        BorderPane panePrincipal = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu menuLivros = new Menu("Cadastro de Livros");
        MenuItem itemFisico = new MenuItem("Livro Fisico");
        MenuItem itemDigital = new MenuItem("Livro Digital");

        itemFisico.setOnAction(e -> panePrincipal.setCenter(telas.get("fisico").render()));
        itemDigital.setOnAction(e -> panePrincipal.setCenter(telas.get("digital").render()));

        menuLivros.getItems().addAll(itemFisico, itemDigital);

        menuBar.getMenus().addAll(menuLivros);

        panePrincipal.setTop(menuBar);

        Scene scn = new Scene(panePrincipal, 800, 650);
        stage.setScene(scn);
        stage.setTitle("Sistema de Consulta de Livros");
        stage.show();    
    }

    public static void main(String[] args) {
        Application.launch(MainBoundary.class, args);
    }

}