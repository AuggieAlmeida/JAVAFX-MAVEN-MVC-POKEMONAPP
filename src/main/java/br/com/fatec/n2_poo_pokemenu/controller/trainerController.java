package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
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
import java.util.ResourceBundle;

public class trainerController implements Initializable {
    Stage stage;
    @FXML
    public Button btn_exit;
    @FXML
    public Button btn_menu;
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
    public Label txt_name;
    @FXML
    public TextField txt_updtname;
    @FXML
    public Label txt_nickname;
    @FXML
    public TextField txt_updtNickname;
    @FXML
    public Label txt_id;
    @FXML
    public Label txt_email;
    @FXML
    public TextField txt_updtEmail;
    @FXML
    public Label txt_money;
    @FXML
    public TextField txt_updtMoney;
    @FXML
    public TextField txt_updtAge;
    @FXML
    public Label txt_party;
    @FXML
    public Label txt_social;
    @FXML
    public Label txt_date;
    @FXML
    public Label txt_gender;
    @FXML
    public Label txt_age;
    @FXML
    public Button btn_delete;
    @FXML
    public Button btn_exchange;
    @FXML
    public Button btn_update;


    private final Idatabase db = databaseFactory.getDatabase("mysql");
    private final Connection conn = db != null ? db.connect() : null;
    private final trainerDAO trainerDAO = new trainerDAO();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainerDAO.setConn(conn);
        handleLabelLoad();
    }

    public void handleLabelLoad(){
        trainer t = trainerDAO.getTrainerById(Integer.parseInt(System.getProperty("logged")));
        txt_id.setText(String.valueOf(t.getTrainerId()));
        txt_name.setText(t.getName());
        txt_nickname.setText(t.getNickname());
        txt_email.setText(t.getEmail());
        txt_money.setText(String.valueOf(t.getMoney()));
        txt_party.setText("PARTY:\t\t\t\t0/6");
        txt_social.setText("SOCIAL:\t\t\t\t0");
        txt_date.setText("Criado em:\t\t" + t.getDate());
        txt_age.setText(String.valueOf(t.getAge()));
        txt_gender.setText(t.getGender());

    }
    @FXML
    private void handleExitAction(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnDelOnClick(ActionEvent event) {
        trainerDAO.deleteTrainer();
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
    private void btnExcOnClick(ActionEvent event) {
        if(txt_updtMoney.isVisible()) {
            txt_updtMoney.setVisible(false);
            trainer t = new trainer(Integer.parseInt(txt_id.getText()), txt_name.getText(), txt_nickname.getText(), txt_email.getText(), "...", Integer.parseInt(txt_age.getText()), txt_gender.getText(), Double.parseDouble(txt_updtMoney.getText()));
            trainerDAO.updateTrainer(t);
            handleLabelLoad();
        } else {
            txt_updtMoney.setVisible(true);
            txt_updtMoney.setText(txt_money.getText());
        }
    }

    @FXML
    private void btnUpdtOnClick(ActionEvent event) {
        if(txt_updtname.isVisible()) {
            txt_updtname.setVisible(false);
            txt_updtNickname.setVisible(false);
            txt_updtEmail.setVisible(false);
            txt_updtAge.setVisible(false);
            trainer t = new trainer(Integer.parseInt(txt_id.getText()), txt_updtname.getText(), txt_updtNickname.getText(), txt_updtEmail.getText(), "...", Integer.parseInt(txt_updtAge.getText()), txt_gender.getText(), Double.parseDouble(txt_money.getText()));
            trainerDAO.updateTrainer(t);
            handleLabelLoad();
        } else {
            txt_updtname.setVisible(true);
            txt_updtname.setText(txt_name.getText());
            txt_updtNickname.setVisible(true);
            txt_updtNickname.setText(txt_nickname.getText());
            txt_updtEmail.setVisible(true);
            txt_updtEmail.setText(txt_updtEmail.getText());
            txt_updtAge.setVisible(true);
            txt_updtAge.setText(txt_age.getText());
        }
    }

    @FXML
    private void btnMenuOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/menuView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnPokedexOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/pokedexView.fxml"));
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

    @FXML
    private void btnPartyOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/partyView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnBagOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/bagView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnSocialOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/socialView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void btnConfigOnClick(ActionEvent event) {
        try {
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("view/configView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
