package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class socialController implements Initializable {
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
    @FXML
    public TextField txt_name;
    @FXML
    public Label txt_nickname;
    @FXML
    public Button btn_cln;
    @FXML
    public Button btn_play;
    @FXML
    public Button btn_list;
    @FXML
    public TableView<trainer> tableView;
    @FXML
    public TableColumn<trainer, String> columnID;
    @FXML
    public TableColumn<trainer, String> columnName;
    @FXML
    public TableColumn<trainer, String> columnNick;
    @FXML
    public TableColumn<trainer, String> columnEmail;
    @FXML
    public TableColumn<trainer, String> columnIdade;
    @FXML
    public TableColumn<trainer, LocalDate> columnReg;
    private Stage stage;

    private final Idatabase db = databaseFactory.getDatabase("mysql");
    private final Connection conn = db != null ? db.connect() : null;
    private final trainerDAO trainerDAO = new trainerDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainerDAO.setConn(conn);
        handleLoadTable();
    }

    public void handleLoadTable(){
        ObservableList<trainer> trainers = FXCollections.observableArrayList();
        trainers.addAll(trainerDAO.selectAllTrainers());
        tableView.setItems(trainers);


        columnID.setCellValueFactory(new PropertyValueFactory<>("trainerId"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnNick.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnIdade.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnReg.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    
    @FXML
    private void handleExitAction(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
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
