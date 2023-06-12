package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class registerController implements Initializable {

    Stage stage;
    @FXML
    public TextField txt_name;
    @FXML
    public TextField txt_secname;
    @FXML
    public TextField txt_nick;
    @FXML
    public TextField txt_age;
    @FXML
    public ComboBox cmb_gender;
    @FXML
    public TextField txt_email;
    @FXML
    public TextField txt_pass;
    @FXML
    public TextField txt_pass2;
    @FXML
    public Button btn_cad;
    @FXML
    public Button btn_ret;
    @FXML
    public Button btn_exit;


    private final Idatabase db = databaseFactory.getDatabase("mysql");
    private final Connection conn = db != null ? db.connect() : null;
    private final trainerDAO trainerDAO = new trainerDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trainerDAO.setConn(conn);
        cmb_gender.getItems().addAll("Masculino", "Feminino", "Outros");
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

    @FXML
    private void btnRetOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/loginView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnCadOnClick(ActionEvent event) {
        trainer t = new trainer(null,txt_name.getText() + " " + txt_secname.getText(), txt_nick.getText(), txt_email.getText(), txt_pass.getText(), Integer.parseInt(txt_age.getText()), cmb_gender.getValue().toString(), 40000.0);
        trainerDAO.saveTrainer(t);
    }
}
