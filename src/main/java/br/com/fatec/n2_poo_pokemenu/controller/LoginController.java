package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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

    @FXML
    private void handleExitAction(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnLoginOnClick(ActionEvent event){
        System.out.println(conn + "\n\n");
        trainerDAO.findByLogin(txt_email.getText(), txt_pass.getText());
        lb_auth.setText("Alo");
    }
}
