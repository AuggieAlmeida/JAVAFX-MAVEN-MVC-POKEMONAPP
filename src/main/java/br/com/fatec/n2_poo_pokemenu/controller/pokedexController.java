package br.com.fatec.n2_poo_pokemenu.controller;

import br.com.fatec.n2_poo_pokemenu.Application;
import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;
import br.com.fatec.n2_poo_pokemenu.services.pokemonApiClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class pokedexController {
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
    Stage stage;

    private pokemon srchPokemon(){
        try {
            pokemonApiClient apiClient = new pokemonApiClient();
            int pokemonId = 25; // ID do Pokémon desejado

            pokemon pokemonInfo = apiClient.getPokemonInfo(pokemonId);
            if (pokemonInfo != null) {
                System.out.println("ID: " + pokemonInfo.getId());
                System.out.println("Nome: " + pokemonInfo.getName());
                System.out.println("Peso: " + pokemonInfo.getWeight());
                System.out.println("Altura: " + pokemonInfo.getHeight());
                System.out.println("Tipos: " + Arrays.toString(pokemonInfo.getTypes()));
            } else {
                System.out.println("Não foi possível obter as informações do Pokémon.");
            }
            return pokemonInfo;
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro durante a solicitação do Pokémon: " + e.getMessage());
        }
        return null;
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
