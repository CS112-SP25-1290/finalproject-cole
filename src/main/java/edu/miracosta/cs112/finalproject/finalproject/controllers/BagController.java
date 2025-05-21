package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.BattleManager;
import edu.miracosta.cs112.finalproject.finalproject.BotPlayer;
import edu.miracosta.cs112.finalproject.finalproject.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BagController {
    private final BattleManager manager = BattleManager.getInstance();
    private Player userPlayer = manager.getUserPlayer();
    private BotPlayer botPlayer = manager.getBotPlayer();

    @FXML
    private Pane root;

    @FXML
    private Button potion1Button, potion2Button;

    @FXML
    private TextField potion1Text, potion2Text;

    @FXML
    public void handlePotion1() {
        int potionsLeft = this.userPlayer.getPotions()[0].getPotionsLeft();
        if(potionsLeft > 0) {
            this.manager.playerHeal(0);
            try {
                loadBattleScene();
            } catch (Exception e) {
                System.out.println();
            }
        }
    }

    public void handlePotion2() {
        int potionsLeft = this.userPlayer.getPotions()[1].getPotionsLeft();
        if(potionsLeft > 0) {
            this.manager.playerHeal(1);
            try {
                loadBattleScene();
            } catch (Exception e) {
                System.out.println();
            }
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

    public void initBagScene() {
        this.userPlayer = manager.getUserPlayer();
        this.botPlayer = manager.getBotPlayer();
        potion1Text.setText(userPlayer.getPotions()[0].getPotionsLeft() + " / " + userPlayer.getPotions()[0].getPotionsMax());
        potion2Text.setText(userPlayer.getPotions()[1].getPotionsLeft() + " / " + userPlayer.getPotions()[1].getPotionsMax());
    }
}
