package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.BattleManager;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.Player;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class BattleController {
    private final BattleManager manager = BattleManager.getInstance();
    private Player userPlayer = manager.getUserPlayer();
    private BotPlayer botPlayer = manager.getBotPlayer();

    @FXML
    private Button fightButton, healButton, pokemonButton, runButton;

    @FXML
    ImageView userPokemonImage, botPokemonImage;

    @FXML
    TextField healCountText;

    @FXML
    ProgressBar userHPProgressBar, botHPProgressBar;

    @FXML
    private void handleFight() throws IOException {
        loadAttackScene();
    }

    @FXML
    private void handleHeal() throws IOException {
        loadBagScene();
    }

    @FXML
    private void handlePokemon() throws IOException{
        loadPokemonScene();
    }

    @FXML
    private void handleRun() {
        System.exit(0);
    }

    @FXML
    public void setUserPokemonImage() {
        userPokemonImage.setImage(new Image(getClass().getResourceAsStream(userPlayer.getCurrentPokemon().getImagePath())));
    }

    @FXML
    public void setBotPokemonImage() {
        botPokemonImage.setImage(new Image(getClass().getResourceAsStream(botPlayer.getCurrentPokemon().getImagePath())));
    }

//    public void setHealText() {
//        healCountText.setText(userPlayer.getPotionsCount() + " / " + userPlayer.getMaxPotionsCount());
//    }

    public void loadAttackScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/attack-scene.fxml"));
        Parent root = loader.load();

        AttackController controller = loader.getController();
        controller.initAttackScene();

        Stage window = (Stage) fightButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void loadBagScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/bag-scene.fxml"));
        Parent root = loader.load();

        BagController controller = loader.getController();
        controller.initBagScene();

        Stage window = (Stage) healButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void loadPokemonScene() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/pokemon-scene.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.initPokemonScene();

        Stage window = (Stage) pokemonButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void updateUserHPBar() {
        float newHP = (float) userPlayer.getCurrentPokemon().getHp() / userPlayer.getCurrentPokemon().getMaxHP();
        double currentProgress = userHPProgressBar.getProgress();

        newHP = Math.max(0f, Math.min(newHP, 1f));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(userHPProgressBar.progressProperty(), newHP))
        );
        timeline.play();
    }

    public void updateBotHPBar() {
        float newHP = (float) botPlayer.getCurrentPokemon().getHp() / botPlayer.getCurrentPokemon().getMaxHP();
        double currentProgress = botHPProgressBar.getProgress();

        newHP = Math.max(0f, Math.min(newHP, 1f));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(botHPProgressBar.progressProperty(), newHP))
        );
        timeline.play();
    }

    public void initBattleScene() {
        this.userPlayer = manager.getUserPlayer();
        this.botPlayer = manager.getBotPlayer();
        this.setUserPokemonImage();
        this.setBotPokemonImage();
//        this.setHealText();
        this.updateUserHPBar();
        this.updateBotHPBar();
    }
}
