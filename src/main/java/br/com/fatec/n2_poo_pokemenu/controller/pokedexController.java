package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.dao.pokemon.pokemonDAO;
import br.com.fatec.n2_poo_pokemenu.model.database.Idatabase;
import br.com.fatec.n2_poo_pokemenu.model.database.databaseFactory;
import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.ResourceBundle;


public class pokedexController implements Initializable {
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
    public Label txt_id;
    @FXML
    public Label txt_att;
    @FXML
    public Label txt_wgt;
    @FXML
    public Label txt_hgt;
    @FXML
    public TextField txt_src;
    @FXML
    public Button btn_src;
    @FXML
    public Label txt_pt;
    @FXML
    public TableView<pokemon> tableView;
    @FXML
    public TableColumn<pokemon, Integer> idColumn;
    @FXML
    public TableColumn<pokemon, String> nameColumn;
    @FXML
    public TableColumn<pokemon, String> atbColumn;
    @FXML
    public TableColumn<pokemon, Float> wgtColumn;
    @FXML
    public TableColumn<pokemon, Float> hgtColumn;
    Stage stage;

    private final Idatabase db = databaseFactory.getDatabase("mysql");
    private final Connection conn = db != null ? db.connect() : null;
    private final pokemonDAO pokemonDAO = new pokemonDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pokemonDAO.setConn(conn);
        handleLoadTable();
        txt_pt.setText(pokemonDAO.getPokemonList().toString().replace("[", ""). replace("]", ""));
    }

    public void handleLoadTable(){
        ObservableList<pokemon> pokemons = FXCollections.observableArrayList();
        pokemons.addAll(pokemonDAO.getAllPokemon());
        tableView.setItems(pokemons);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        atbColumn.setCellValueFactory(cellData -> {
            pokemon p = cellData.getValue();
            String types = String.join(", ", p.getTypes());
            return new SimpleStringProperty(types);
        });

        wgtColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        hgtColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
    }

    @FXML
    public void btnRmvOnClick(ActionEvent event) {
        pokemonDAO.removePokemonFromList(txt_src.getText());
        txt_pt.setText(pokemonDAO.getPokemonList().toString().replace("[", ""). replace("]", ""));
    }

    @FXML
    public void btnCapOnClick(ActionEvent event) {
        pokemon selectedPokemon = tableView.getSelectionModel().getSelectedItem();

        if (selectedPokemon != null) {
            int id = selectedPokemon.getId();
            String name = selectedPokemon.getName();
            float weight = selectedPokemon.getWeight();
            float height = selectedPokemon.getHeight();
            String[] types = selectedPokemon.getTypes();

            txt_id.setText(String.valueOf(id));
            txt_src.setText(name);
            txt_hgt.setText("Altura: " + height + " feets");
            txt_wgt.setText("Peso: " + weight + " pounds");
            txt_att.setText(Arrays.toString(types).replace("[", ""). replace("]", ""));

            pokemonDAO.savePokemon(selectedPokemon);
            txt_pt.setText(pokemonDAO.getPokemonList().toString().replace("[", ""). replace("]", ""));
        }


    }

    @FXML
    public void tblPokeOnClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            TableView<pokemon> table = (TableView<pokemon>) event.getSource();
            pokemon selectedPokemon = table.getSelectionModel().getSelectedItem();

            if (selectedPokemon != null) {
                int id = selectedPokemon.getId();
                String name = selectedPokemon.getName();
                float weight = selectedPokemon.getWeight();
                float height = selectedPokemon.getHeight();
                String[] types = selectedPokemon.getTypes();

                // Faça o que for necessário com os valores obtidos
                txt_id.setText(String.valueOf(id));
                txt_src.setText(name);
                txt_hgt.setText("Altura: " + height + " feets");
                txt_wgt.setText("Peso: " + weight + " pounds");
                txt_att.setText(Arrays.toString(types).replace("[", ""). replace("]", ""));
            }
        }
    }


    private void srchPokemon(){
        ObservableList<pokemon> pokemons = FXCollections.observableArrayList();
        pokemons.addAll(pokemonDAO.searchPokemon(txt_src.getText()));

        tableView.setItems(pokemons);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        atbColumn.setCellValueFactory(cellData -> {
            TableColumn.CellDataFeatures<pokemon, String> cellDataFeatures = (TableColumn.CellDataFeatures<pokemon, String>) cellData;
            pokemon p = cellDataFeatures.getValue();
            String types = String.join(", ", p.getTypes());
            return new SimpleStringProperty(types);
        });

        wgtColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        hgtColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
    }

    @FXML
    private void btnSrcOnClick(ActionEvent event) {
        srchPokemon();
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
