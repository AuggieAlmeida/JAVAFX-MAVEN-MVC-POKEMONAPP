package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;
import br.com.fatec.n2_poo_pokemenu.services.pokemonApiClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    Stage stage;
    @FXML
    public TextField txt_email;
    @FXML
    public TextField txt_pass;
    @FXML
    public Button btn_log;
    @FXML
    public Button btn_cad;
    @FXML
    public Button btn_exit;
    @FXML
    public Label lb_auth;


    private final Idatabase db = databaseFactory.getDatabase("mysql");
    private final Connection conn = db != null ? db.connect() : null;
    private final trainerDAO trainerDAO = new trainerDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trainerDAO.setConn(conn);
    }

    /**
     * Fechar janela
     * @param event
     */
    @FXML
    private void handleExitAction(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Botão para realizar o login
     * @param event
     */
    @FXML
    private void btnLoginOnClick(ActionEvent event){
        System.out.println(conn + "\n\n");
        if(trainerDAO.findByLogin(txt_email.getText(), txt_pass.getText())){
            try {
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/menuView.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            lb_auth.setText("Usuário ou senha incorretos");
        }
    }

    @FXML
    private void btnCadOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/registerView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
