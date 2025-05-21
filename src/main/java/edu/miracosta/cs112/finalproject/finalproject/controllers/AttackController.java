package edu.miracosta.cs112.finalproject.finalproject.controllers;
import edu.miracosta.cs112.finalproject.finalproject.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class AttackController {
    private final BattleManager manager = BattleManager.getInstance();
    private Player userPlayer;
    private BotPlayer botPlayer;

    @FXML
    private Pane root;

    @FXML
    Button attack1Button, attack2Button, attack3Button, attack4Button;

    @FXML
    TextField attack1Text, attack2Text, attack3Text, attack4Text;

    @FXML
    private void handleAttack1 () {
        manager.playerAttack(0);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack2 () {
        manager.playerAttack(1);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack3 () {
        manager.playerAttack(2);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleAttack4 () {
        manager.playerAttack(3);
        try {
            loadBattleScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        // Wait until scene is available to set key listener
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

    public void loadBattleScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/battle-scene.fxml"));
        Parent newRoot = loader.load();

        BattleController battleController = loader.getController();
        battleController.initBattleScene();

        Stage window = (Stage) root.getScene().getWindow();
        try {
            window.setScene(new Scene(newRoot));
        } catch (Exception e) {
            System.out.println();
        }
    }

    public void updateAttackButtons() {
        if (userPlayer != null && userPlayer.getCurrentPokemon() != null) {
            AttackMove[] moves = userPlayer.getCurrentPokemon().getMoveSet(); // Assume this returns 4 strings
            attack1Button.setText(moves[0].getAttackName());
            attack1Button.setStyle(getStyle(moves[0]));
            attack1Text.setText(moves[0].getAttacksLeft() + " / " + moves[0].getMaxAttackCount());
            attack2Button.setText(moves[1].getAttackName());
            attack2Button.setStyle(getStyle(moves[1]));
            attack2Text.setText(moves[1].getAttacksLeft() + " / " + moves[1].getMaxAttackCount());
            attack3Button.setText(moves[2].getAttackName());
            attack3Button.setStyle(getStyle(moves[2]));
            attack3Text.setText(moves[2].getAttacksLeft() + " / " + moves[2].getMaxAttackCount());
            attack4Button.setText(moves[3].getAttackName());
            attack4Button.setStyle(getStyle(moves[3]));
            attack4Text.setText(moves[3].getAttacksLeft() + " / " + moves[3].getMaxAttackCount());
        }
    }


    public String getStyle(AttackMove move) {
        if(move.getType().equals("Fire")) {
            return "-fx-background-color: #ef3939; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #c12d2d;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        if(move.getType().equals("Water")) {
            return "-fx-background-color: #638bcc; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #5274aa;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        if(move.getType().equals("Grass")) {
            return "-fx-background-color: #5ab429; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #4a9823;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
        }
        return "-fx-background-color: #949494; -fx-text-fill: white; -fx-font-size: 30px; -fx-border-color: #7a7a7a;  -fx-border-width: 4px; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);";
    }

    public void initAttackScene() {
        this.userPlayer = manager.getUserPlayer();
        this.botPlayer = manager.getBotPlayer();
        this.updateAttackButtons();
    }
}
