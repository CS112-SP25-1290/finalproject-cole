package edu.miracosta.cs112.finalproject.finalproject.controllers;
import edu.miracosta.cs112.finalproject.finalproject.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class PokemonController {
    private final BattleManager manager = BattleManager.getInstance();
    private Player userPlayer = manager.getUserPlayer();
    private BotPlayer botPlayer = manager.getBotPlayer();

    @FXML
    private Pane root;

    @FXML
    private Button pokemon1Button, pokemon2Button, pokemon3Button, pokemon4Button, pokemon5Button, pokemon6Button;

    @FXML
    private ImageView pokemonImage1, pokemonImage2, pokemonImage3, pokemonImage4, pokemonImage5, pokemonImage6;

    @FXML
    private ProgressBar pokemon1PB, pokemon2PB, pokemon3PB, pokemon4PB, pokemon5PB, pokemon6PB;

    @FXML
    private void handlePokemon1() {
        Pokemon pokemon = userPlayer.getPokemons()[0];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    private void handlePokemon2() {
        Pokemon pokemon = userPlayer.getPokemons()[1];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    private void handlePokemon3() {
        Pokemon pokemon = userPlayer.getPokemons()[2];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    private void handlePokemon4() {
        Pokemon pokemon = userPlayer.getPokemons()[3];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    private void handlePokemon5() {
        Pokemon pokemon = userPlayer.getPokemons()[4];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    private void handlePokemon6() {
        Pokemon pokemon = userPlayer.getPokemons()[5];
        if(manager.checkAlive(pokemon)) {
            userPlayer.setCurrentPokemon(pokemon);
            try {
                loadBattleScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(pokemon.getName() + " is knocked out");
        }
    }

    @FXML
    public void initialize() {
        root.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        try {
                            loadBattleScene();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }

    public void loadBattleScene () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent newRoot = loader.load();

        BattleController battleController = loader.getController();
        battleController.initBattleScene();

        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(newRoot));
    }

    public void updatePokemonButtons() {
        if (userPlayer != null && userPlayer.getPokemons() != null) {
            Pokemon[] pokemons = userPlayer.getPokemons(); // Assume this returns 4 strings

            pokemon1Button.setText(pokemons[0].getName());
            pokemonImage1.setImage(new Image(getClass().getResourceAsStream(pokemons[0].getImagePath())));
            updatePokemonHB(pokemon1PB, pokemons[0]);
//            pokemon1Button.setStyle(getStyle(pokemons[0]));
            pokemon2Button.setText(pokemons[1].getName());
            pokemonImage2.setImage(new Image(getClass().getResourceAsStream(pokemons[1].getImagePath())));
            updatePokemonHB(pokemon2PB, pokemons[1]);
//            pokemon2Button.setStyle(getStyle(pokemons[1]));
            pokemon3Button.setText(pokemons[2].getName());
            pokemonImage3.setImage(new Image(getClass().getResourceAsStream(pokemons[2].getImagePath())));
            updatePokemonHB(pokemon3PB, pokemons[2]);
//            pokemon3Button.setStyle(getStyle(pokemons[2]));
            pokemon4Button.setText(pokemons[3].getName());
            pokemonImage4.setImage(new Image(getClass().getResourceAsStream(pokemons[3].getImagePath())));
            updatePokemonHB(pokemon4PB, pokemons[3]);
//            pokemon4Button.setStyle(getStyle(pokemons[3]));
            pokemon5Button.setText(pokemons[4].getName());
            pokemonImage5.setImage(new Image(getClass().getResourceAsStream(pokemons[4].getImagePath())));
            updatePokemonHB(pokemon5PB, pokemons[4]);
//            pokemon5Button.setStyle(getStyle(pokemons[4]));
            pokemon6Button.setText(pokemons[5].getName());
            pokemonImage6.setImage(new Image(getClass().getResourceAsStream(pokemons[5].getImagePath())));
            updatePokemonHB(pokemon6PB, pokemons[5]);
//            pokemon6Button.setStyle(getStyle(pokemons[5]));
        }
    }

    private void updatePokemonHB(ProgressBar pb, Pokemon pokemon) {
        float currentHP = (float) pokemon.getHp() / pokemon.getMaxHP();
        if(currentHP <= 0) {
            currentHP = 0.0f;
        }
        pb.setProgress(currentHP);
    }

    public String getStyle(Pokemon pokemon) {
        if(pokemon.getType().equals("Fire")) {
            return "-fx-background-color: #ef3939; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #c12d2d;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        if(pokemon.getType().equals("Water")) {
            return "-fx-background-color: #638bcc; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #5274aa;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        if(pokemon.getType().equals("Grass")) {
            return "-fx-background-color: #5ab429; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #4a9823;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        return "-fx-background-color: #949494; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #7a7a7a;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
    }

    public void initPokemonScene() {
        this.userPlayer = manager.getUserPlayer();
        this.botPlayer = manager.getBotPlayer();
        this.updatePokemonButtons();
    }
}
