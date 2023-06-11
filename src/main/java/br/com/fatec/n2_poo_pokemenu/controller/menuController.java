package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    Stage stage;
    @FXML
    public Button btn_pokedex;
    @FXML
    public Button btn_trainer;
    @FXML
    public Button btn_party;
    @FXML
    public Button btn_bag;
    @FXML
    public Button btn_social;
    @FXML
    public Button btn_config;
    @FXML
    public Button btn_exit;
    @FXML
    public Button btn_menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnPokedexOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/registerView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnTrainerOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/trainerView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
